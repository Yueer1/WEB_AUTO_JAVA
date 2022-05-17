package com.lemon.TestCase;

import com.lemon.common.BaseTest;
import com.lemon.config.GlobalConfig;
import com.lemon.page.IndexPage;
import com.lemon.page.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * @Project: web_auto
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: 2020 版权所有 湖南省零檬信息技术有限公司
 * @Author: Administrator
 * @Create: 2020-10-15 21:11
 * @Desc： 登录页面的操作
 **/
public class LoginCaseTestng extends BaseTest {

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        openBrowser(GlobalConfig.BROWSER_NAME);
        driver.get("http://120.78.128.25:8765/Index/login.html");
    }

    /**
     * priority:数值越小优先级越高。
     */
    @Test(priority = 1)
    public void login_success()  {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.login("13323234545","lemon123456");
        /*//通过输入手机号、密码进行点击进行页面的跳转
        driver.findElement(By.name("phone")).sendKeys("13323234545");
        driver.findElement(By.name("password")).sendKeys("lemon123456");
        driver.findElement(By.xpath("//button[text()='登录']")).click();*/

        //预期结果：进行断言的打印
        //对打开的页面元素存在的进行校验
        /*WebDriverWait webDriverWait = new WebDriverWait(driver, 8);
        try {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'我的帐户')]")));
            Assert.assertTrue(true);
        } catch (Exception e) {
            Assert.assertTrue(false);
        }*/
        IndexPage indexPage  = new IndexPage(driver);
        //根据账户元素是否可见做断言
        Assert.assertTrue(indexPage.isMyacooutVisible());

        //对地址变化设置断言
        String exceptedUrl = "http://120.78.128.25:8765/Index/index";
        String actualUrl = driver.getCurrentUrl();
        //System.out.println(actualUrl);
        /*if (exceptedUrl.equals(actualUrl)) {
           Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }*/
        //第一个参数：实际值；第二个参数：期望值
        Assert.assertEquals(actualUrl,exceptedUrl);

    }

   /* @Test
    //未注册用户进行登录
    public void user_unresiger_login() {

        //通过输入手机号、密码进行点击进行页面的跳转
        LoginPage loginpage = new LoginPage(driver);
        loginpage.login("15859019266","lemon123456");
        *//*driver.findElement(By.name("phone")).sendKeys("15859019266");
        driver.findElement(By.name("password")).sendKeys("lemon123456");
        driver.findElement(By.xpath("//button[text()='登录']")).click();*//*

        *//*WebDriverWait webDriverWait = new WebDriverWait(driver, 8);
        WebElement webElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("layui-layer-content")));
        //WebElement webElement = driver.findElement(By.className("layui-layer-content"));
        String actualValue = webElement.getText();*//*
        String actualValue = loginpage.getcentertips();
        String expectedValue = "此账号没有经过授权，请联系管理员!";
        Assert.assertEquals(actualValue,expectedValue);

    }

    @Test
    //手机号为空登录
    public void user_blank() {

        //通过输入手机号、密码进行点击进行页面的跳转
        LoginPage loginpage = new LoginPage(driver);
        loginpage.login("","Ab%12345");
        *//*driver.findElement(By.name("phone")).sendKeys("");
        driver.findElement(By.name("password")).sendKeys("Ab%12345");
        driver.findElement(By.xpath("//button[text()='登录']")).click();*//*

        //断言 -- 根据输入框的提示信息
       *//* WebDriverWait webDriverWait = new WebDriverWait(driver,10);
        WebElement webElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("form-error-info")));
        String actualValue = webElement.getText();*//*
        String actualValue = loginpage.geterrortips();
        String expectedValue = "请输入手机号";
        Assert.assertEquals(actualValue,expectedValue);

    }

    @Test
    //手机号或密码错误
    public void user_password_error() {

        //通过输入手机号、密码进行点击进行页面的跳转
        LoginPage loginpage = new LoginPage(driver);
        loginpage.login("1234545344","Ab%12345");
        *//*driver.findElement(By.name("phone")).sendKeys("");
        driver.findElement(By.name("password")).sendKeys("Ab%12345");
        driver.findElement(By.xpath("//button[text()='登录']")).click();*//*

        //预期结果：进行断言的打印
        //对打开的页面元素存在的进行校验
        *//*WebDriverWait webDriverWait = new WebDriverWait(driver, 8);
        WebElement webElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("form-error-info")));
        String actualValue = webElement.getText();*//*
        String actualValue = loginpage.geterrortips();
        String expectedValue = "请输入正确的手机号";
        Assert.assertEquals(actualValue,expectedValue);
    }


    @Test
    //密码为空登录
    public void password_blank() {

        //通过输入手机号、密码进行点击进行页面的跳转
        LoginPage loginpage = new LoginPage(driver);
        loginpage.login("12345453442","");
        *//*driver.findElement(By.name("phone")).sendKeys("15859019266");
        driver.findElement(By.name("password")).sendKeys("");
        driver.findElement(By.xpath("//button[text()='登录']")).click();*//*

        //预期结果：进行断言的打印
        //对打开的页面元素存在的进行校验
        *//*WebDriverWait webDriverWait = new WebDriverWait(driver, 8);
        WebElement webElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("form-error-info")));
        String actualValue = webElement.getText();*//*
        String actualValue = loginpage.geterrortips();
        String expectedValue = "请输入密码";
        Assert.assertEquals(actualValue,expectedValue);
    }*/

    @AfterMethod
    public void teardownMethod(){
        closeBrower();
    }

    @Test
    public void login_fail () {
       /*String actualValue="lemon";
       String expectedValue="lemon";
       Assert.assertEquals(actualValue,expectedValue);*/
        int a=10;
        Assert.assertFalse((a++)>10);
    }

    @DataProvider
    public Object[][] getFailAccounts(){
        Object[][] datas = {{"13323234545","lemon123456","此账号没有经过授权，请联系管理员!"},
                {"","Ab%12345","请输入手机号"},
                {"1234545344","Ab%12345","请输入正确的手机号"},
                {"12345453442","","请输入密码"}};
        return datas;
    }

    @Test(dataProvider ="getFailAccounts")
    public void test_failure_login(String phonenum,String passnum,String Tips){
        LoginPage loginpage = new LoginPage(driver);
        loginpage.login(phonenum,passnum);
        String actualValue = loginpage.getcentertips();
        String expectedValue = Tips;
        Assert.assertEquals(actualValue,expectedValue);
    }

}