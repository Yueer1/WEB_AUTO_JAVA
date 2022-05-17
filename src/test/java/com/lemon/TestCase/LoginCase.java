package com.lemon.TestCase;

import com.lemon.common.BaseTest;
import com.lemon.config.GlobalConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;

/**
 * @Project: web_auto
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: 2020 版权所有 湖南省零檬信息技术有限公司
 * @Author: Administrator
 * @Create: 2020-10-15 21:11
 * @Desc： 登录页面的操作
 **/
public class LoginCase extends BaseTest {
    public static void main(String[] args) {
        openBrowser(GlobalConfig.BROWSER_NAME);
        driver.get("http://120.78.128.25:8765/Index/login.html");
         //通过输入手机号、密码进行点击进行页面的跳转
        driver.findElement(By.name("phone")).sendKeys("13323234545");
        driver.findElement(By.name("password")).sendKeys("lemon123456");
        driver.findElement(By.xpath("//button[text()='登录']")).click();

        //预期结果：进行断言的打印
        //对打开的页面元素存在的进行校验
        WebDriverWait webDriverWait = new WebDriverWait(driver,8);
        try {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'我的帐户')]")));
            System.out.println("用例通过");
        } catch (Exception e) {
            System.out.println("用例不通过");
        }
        
        //对地址变化设置断言
        String exceptedUrl = "http://120.78.128.25:8765/Index/index";
        String actualUrl = driver.getCurrentUrl();
        System.out.println(actualUrl);
        if(exceptedUrl.equals(actualUrl)){
            System.out.println("用例通过");
        }else{
            System.out.println("用例不通过");
        }
    }

}