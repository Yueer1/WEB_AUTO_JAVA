package com.lemon.page;

import com.lemon.common.BasePage;
import org.openqa.selenium.By;
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
 * @Create: 2020-10-20 21:42
 * @Desc： 投标页面的登录
 **/
public class LoanDetailPage extends BasePage {

    public LoanDetailPage(WebDriver driver){
        super(driver);
    }
    //投资金额的输入框
    By investAmountInputBy = By.className("invest-unit-investinput");
    //投标按钮
    By investButtonBy = By.xpath("//button[text()='投标']");
    //投标成功提示
    By investSuccessTipsBy = By.xpath("//div[text()='投标成功！']");
    //投标成功的提示框
    By investSuccessClose = By.xpath("//div[text()='投标成功！']/preceding-sibling::div/img");
    //投资的操作
    public void invest(String investAmount){
        input(investAmountInputBy,investAmount);
        click(investButtonBy);
    }

    //获取到投资成功提示的操作
    public String getInvestSuccessTips(){
        return getElementText(investSuccessTipsBy);
    }
    //获取用户可用金额(余额)
    public String getUserLeaveAmount(){
        return getElementAttribute(investAmountInputBy,"data-ammount");
    }
     public void closeInvestSuccessTips(){
         click(investSuccessClose);
     }

}
