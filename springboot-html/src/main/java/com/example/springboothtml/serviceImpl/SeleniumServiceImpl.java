package com.example.springboothtml.serviceImpl;

import com.example.springboothtml.domain.ListData;
import com.example.springboothtml.model.MojingGetPo;
import com.example.springboothtml.model.MojingPostPo;
import com.example.springboothtml.service.SeleniumService;
import com.example.springboothtml.utils.ExcelUtils;
import com.google.gson.Gson;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class SeleniumServiceImpl implements SeleniumService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SeleniumServiceImpl.class);

    @Value("${querys.split}")
    private String split;

    @Autowired
    private WebDriver driver;

    @Autowired
    private RestTemplate restTemplate;

    // 魔镜接口
    private String MOJING_URL = "http://ext.moojing.com/item_info_get";

    @Override
    public ResponseEntity<List<ListData.Mods.Item.Data.Auction>> scrapHtml(String fileName, Integer startPage,
                                                                           Integer endPage, Boolean picture) {

        try {
            getSimpleQuery(fileName, startPage, endPage, picture, (ChromeDriver) driver);
        } catch (Exception e) {
            LOGGER.error("抓取失败", e);
        }

        LOGGER.info("采集数据的进程结束");
        return new ResponseEntity("操作结束", HttpStatus.OK);
    }

    /*单个关键字查询*/
    private void getSimpleQuery(String fileName, Integer startPage, Integer endPage, Boolean picture,
                                ChromeDriver driver) {
        LOGGER.info("采集信息方法");

        //最外层采集结果保存 最大值是2^32个产品信息
//        String q = driver.findElement(By.id("q")).getAttribute("value");
        List<ListData.Mods.Item.Data.Auction> resultList = new ArrayList<>();

        // 单页数据获取
        boolean flag = true;
        for (int page = startPage; page <= endPage; page++) {
            try {
                // 首次页面初始话
                flag = isFlag(driver, flag, page);

                getSimplePage(driver, resultList, page);
            } catch (Exception e) {
                LOGGER.error("页面 " + page + "出现异常", e);
            }
        }
        //excel存储工具
        excelAdapter(resultList, fileName, picture);

        //魔镜数据收集
        mojingInfo(resultList);
        LOGGER.info("采集信息结束");
    }

    private boolean isFlag(ChromeDriver driver, boolean flag, int page) {
        /*
         * 由于做了缓存driver，因此很多数据导致混乱
         * 因此需要在这里做首页初始化
         * */
        if (flag) {
            WebElement element = modelPersonTurnPage(driver);

            // 输入查询页数
            WebElement page_num_input = driver.findElementByCssSelector("div.form input.input.J_Input");
            page_num_input.clear();
            page_num_input.sendKeys(String.valueOf(page));
            try {
                TimeUnit.MILLISECONDS.sleep(new Random().nextInt(3000));
            } catch (InterruptedException e) {
                LOGGER.error("等待点击操作失败");
            }

            element.click();
            //等这个页面五秒钟缓冲时间
            driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        }
        return false;
    }

    /*单个页面查询*/
    private void getSimplePage(ChromeDriver driver, List<ListData.Mods.Item.Data.Auction> resultList, int page) {
        LOGGER.info("当前页面为<<{}>>", page);
        WebElement element = modelPersonTurnPage(driver);

        // 输入查询页数
        WebElement page_num_input = driver.findElementByCssSelector("div.form input.input.J_Input");
        page_num_input.clear();
        page_num_input.sendKeys(String.valueOf(page + 1));
        try {
            TimeUnit.MILLISECONDS.sleep(new Random().nextInt(3000));
        } catch (InterruptedException e) {
            LOGGER.error("等待点击操作");
        }

        element.click();
        //等这个页面五秒钟缓冲时间
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        convertConfiginfoToObj(driver, resultList, page);
    }

    /*
     * 将页面首部的数据转成对象
     * */
    private void convertConfiginfoToObj(ChromeDriver driver, List<ListData.Mods.Item.Data.Auction> resultList, int page) {
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        Document document = Jsoup.parse(driver.getPageSource());
        Element body = document.body();

        // 获取所有的item的信息
        Element itemCollection = body.getElementById("mainsrp-itemlist");
        // 所有的items
        List<Element> itemList = itemCollection.getElementsByAttributeValue("data-category", "auctions");

        for (Element item : itemList) {
            ListData.Mods.Item.Data.Auction auction = new ListData.Mods.Item.Data.Auction();
            Element data_src_alt = item.select("img.J_ItemPic.img").get(0);
            String pic_url = data_src_alt.attr("data-src");
            String raw_title = data_src_alt.attr("alt");
            auction.setPic_url(pic_url);
            auction.setRaw_title(raw_title);

            String view_price = item.select("div.row.row-1.g-clearfix").select("strong").html();
            String view_scales = item.select("div.row.row-1.g-clearfix").select("div.deal-cnt").html();
            auction.setView_price(view_price);
            auction.setView_sales(view_scales);

            String detail_url = item.select("div.row.row-2.title").select("a").attr("href");
            auction.setDetail_url(detail_url);
            String nid = item.select("div.row.row-2.title").select("a").attr("trace-nid");
            auction.setNid(nid);

            //String nick_name = item.select("div.row.row-3.g-clearfix").select("a.shopname span:eq(1)").html();
            String nick_url = item.select("div.row.row-3.g-clearfix").select("a.shopname").attr("href");
            auction.setShopLink(nick_url);

            String nick_name = item.select("div.row.row-4.g-clearfix").select("div.wangwang span").attr("data-nick");
            auction.setNick(nick_name);
            /*String commen_url = item.select("div.row.row-4.g-clearfix").select("div.wangwang span a").attr("href");
            auction.setComment_url(commen_url);*/

            List<Element> iconList = item.select("div.row.row-4.g-clearfix").select("ul.icons").select("li.icon");
            List<ListData.Mods.Item.Data.Auction.Icon> iconListInfo = new ArrayList<>();
            for (Element icon : iconList) {
                ListData.Mods.Item.Data.Auction.Icon icon_info = new ListData.Mods.Item.Data.Auction.Icon();
                String title = icon.select("a").attr("title");
                icon_info.setTitle(title);
                String dom_class = icon.select("a span").attr("class");
                icon_info.setDom_class(dom_class);
                iconListInfo.add(icon_info);
            }
            auction.setIcon(iconListInfo);
            resultList.add(auction);
        }


        /*五秒之上的时间随便选*/
        try {
            TimeUnit.MILLISECONDS.sleep(5000 + new Random().nextInt(5000));
        } catch (InterruptedException e) {
            LOGGER.error("对于下一个页面数据的抓取的休息时间报错");
        }
        LOGGER.info("当前页面为<<{}>>结束", page);
    }

    /*
     * 模仿翻页行为代码
     * */
    private WebElement modelPersonTurnPage(ChromeDriver driver) {
        /*
         * 模拟人互动网页的行为
         * 300-500  500-700 然后底部
         * */
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollBy(0, " + (300 + new Random().nextInt(200)) + ")");
        try {
            TimeUnit.MILLISECONDS.sleep(1000 + new Random().nextInt(1000));
        } catch (InterruptedException e) {
            LOGGER.error("模仿人鼠标行为滑动操作  出现异常");
        }
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollBy(0, " + (500 + new Random().nextInt(200)) + ")");
        try {
            TimeUnit.MILLISECONDS.sleep(1000 + new Random().nextInt(1000));
        } catch (InterruptedException e) {
            LOGGER.error("模仿人鼠标行为滑动操作  出现异常");
        }
        WebElement element = driver.findElementByCssSelector("span.btn.J_Submit");
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollBy(0, " + (element.getLocation().getY() - 100 + new Random().nextInt(20)) + ")");
        return element;
    }

    /*
     * excel的数据装饰器 不考虑代码重复问题  解耦代码
     * */
    @Async
    public void excelAdapter(List<ListData.Mods.Item.Data.Auction> resultList, String fileName, Boolean picture) {
        // 加载模板文件
        String userDir = System.getProperty("user.dir");
        /*String relativelyPath = String.format("%s/springboot-html/search/excel.xls", userDir);
        String reportPath = String.format("%s/springboot-html/search/%s.xls", userDir, fileName);*/
        String relativelyPath = String.format("%s/search/excel.xls", userDir);
        String reportPath = String.format("%s/excels/%s.xls", userDir, fileName);
        File file = new File(reportPath);
        try (InputStream fileInputStream = new FileInputStream(new File(relativelyPath));
             FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fileInputStream);
            hssfWorkbook = ExcelUtils.createDataSheet(hssfWorkbook, null, resultList, "数据分析抓取", picture);
            hssfWorkbook.write(fileOutputStream);
        } catch (FileNotFoundException e) {
            boolean delete = file.delete();
            LOGGER.info("删除临时文件{}", delete);
            LOGGER.error("读取模板文件失败", e);
        } catch (Exception e) {
            boolean delete = file.delete();
            LOGGER.info("删除临时文件 结果{}", delete);
            LOGGER.error("生成报表存储本地操作失败", e);
        }

    }

    /*
     * 重新打开登录页面窗口
     * */
    public ResponseEntity relogin() {
        driver = new ChromeDriver();
        // 最大化操作界面
        driver.manage().window().maximize();
        driver.get("https://login.taobao.com");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Autowired
    private ApplicationContext appContext;

    /*
     * 程序退出操作
     * */
    @Override
    public ResponseEntity exit() {
        SpringApplication.exit(appContext, (ExitCodeGenerator) () -> 6666);
        return new ResponseEntity(HttpStatus.OK);
    }

    /*魔镜关键字获取接口*/
    private void mojingInfo(List<ListData.Mods.Item.Data.Auction> resultList) {
        List<MojingGetPo> outer = new ArrayList<>();

        MojingPostPo mojingPostPo = new MojingPostPo();
        mojingPostPo.setInclude_mobile(true);
        mojingPostPo.setInclude_words(true);
        List<List<String>> items = new ArrayList<>();
        Iterator<ListData.Mods.Item.Data.Auction> auctionIterator = resultList.iterator();
        while (auctionIterator.hasNext()) {
            ListData.Mods.Item.Data.Auction auction = auctionIterator.next();
            List<String> item = new ArrayList<>();
            item.add(auction.getNick());
            item.add(auction.getNid());
            items.add(item);
            // 分发合适的数量进行请求
            if (items.size() % 44 == 0 || !auctionIterator.hasNext()) {
                mojingPostPo.setItems(items);
                ResponseEntity<MojingGetPo[]> responseEntity =
                                restTemplate.postForEntity(MOJING_URL, mojingPostPo, MojingGetPo[].class);
                if (responseEntity.getStatusCode().value() == HttpStatus.OK.value()) {
                    outer.addAll(Arrays.asList(responseEntity.getBody()));
                }
            }
        }
        System.out.println(outer.toString());
    }
}
