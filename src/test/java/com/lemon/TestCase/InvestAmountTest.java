package com.lemon.TestCase;

import com.lemon.common.BasePage;
import com.lemon.common.BaseTest;
import com.lemon.config.GlobalConfig;
import com.lemon.page.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @Project: web_auto
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: 2020 版权所有 湖南省零檬信息技术有限公司
 * @Author: Administrator
 * @Create: 2020-10-20 21:32
 * @Desc： 投资者页面校验
 **/
public class InvestAmountTest extends BaseTest {

    String loanTitle;
    static Logger logger = Logger.getLogger(InvestAmountTest.class);
    @BeforeMethod
    public void setup() {
        openBrowser(GlobalConfig.BROWSER_NAME);
        //最大化浏览器
        driver.manage().window().maximize();
        //后台登录
        to(GlobalConfig.BACKSTAGELOGIN_URL);
        BackStageLoginPage backStageLoginPage = new BackStageLoginPage(driver);
        backStageLoginPage.login("lemon7", "lemonbest", "hapi");
        //后台添加标的
        BackStageIndexPage backStageIndexPage = new BackStageIndexPage(driver);
        loanTitle = "测试" + System.currentTimeMillis();
        driver.manage().window().fullscreen();
        backStageIndexPage.addBid("13323234444", loanTitle, "8", "6", "500000", "7", "2000000", "湖南长沙", "白富美", "25");
        //三次审核
        backStageIndexPage.verify(loanTitle);

        //加标流程实现过程中碰到的问题
        //1、iframe元素找不到，切换iframe
        //2、表格数据加载需要时间，Thread.sleep
        //3、元素被遮挡住，导致元素点击不到，最大化/全屏浏览器使得元素可见

        //前台登录
        to(GlobalConfig.FONTLOGIN_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("13323234545", "lemon123456");

    }

    @Test
    public void investAmountTest(){
        IndexPage indexPage = new IndexPage(driver);
        indexPage.selectBid(loanTitle);
        LoanDetailPage loanDetailPage = new LoanDetailPage(driver);
        //在投资之前获取到用户的可用余额
        String beforeLeaveAmount = loanDetailPage.getUserLeaveAmount();
        //进入到项目的详情页进行投资
        String investValue = "200";
        loanDetailPage.invest(investValue);
        //1、断言：根据成功的提示
        String actualValue = loanDetailPage.getInvestSuccessTips();
        Assert.assertEquals(actualValue,"投标成功！");
        //关闭投标成功的提示框
        loanDetailPage.closeInvestSuccessTips();
        //刷新浏览器
        refreshBrower();
       //获取投资之后的用户可用余额
        String afterLeaveAmount = loanDetailPage.getUserLeaveAmount();
        //获取可用余额的差
        Double expectedValue =  Double.valueOf(beforeLeaveAmount)-Double.valueOf(afterLeaveAmount);
        Assert.assertEquals(Double.valueOf(investValue),expectedValue);
        //需要补充的：还需要有其他的断言
        //作业：
        //用户的余额发生了变化
        //项目的可投金额发生了变化
        //最新投标用户显示当前投资用户信息 投资金额
        //数据库需不需要去查询？？？不需要
    }

}
