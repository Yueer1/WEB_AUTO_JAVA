package com.lemon.Listener;

import com.lemon.TestCase.LoginCaseTestng2;
import com.lemon.common.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

import javax.crypto.spec.PSource;
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
public class TestFileListener implements IHookable {
    //让测试对象正常执行，保存到测试结果
    public void run(IHookCallBack iHookCallBack, ITestResult iTestResult){
        //动态替换掉@Test注解里面标注的所有方法
        //System.out.println("");
        //让测试方法正常执行   iTestResult保存测试结果
        iHookCallBack.runTestMethod(iTestResult);
        if(iTestResult.getThrowable()!=null){
            System.out.println("开始截图");
            //截图的方法
            //getInstance:获取实例，指向的就是正在运行的测试用例所对应的
            BaseTest baseTest = (BaseTest) iTestResult.getInstance();
            TakesScreenshot takesScreenshot = (TakesScreenshot)baseTest.driver;
            //如果想要将图片保存在本地，将截图保存在文件即可
            //源文件(指定输出文件类型)
            File srcfile =  takesScreenshot.getScreenshotAs(OutputType.FILE);
            //要将文件对象保存在本地
            File targetfile = new File("E:\\lemon"+System.currentTimeMillis()+".png");
            //拷贝动作：源文件--》目标文件（引入依赖common.io）
            try {
                FileUtils.copyFile(srcfile,targetfile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
