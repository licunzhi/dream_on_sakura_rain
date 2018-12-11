package com.example.springboothtml.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author licunzhi
 * @desc 驱动存储
 * @date 2018-12-11
 */
@Component
public class DriverManager {


    @Bean
    public WebDriver getWebDriver() {
        //chrome浏览器  单个项目运行需要删除 springboot-html
        System.setProperty("webdriver.chrome.driver",
                        System.getProperty("user.dir") + "/springboot-html/chromedriver.exe");
        /*System.setProperty("webdriver.chrome.driver",
                        System.getProperty("user.dir") + "/chromedriver.exe");*/
        ChromeDriver driver = new ChromeDriver();
        // 最大化操作界面
        driver.manage().window().maximize();
        return driver;
    }
}
