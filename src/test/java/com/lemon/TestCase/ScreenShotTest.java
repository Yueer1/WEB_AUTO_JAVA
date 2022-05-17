package com.lemon.TestCase;

import com.lemon.common.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * @Project: web_auto
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: 2020 版权所有 湖南省零檬信息技术有限公司
 * @Author: Administrator
 * @Create: 2020-10-29 22:21
 * @Desc： 截图保存
 **/
public class ScreenShotTest extends BaseTest {
    @Test
    public void saveScreenShot() throws InterruptedException {
       openBrowser("firefox");
       driver.get("https://www.jd.com");
       Thread.sleep(5000);
       //driver是没有截图的API
        // JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        //强制转化实现截图
        TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
        //如果想要将图片保存在本地，将截图保存在文件即可
        //源文件(指定输出文件类型)
        File srcfile =  takesScreenshot.getScreenshotAs(OutputType.FILE);
        //要将文件对象保存在本地
        File targetfile = new File("E:\\lemon.png");
        //拷贝动作：源文件--》目标文件（引入依赖common.io）
        try {
            FileUtils.copyFile(srcfile,targetfile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
