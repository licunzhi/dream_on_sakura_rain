package com.example.springboothtml.serviceImpl;

import com.example.springboothtml.domain.ListData;
import com.example.springboothtml.service.SeleniumService;
import com.google.gson.Gson;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.json.Json;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class SeleniumServiceImpl implements SeleniumService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SeleniumServiceImpl.class);

    @Override
    public ResponseEntity demoUse(String query) {
        Properties properties = System.getProperties();
        System.out.println(properties.propertyNames().toString());
        //这是我使用的是chrome  也可以使用其他的浏览器  但是需要对应的版本驱动器
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/springboot-html/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //实现窗口最大化
        driver.manage().window().maximize();

        /*
        去他妈的先登陆
        * */
        driver.get("https://login.taobao.com/");

        /*
        * 二维码登录
        * */
        while(!driver.getCurrentUrl().contains("www.taobao.com")) {
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
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

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
            try{
                info = info.replace("g_page_config = ", "");
                info = info.substring(0, info.lastIndexOf(";"));
                Gson gson = new Gson();
                ListData listData = gson.fromJson(info, ListData.class);
                auctionList.addAll(listData.getMods().getItemlist().getData().getAuctions());
            } catch (Exception e) {
                LOGGER.error("大爷的  出错了");
            }
        }

        for (int i = 0; i < 10 ; i++) {
            LOGGER.info("大爷的  " + 1 + "次循环");
            String currentUrl = driver.getCurrentUrl();
            try {
                Thread.sleep(10 + new Random().nextInt(5));
            } catch (InterruptedException e) {
                LOGGER.error("大爷的  出错了");
            }
            WebElement element = driver.findElement(By.className("next")).findElement(By.tagName("a"));
            element.click();

            while (Objects.equals(driver.getCurrentUrl(), currentUrl)) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    LOGGER.error("大爷的  出错了");
                }
            }

            html_info = driver.getPageSource();

            while (matcher.find()) {
                info = matcher.group();
            }

            if (Objects.equals("", info)) {
                LOGGER.error("大爷的  出错了");
            } else {
                try{
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
}
