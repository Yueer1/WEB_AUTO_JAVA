package com.lemon.page;

import com.lemon.common.BasePage;
import jdk.jfr.events.ExceptionThrownEvent;
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
 * @Create: 2020-10-17 18:06
 * @Desc： 我的账户页面
 **/
public class IndexPage extends BasePage {

    public IndexPage(WebDriver driver){
        //去调用父类的构造方法
        super(driver);
    }
    By myaccout = By.xpath("//a[contains(text(),'我的帐户')]");
    //判断我的账户是否可见  myaccout
    public boolean isMyacooutVisible(){
        WebDriverWait webDriverWait = new WebDriverWait(driver,8);
        return isElementVisible(myaccout);
    }

    //选择对应的标
    public void selectBid(String loanTitle){
        //标的抢投标元素
        By rushToBidBy = By.xpath("//span[contains(text(),'"+loanTitle+"')]/parent::div/parent::a/following-sibling::div[1]//a[text()='抢投标']");
        click(rushToBidBy);
    }

}
