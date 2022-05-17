package com.webauto.ide;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @Project: web_auto
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: 2020 版权所有 湖南省零檬信息技术有限公司
 * @Author: Administrator
 * @Create: 2020-09-27 17:48
 * @Desc： web自动化入门
 **/
public class FirstWebauto {

    public static void main(String[] args) {
       //OpenFirefox();
        //解决返回类型不匹配:用父类接收子类对象
        WebDriver driver = openBrowser("firefox");
        driver.get("https://www.baidu.com");
    }

    /**
     *打开浏览器的方法
     * @param browserName  浏览器名
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

    /*public static void OpenFirefox(){
        //让代码知道驱动是在哪里
        System.setProperty("webdriver.gecko.driver","src/test/resources/geckodriver.exe");
        //1.打开浏览器
         FirefoxDriver firfoxDriver = new FirefoxDriver();
        //驱动下载地址页面
        //2.打开百度
        firfoxDriver.get("https://www.baidu.com");
    }*/
}
