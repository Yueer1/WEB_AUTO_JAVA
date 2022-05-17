package com.lemon.TestCase;

import com.lemon.Listener.TestRetry;
import com.lemon.common.BaseTest;
import com.lemon.config.GlobalConfig;
import com.lemon.page.IndexPage;
import com.lemon.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @Project: web_auto
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: 2020 版权所有 湖南省零檬信息技术有限公司
 * @Author: Administrator
 * @Create: 2020-10-22 22:10
 * @Desc： 最新的登录用例编写
 **/
public class LoginCaseTestng2 extends BaseTest {

    @BeforeMethod
    public void setupMethod(){
        openBrowser(GlobalConfig.BROWSER_NAME);
        to(GlobalConfig.FONTLOGIN_URL);
    }

    /**
     * priority:数值越小优先级越高。
     */
    @Test(priority = 1)
    public void login_success()  {
        LoginPage loginpage = new LoginPage(driver);
        //通过输入手机号、密码进行点击进行页面的跳转
        loginpage.login("13323234545","lemon123456");
        //预期结果：进行断言的打印
        //对打开的页面元素存在的进行校验
        IndexPage indexPage  = new IndexPage(driver);
        //根据账户元素是否可见做断言
        Assert.assertTrue(indexPage.isMyacooutVisible());
        //对地址变化设置断言
        String exceptedUrl = GlobalConfig.FONTINDEX_URL;
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,exceptedUrl);
    }


    @AfterMethod
    public void teardownMethod(){
        closeBrower();
    }
//该类增加了监听类进行重试机制
    @Test(retryAnalyzer = TestRetry.class)
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

    @Test(dataProvider ="getFailAccounts",enabled = false)
    public void test_failure_login(String phonenum,String passnum,String Tips){
        LoginPage loginpage = new LoginPage(driver);
        loginpage.login(phonenum,passnum);
        String actualValue = loginpage.getcentertips();
        String expectedValue = Tips;
        Assert.assertEquals(actualValue,expectedValue);
    }

}
