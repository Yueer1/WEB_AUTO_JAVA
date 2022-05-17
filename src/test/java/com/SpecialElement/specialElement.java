package com.SpecialElement;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @Project: web_auto
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: 2020 版权所有 湖南省零檬信息技术有限公司
 * @Author: Administrator
 * @Create: 2020-10-13 20:56
 * @Desc： 特殊元素的处理
 **/
public class specialElement {
    public static void main(String[] args) throws InterruptedException {
      /*WebDriver webDriver =  openBrowser("firefox");*/
       /* webDriver.get("https://www.fliggy.com/?ttid=seo.000000574&seoType=origin");
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//label[text()='出发日期：']/following-sibling::div/input")).clear();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//label[text()='出发日期：']/following-sibling::div/input"))
                .sendKeys("2020-10-15");*/

        //通过js代码获取属性值和属性名
       /* webDriver.get("https://www.12306.cn/index/");
        *//*webDriver.findElement(By.id("train_date")).clear();
        Thread.sleep(2000);
        webDriver.findElement(By.id("train_date")).sendKeys("2020-10-16");*//*
        //对类型进行强转
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        javascriptExecutor.executeScript("document.getElementById(\"train_date\").removeAttribute(\"readonly\")");
        Thread.sleep(2000);
        webDriver.findElement(By.id("train_date")).sendKeys("2020-10-16");*/

        //文件上传
        WebDriver driver = openBrowser("firefox");
        //1.元素为input标签，并且type为file类型
        /*driver.get("E:\\fileupload.html");
        driver.findElement(By.id("test")).
                sendKeys("E:\\web_auto\\src\\test\\java\\com\\lemon\\page");*/
        //2.元素不为input标签
        driver.get("https://www.layui.com/demo/upload.html");
        //driver.findElement(By.id("test1")).sendKeys("");--- 操作不行


    }

    /**
     * 打开浏览器的封装
     * @param browserName
     * @return
     */
    public static WebDriver openBrowser(String browserName){
        if(browserName.equals("firefox")){
            //让代码知道驱动是在哪里
            System.setProperty("webdriver.gecko.driver","src/test/resources/geckodriver.exe");
            //1.打开浏览器
            FirefoxDriver firfoxDriver = new FirefoxDriver();
            //驱动下载地址页面
            //2.打开百度
            //firfoxDriver.get("https://www.baidu.com");
            return firfoxDriver;
        }
        return null;
    }
}
