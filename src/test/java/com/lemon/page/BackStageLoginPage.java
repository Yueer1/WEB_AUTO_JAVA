package com.lemon.page;

import com.lemon.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @Project: web_auto
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: 2020 版权所有 湖南省零檬信息技术有限公司
 * @Author: Administrator
 * @Create: 2020-10-20 21:00
 * @Desc： 后台首页页面框架的编写
 **/
public class BackStageLoginPage extends BasePage {
    public BackStageLoginPage(WebDriver driver){
        super(driver);
    }
    //页面元素的定位
    By AccountBy = By.name("admin_name");
    By passwordBy = By.name("admin_pwd");
    By CodePassBy = By.name("code");
    By LoginButtonBy = By.xpath("//button[text()='登陆后台']");

    public void login(String account,String password,String code){
        /*driver.findElement(AccountBy).sendKeys("account");
        driver.findElement(passwordBy).sendKeys("password");
        driver.findElement(CodePassBy).sendKeys("code");
        driver.findElement(LoginButtonBy).click();*/
        waitElementVisible(AccountBy).sendKeys(account);
        waitElementVisible(passwordBy).sendKeys(password);
        waitElementVisible(CodePassBy).sendKeys(code);
        waitElementClickable(LoginButtonBy).click();
    }
}
