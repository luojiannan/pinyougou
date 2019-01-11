package com.pinyougou.user.demo.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * @author ljn
 * @date 2019/1/8.
 */
public class SeleniumDemo {

    public static void main(String[] args) throws InterruptedException {
        //设置驱动
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://yxbmall.5173.com/");

        String title = driver.getTitle();
        System.out.printf(title);

        WebElement goodsTitle = driver.findElement(By.className("tt"));
        List<WebElement> list = goodsTitle.findElements(By.tagName("a"));
        WebElement price = driver.findElement(By.className("pr"));
//        price.findElements()
        WebElement num = driver.findElement(By.className("pdlist_num"));
        WebElement desc = driver.findElement(By.className("pdlist_unitprice"));
        for (int l = list.size(),i=0;i<l;i++) {
            WebElement ele = list.get(0);
            String text = ele.getText();
            System.out.println(text);
        }

        driver.close();

//        driver.get("https://www.baidu.com");
//
//        System.out.println("Search before================");
//
//        //获取当前的 title 和 url
//        System.out.printf("title of current page is %s\n", driver.getTitle());
//        System.out.printf("url of current page is %s\n", driver.getCurrentUrl());
//
//        //百度搜索
//        WebElement search = driver.findElement(By.id("kw"));
//        search.sendKeys("武动乾坤");
//        search.sendKeys(Keys.ENTER);
//        Thread.sleep(2000);
//
//        System.out.println("Search after================");
//
//        //获取当前的 title 和 url
//        System.out.printf("title of current page is %s\n", driver.getTitle());
//        System.out.printf("url of current page is %s\n", driver.getCurrentUrl());
//
//        //获取第一条搜索结果的标题
//        WebElement result = driver.findElement(By.xpath("//div[@id='content_left']/div/h3/a"));
//        System.out.println(result.getText());
//
//        driver.quit();
    }
}
