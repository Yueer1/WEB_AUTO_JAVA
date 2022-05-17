package com.lemon.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @Project: web_auto
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: 2020 版权所有 湖南省零檬信息技术有限公司
 * @Author: Administrator
 * @Create: 2020-10-22 21:53
 * @Desc： 用例的父类
 **/

/**
 * 1.打开浏览器
 * 2.关闭浏览器
 * 3.导航对象、刷新、后退、前进
 */
public class BaseTest {
    //将driver放在baseTest父类中
    public static WebDriver driver;
    static Logger logger = Logger.getLogger(BaseTest.class);
    //打开浏览器
    public static void openBrowser(String browserName) {
        logger.info("===============打开浏览器【"+browserName+"】==================");
        if (browserName.equals("firefox")) {
            //让代码知道驱动是在哪里
            System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
            //1.打开浏览器
            FirefoxDriver firfoxDriver = new FirefoxDriver();
            //驱动下载地址页面
            //2.打开百度
            //firfoxDriver.get("https://www.baidu.com");
            //return firfoxDriver;
            driver  =firfoxDriver;
        }
    }

    public void to(String url){
        logger.info("访问地址["+url+"]");
         driver.get(url);
    }

    //关闭浏览器
    public void closeBrower( ){
        logger.info("=============关闭浏览器==============");
        driver.quit();

    }
    //刷新浏览器
    public void refreshBrower( ){
        logger.info("刷新浏览器");
        Navigation navigation = driver.navigate();
        navigation.refresh();
    }
    //前进浏览器
    public void fowardBrower( ){
        Navigation navigation = driver.navigate();
        navigation.forward();
    }
    //浏览器后退
    public void backBrower( ){
        Navigation navigation = driver.navigate();
        navigation.back();
    }


}
