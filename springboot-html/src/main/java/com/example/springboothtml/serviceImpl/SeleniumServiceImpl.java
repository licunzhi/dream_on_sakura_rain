package com.example.springboothtml.serviceImpl;

import com.example.springboothtml.domain.ListData;
import com.example.springboothtml.service.SeleniumService;
import com.example.springboothtml.utils.ExcelUtils;
import com.google.gson.Gson;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class SeleniumServiceImpl implements SeleniumService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SeleniumServiceImpl.class);

    @Value("${querys.split}")
    private String split;

    @Autowired
    private WebDriver driver;

    @Override
    public ResponseEntity<List<ListData.Mods.Item.Data.Auction>> scrapHtml(Integer startPage,
                    Integer endPage, Boolean picture) {

        try {
            getSimpleQuery(startPage, endPage, picture, (ChromeDriver) driver);
        } catch (Exception e) {
            LOGGER.error("抓取失败", e);
        }

        LOGGER.info("采集数据的进程结束");
        return new ResponseEntity("操作结束", HttpStatus.OK);
    }

    /*单个关键字查询*/
    private void getSimpleQuery(Integer startPage, Integer endPage, Boolean picture,
                    ChromeDriver driver) {
        LOGGER.info("采集信息方法");

        //最外层采集结果保存 最大值是2^32个产品信息
        String q = driver.findElement(By.id("q")).getAttribute("value");
        List<ListData.Mods.Item.Data.Auction> resultList = new ArrayList<>();

        // 单页数据获取
        for (int page = startPage; page <= endPage; page++) {
            getSimplePage(driver, resultList, page);
        }
        //excel存储工具
        excelAdapter(resultList, q, picture);
        LOGGER.info("采集信息结束");
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
        /*((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight -" + new Random().nextInt(150) +")");
        try {
            TimeUnit.MILLISECONDS.sleep(1000 + new Random().nextInt(1000));
        } catch (InterruptedException e) {
            LOGGER.error("模仿人鼠标行为滑动操作  出现异常");
        }*/
        driver.executeScript("arguments[0].scrollIntoView();", driver.findElementByCssSelector("span.btn.J_Submit"));


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
     * excel的数据装饰器 不考虑代码重复问题  解耦代码
     * */
    @Async
    public void excelAdapter(List<ListData.Mods.Item.Data.Auction> resultList, String fileName, Boolean picture) {
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

    public ResponseEntity relogin() {
        driver = new ChromeDriver();
        // 最大化操作界面
        driver.manage().window().maximize();
        driver.get("https://login.taobao.com");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
