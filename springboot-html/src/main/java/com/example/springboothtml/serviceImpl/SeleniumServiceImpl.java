package com.example.springboothtml.serviceImpl;

import com.example.springboothtml.domain.ListData;
import com.example.springboothtml.service.SeleniumService;
import com.example.springboothtml.utils.ExcelUtils;
import com.google.gson.Gson;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class SeleniumServiceImpl implements SeleniumService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SeleniumServiceImpl.class);

    @Value("${querys.split}")
    private String split;

    @Override
    public ResponseEntity demoUse(String query) {
        Properties properties = System.getProperties();
        System.out.println(properties.propertyNames().toString());
        //这是我使用的是chrome  也可以使用其他的浏览器  但是需要对应的版本驱动器
        System.setProperty("webdriver.chrome.driver",
                        System.getProperty("user.dir") + "/springboot-html/chromedriver.exe");
        /*System.setProperty("webdriver.chrome.driver",
                        System.getProperty("user.dir") + "/chromedriver.exe");*/
        ChromeDriver driver = new ChromeDriver();
        //实现窗口最大化
        driver.manage().window().maximize();

        /*
        去他妈的先登陆
        * */
        driver.get("https://login.taobao.com/");

        /*
         * 二维码登录
         * */
        while (!driver.getCurrentUrl().contains("www.taobao.com")) {
            LOGGER.error("大爷   在等你扫码。。。。。");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                LOGGER.error("大爷的");
            }

        }

        driver.findElement(By.id("q")).sendKeys(query);
        driver.findElement(By.className("btn-search")).click();

        LOGGER.info("大爷你等会");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        String html_info = driver.getPageSource();

        Pattern pattern = Pattern.compile("g_page_config = .*?g_srp_loadCss", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(html_info);
        String info = "";
        while (matcher.find()) {
            info = matcher.group();
        }

        List<ListData.Mods.Item.Data.Auction> auctionList = new ArrayList<>();

        if (Objects.equals("", info)) {
            LOGGER.error("大爷的  出错了");
        } else {
            try {
                info = info.replace("g_page_config = ", "");
                info = info.substring(0, info.lastIndexOf(";"));
                Gson gson = new Gson();
                ListData listData = gson.fromJson(info, ListData.class);
                auctionList.addAll(listData.getMods().getItemlist().getData().getAuctions());
            } catch (Exception e) {
                LOGGER.error("大爷的  出错了");
            }
        }

        for (int i = 0; i < 10; i++) {
            LOGGER.info("大爷的  " + i + "次循环");
            String currentUrl = driver.getCurrentUrl();
            WebElement element = driver.findElementByCssSelector("span.btn.J_Submit");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            element.click();
            driver.manage().timeouts().pageLoadTimeout(10 + new Random().nextInt(10), TimeUnit.SECONDS);

            while (Objects.equals(driver.getCurrentUrl(), currentUrl)) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    LOGGER.error("大爷的  出错了");
                }
            }

            html_info = driver.getPageSource();
            matcher = pattern.matcher(html_info);

            while (matcher.find()) {
                info = matcher.group();
            }

            if (Objects.equals("", info)) {
                LOGGER.error("大爷的  出错了");
            } else {
                try {
                    info = info.replace("g_page_config = ", "");
                    info = info.substring(0, info.lastIndexOf(";"));
                    Gson gson = new Gson();
                    ListData listData = gson.fromJson(info, ListData.class);
                    auctionList.addAll(listData.getMods().getItemlist().getData().getAuctions());
                } catch (Exception e) {
                    LOGGER.error("大爷的  出错了");
                }
            }

        }

        ProductServiceImpl.excelAdapter(auctionList, query, true);

        driver.close();
        LOGGER.error("大爷的  终于结束于。。。。");
        return new ResponseEntity(html_info, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ListData.Mods.Item.Data.Auction>> scrapHtml(String query, Integer startPage,
                    Integer endPage, Integer sortType, Boolean picture) {

        /*等待用户登录操作结束*/
        ChromeDriver driver = loginOperation();
        LOGGER.info("进行登录结束", driver);

        /*分割查询指标信息*/
        String[] querys = query.split(split);

        // 循环抓取的关键字
        for (String q : querys) {
            try {
                getSimpleQuery(query, startPage, endPage, sortType, picture, driver, q);
            } catch (Exception e) {
                LOGGER.error("抓取关键字《《《" + q + "》》》失败", e);
            }
        }

        LOGGER.info("采集数据的进程结束");

        return new ResponseEntity("操作结束", HttpStatus.OK);
    }

    /*单个关键字查询*/
    private void getSimpleQuery(String query, Integer startPage, Integer endPage, Integer sortType, Boolean picture,
                    ChromeDriver driver, String q) {
        LOGGER.info("采集<<{}>>的信息", q);

        // 当前地址信息  判断是否进行了跳转操作
        String url_before = driver.getCurrentUrl();

        /*
         * 输入查询内容点击进行搜索
         * */
        driver.findElement(By.id("q")).sendKeys(query);
        driver.findElement(By.className("btn-search")).click();
        String current_url = driver.getCurrentUrl();
        // 是否进入查询首页
        while (Objects.equals(url_before, current_url)) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                LOGGER.error("判断是不是首页  等待异常。。。");
            }
        }
        // 如果是按照销量排序 点击一下页面
        try {
            TimeUnit.MILLISECONDS.sleep(1000 + new Random().nextInt(1000));
        } catch (InterruptedException e) {
            LOGGER.error("等一下");
        }
        if (sortType == 2) {
            List<WebElement> liElements = driver.findElementsByCssSelector("ul.sorts li.sort");
            //WebElement default_sort = liElements.get(0);//默认排序
            WebElement scale_sort = liElements.get(1);//销量排序
            //WebElement credit_sort = liElements.get(2);//信用排序
            scale_sort.click();
        }

        //最外层采集结果保存 最大值是2^32个产品信息
        List<ListData.Mods.Item.Data.Auction> resultList = new ArrayList<>();

        // 单页数据获取
        for (int page = startPage; page <= endPage; page++) {
            getSimplePage(driver, resultList, page);
        }
        //excel存储工具
        excelAdapter(resultList, q, picture);
        LOGGER.info("采集<<{}>>的信息结束", q);
    }

    /*单个页面查询*/
    private void getSimplePage(ChromeDriver driver, List<ListData.Mods.Item.Data.Auction> resultList, int page) {
        LOGGER.info("当前页面为<<{}>>", page);
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
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight -" + new Random().nextInt(150) +")");
        try {
            TimeUnit.MILLISECONDS.sleep(1000 + new Random().nextInt(1000));
        } catch (InterruptedException e) {
            LOGGER.error("模仿人鼠标行为滑动操作  出现异常");
        }


        // 输入查询页数
        WebElement page_num_input = driver.findElementByCssSelector("div.form input.input.J_Input");
        page_num_input.clear();
        page_num_input.sendKeys(String.valueOf(page));
        try {
            TimeUnit.MILLISECONDS.sleep(new Random().nextInt(3000));
        } catch (InterruptedException e) {
            LOGGER.error("等待点击操作");
        }
        WebElement element = driver.findElementByCssSelector("span.btn.J_Submit");
        element.click();
        //等这个页面五秒钟缓冲时间
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        //获取页面代码
        String html_info = driver.getPageSource();
        // 格式化json
        Pattern pattern = Pattern.compile("g_page_config = .*?g_srp_loadCss", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(html_info);
        String info = null;
        while (matcher.find()) {
            info = matcher.group();
        }

        if (null != info) {
            info = info.replace("g_page_config = ", "");
            info = info.substring(0, info.lastIndexOf(";"));
            Gson gson = new Gson();
            ListData listData = gson.fromJson(info, ListData.class);
            resultList.addAll(listData.getMods().getItemlist().getData().getAuctions());
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
     * 进行登录操作的判断
     * */
    // FIXME: 2018/12/10/010 暂时不支持自动登录  以后完善
    private ChromeDriver loginOperation() {
        //chrome浏览器  单个项目运行需要删除 springboot-html
        System.setProperty("webdriver.chrome.driver",
                        System.getProperty("user.dir") + "/springboot-html/chromedriver.exe");
        /*System.setProperty("webdriver.chrome.driver",
                        System.getProperty("user.dir") + "/chromedriver.exe");*/
        ChromeDriver driver = new ChromeDriver();
        // 最大化操作界面
        driver.manage().window().maximize();

        driver.get("https://login.taobao.com/");
        // 等待登录
        while (!driver.getCurrentUrl().contains("www.taobao.com")) {
            LOGGER.error("扫描程序界面的二维码。。。。");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                LOGGER.error("等待扫描二维码报错。。。");
            }
        }
        return driver;
    }

    /*
     * excel的数据装饰器 不考虑代码重复问题  解耦代码
     * */
    private void excelAdapter(List<ListData.Mods.Item.Data.Auction> resultList, String fileName, Boolean picture) {
        // 加载模板文件
        String userDir = System.getProperty("user.dir");
        String relativelyPath = String.format("%s/springboot-html/search/excel.xls", userDir);
        String reportPath = String.format("%s/springboot-html/search/%s.xls", userDir, fileName);
        /*String relativelyPath = String.format("%s/search/excel.xls", userDir);
        String reportPath = String.format("%s/search/%s.xls", userDir, fileName);*/
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
}
