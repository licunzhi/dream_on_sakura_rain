package com.sakura.thread;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-12-19
 */
public class DoubanDemo {
    public static void main(String[] args) {
        // load the drive of chrome
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        // maxsize of the chrome
        driver.manage().window().maximize();
        driver.get("https://movie.douban.com/subject/3878007/comments?start=0&limit=20");

        // loop the action of get comments
        for (int i = 0; i < 100; i++) {

            Document document = Jsoup.parse(driver.getPageSource());
            Element body = document.body();
            System.out.println(body.select("div#paginator a.next").attr("href"));

            // get the information in body
            Element comments = body.getElementById("comments");

            List<Element> elementList = comments.getElementsByClass("comment-item");
            for (Element item : elementList) {
                String user_name = item.select("div.avatar a").attr("title");// user name
                String content = item.select("div.comment p span.short").html();// content

            }


            // action to scroll to the end of this page for the action of click
            ((JavascriptExecutor) driver).
                    executeScript("window.scrollTo(0, document.body.scrollHeight)");
            try {
                TimeUnit.MILLISECONDS.sleep(1000 + new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            WebElement element = driver.findElementById("paginator").findElement(By.cssSelector("a.next"));
            ((JavascriptExecutor) driver)
                    .executeScript("window.scrollBy(0, " + (element.getLocation().getY() - 100 + new Random().nextInt(20)) + ")");
            try {
                Thread.sleep(3000 + new Random().nextInt(3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // click to next page
            element.click();

            // wait the ajax adapter the page
            try {
                Thread.sleep(3000 + new Random().nextInt(3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // quit the browser of chrome
        driver.close();

    }
}
