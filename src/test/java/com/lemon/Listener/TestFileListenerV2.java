package com.lemon.Listener;

import com.lemon.common.BaseTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

/**
 * @Project: web_auto
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: 2020 版权所有 湖南省零檬信息技术有限公司
 * @Author: Administrator
 * @Create: 2020-11-01 18:04
 * @Desc： 测试监听文件
 **/

/**
 * IHookable作用：在测试用例执行的时候可以动态的替换@Test注解标注的测试方法
 */
public class TestFileListenerV2 implements IHookable {
    //让测试对象正常执行，保存到测试结果
    public void run(IHookCallBack iHookCallBack, ITestResult iTestResult){
        //动态替换掉@Test注解里面标注的所有方法
        //System.out.println("");
        //让测试方法正常执行   iTestResult保存测试结果
        iHookCallBack.runTestMethod(iTestResult);
        if(iTestResult.getThrowable()!=null) {
            System.out.println("开始截图");
            //截图的方法
            //getInstance:获取实例，指向的就是正在运行的测试用例所对应的
            BaseTest baseTest = (BaseTest) iTestResult.getInstance();
            TakesScreenshot takesScreenshot = (TakesScreenshot) baseTest.driver;
            //Allure中如果返回的是String或者byte[]，并且通过Attachment标注的话，
            //Allure就会把返回的结果作为附件的形式添加到Allure报告中
            byte[] takesScreenDate = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            saveToAllure(takesScreenDate);
        }
    }
    @Attachment(value = "screenshot",type = "image/png")
    public byte[] saveToAllure(byte[] screenshot){
       return screenshot;
    }
}
