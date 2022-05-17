package com.lemon.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @Project: web_auto
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: 2020 版权所有 湖南省零檬信息技术有限公司
 * @Author: Administrator
 * @Create: 2020-10-22 21:06
 * @Desc： 所有的page类的父类
 **/
public class BasePage {
    Logger logger = Logger.getLogger(BasePage.class);
    public WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement waitElementVisible(By by){
        WebDriverWait webDriverWait=new WebDriverWait(driver,10);
        return  webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitElementClickable(By by){
        //by变量保存的是元素的定位信息：元素的定位方式 + 元素定位值  By.xpath("//a[text()='']")
        WebDriverWait webDriverWait=new WebDriverWait(driver,10);
        return  webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public WebElement waitElementPresence(By by){
        //判断元素已存在
       WebDriverWait webDriverWait = new WebDriverWait(driver,10);
       return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }


    public void waitIframeAndSwitchToIt(By by){
        WebDriverWait webDriverWait = new WebDriverWait(driver,10);
        //等待iframe元素可用 --》切换到里面
        webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
    }

    //对显示等待做二次封装
    public void click(By by){
        logger.info("点击了元素["+by+"]");
        waitElementVisible(by).click();
    }

    //对输入数据做二次封装
    public void input(By by,String data){
        logger.info("往元素["+by+"]中输入了值["+data+"]");
        waitElementVisible(by).sendKeys(data);
    }

    //显示等待对清空进行封装
    public void ClearInput(By by){
        waitElementVisible(by).clear();
    }

    //显式等待获取元素的文本
    public String getElementText(By by){
       return waitElementVisible(by).getText();
    }

    //显式等待获取元素对应属性
    public String getElementAttribute(By by,String  name){
        return waitElementVisible(by).getAttribute(name);
    }

    //显式等待元素是否可见二次封装
    public boolean isElementVisible(By by){
        WebDriverWait webDriverWait = new WebDriverWait(driver,8);
        try {
            waitElementVisible(by);
            return true;
        }catch (TimeoutException e){
            return false;
        }
    }

}
