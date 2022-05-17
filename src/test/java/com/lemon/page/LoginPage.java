package com.lemon.page;

import com.lemon.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;

/**
 * @Project: web_auto
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: 2020 版权所有 湖南省零檬信息技术有限公司
 * @Author: Administrator
 * @Create: 2020-10-17 16:28
 * @Desc： 登录页面抽取
 **/
public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }
    //规则：不需要一次性将所有的元素定位都写上
    //属性
  By mobilephone = By.name("phone");
  By password = By.name("password");
  By buttonlogin = By.xpath("//button[text()='登录']");
  //定义元素出现的信息
  By centrttips =  By.className("layui-layer-content");
  //定义元素出现的错误信息
  By errortips =  By.className("form-error-info");

    public void login( String phone, String pass) {
        //1.输入手机号
        ClearInput(mobilephone);
        input(mobilephone,phone);
        //2.输入密码
        ClearInput(password);
        input(password,pass);
        //3.点击登录
        click(buttonlogin);
    }

    //获取页面中间提示信息的操作
    public String getcentertips(){
        /*WebDriverWait webDriverWait = new WebDriverWait(driver,30);
        WebElement webElement = webDriverWait.until
                (ExpectedConditions.visibilityOfElementLocated(centrttips));*/
        return  getElementText(centrttips);
    }
    //获取到输入框的提示信息
    public String  geterrortips(){
        /*WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        WebElement webElement = webDriverWait.until
                (ExpectedConditions.visibilityOfElementLocated(errortips));*/
        return getElementText(errortips);
    }
}
