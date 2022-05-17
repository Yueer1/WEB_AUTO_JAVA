package com.lemon.page;

import com.lemon.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
 * @Create: 2020-10-20 21:14
 * @Desc： 进去后台首页的操作
 **/
public class BackStageIndexPage extends BasePage {

    public BackStageIndexPage(WebDriver driver){
        super(driver);
    }
    //借款管理
    By borrowManageBy = By.xpath("//span[text()='借款管理']");
    //iframe
    By iframeBy = By.id("mainFrame");
    //加标
    By addLoanBy = By.xpath("//span[text()='加标']");
    //借款人的输入框
    By borrowerBy = By.xpath("//td[text()='借款人:']/following-sibling::td/span/input[1]");
    //贷款标题输入框
    By loanTitleBy = By.xpath("//td[text()='贷款标题:']/following-sibling::td/input");
    //年利率利息
    By loanRateBy = By.xpath("//td[text()='年利率利息:']/following-sibling::td/input");
    //借款期限输入框
    By loanTermBy = By.xpath("//td[text()='借款期限:']/following-sibling::td/input");
    //借款额度输入框
    By loanAmountBy = By.xpath("//td[text()='借款额度:']/following-sibling::td/input");
    //竞标期限输入框
    By bidTermBy = By.xpath("//td[text()='竞标期限:']/following-sibling::td/input");
    //风控评测
    By riskControlBy = By.xpath("//span[text()='风控评测']");
    // 评估价值
    By evalutationValueBy = By.xpath("//td[text()='评估价值:']/following-sibling::td/input");
    //项目录入
    By projectImportBy = By.xpath("//span[text()='项目录入']");
    //籍贯
    By nativeplaceBy = By.xpath("//td[text()='籍贯:']/following-sibling::td/input");
    //职业
    By occupationBy = By.xpath("//td[text()='职业:']/following-sibling::td/input");
    //年龄
    By ageBy = By.xpath("//td[text()='年龄:']/following-sibling::td/input");
    //提交
    By submitBy = By.xpath("//span[text()='提交']");
    //审核
    By verifyBy = By.xpath("//span[text()='审核']");
    //审核通过
    By verifyPassBy = By.xpath("//span[text()='审核通过']");

    //添加标的
    public void addBid(String borrowserMobilephone,String loanTitle,String loanRate,
                       String loanTerm,String loanAmount,String bidTerm,String evalutationValue,
                       String nativeplace,String occupation,String age){
        waitElementClickable(borrowManageBy).click();
        //切换iframe（方法返回的是一个空值）
        waitIframeAndSwitchToIt(iframeBy);
        waitElementClickable(addLoanBy).click();
        waitElementVisible(borrowerBy).sendKeys(borrowserMobilephone);
        waitElementVisible(borrowerBy).sendKeys(Keys.ARROW_DOWN);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitElementVisible(borrowerBy).sendKeys(Keys.ENTER);
        waitElementVisible(loanTitleBy).sendKeys(loanTitle);
        waitElementVisible(loanRateBy).sendKeys(loanRate);
        waitElementVisible(loanTermBy).sendKeys(loanTerm);
        waitElementVisible(loanAmountBy).sendKeys(loanAmount);
        waitElementVisible(bidTermBy).sendKeys(bidTerm);
        //点击风控评测
        waitElementClickable(riskControlBy).click();
        waitElementVisible(evalutationValueBy).sendKeys(evalutationValue);
        //点击项目录入
        waitElementClickable(projectImportBy).click();
        waitElementVisible(nativeplaceBy).sendKeys(nativeplace);
        waitElementVisible(occupationBy).sendKeys(occupation);
        waitElementVisible(ageBy).sendKeys(age);
        waitElementClickable(submitBy).click();
    }

    //三次审核
    public void verify(String loanTitle){
        //创建的项目对应的项
        By loanItemBy = By.xpath("//div[text()='"+loanTitle+"']");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitElementClickable(loanItemBy).click();
        waitElementClickable(verifyBy).click();
        waitElementClickable(verifyPassBy).click();
        //org.openqa.selenium.StaleElementReferenceException:
        // stale element reference: element is not attached to the page document
        //元素没有和页面文档绑定上
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitElementClickable(loanItemBy).click();
        waitElementClickable(verifyBy).click();
        waitElementClickable(verifyPassBy).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitElementClickable(loanItemBy).click();
        waitElementClickable(verifyBy).click();
        waitElementClickable(verifyPassBy).click();
    }


}
