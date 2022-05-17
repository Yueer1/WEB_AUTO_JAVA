package com.SpecialElement;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;

/**
 * @Project: web_auto
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: 2020 版权所有 湖南省零檬信息技术有限公司
 * @Author: Administrator
 * @Create: 2020-10-18 10:15
 * @Desc： 元素切换检查
 **/
public class switchTest {
    public static void main(String[] args) throws InterruptedException {
        //1.alert弹窗的处理
        /*WebDriver driver = openBrowser("firefox");
        driver.get("C:\\Users\\Administrator\\Desktop\\login.html");
        driver.findElement(By.id("1")).sendKeys("lemon");
        driver.findElement(By.id("2")).sendKeys("123456");
        driver.findElement(By.id("3")).click();
        //alert的切换
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        Thread.sleep(2000);
        //确认弹窗
        alert.accept();
        Thread.sleep(2000);
        driver.quit();*/

        //2.iframe的处理
        /*WebDriver driver = openBrowser("firefox");
        driver.get("https://ke.qq.com/");
        driver.findElement(By.id("js_login")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[text()='QQ登录']")).click();
        Thread.sleep(3000);
        //1.根据索引进行切换
        //driver.switchTo().frame(2);
        //2.根据id进行切换
        //3.根据找到的iframe元素进行切换(重点掌握)
        WebElement webElement =  driver.findElement(By.name("login_frame_qq"));
        driver.switchTo().frame(webElement);

        driver.findElement(By.id("u")).sendKeys("132451661616");
        driver.findElement(By.id("p")).sendKeys("123456");
        Thread.sleep(2000);
        //回到默认页面当中
        //一级一级回到上一层页面
        driver.switchTo().parentFrame();
        //一次性回到默认页面中
        //driver.switchTo().defaultContent();
        driver.findElement(By.id("switcher_plogin")).click();*/

        //3.windows窗口切换--两个窗口
        /*WebDriver driver = openBrowser("firefox");
        driver.get("https://www.baidu.com");
        //点击新窗口之前打印句柄
        System.out.println("原来的句柄："+driver.getWindowHandle());
        driver.findElement(By.linkText("hao123")).click();
        Thread.sleep(5000);
        //获取到当前driver对应的窗口句柄，并不是肉眼看到的那个
        System.out.println("点击窗口之后的句柄"+driver.getWindowHandle());
        String beforeHandle =  driver.getWindowHandle();

        Set<String> handles = driver.getWindowHandles();
        String WindowHandle = "";
        for(String handle : handles ){
            if(handle.equals(beforeHandle)){
               //如果现在的句柄和之前的一样
                continue;
            }
            WindowHandle = handle;
        }
        System.out.println(WindowHandle);
        //切换窗口
        driver.switchTo().window(WindowHandle);
        driver.findElement(By.xpath("//a[text()='腾讯']")).click();*/

        //NoSuchElementException报错的原因：
        //1.定位表达式写错了；2.元素还没有加载出来，需要等待；3.元素在iframe中；4.元素在新的窗口中

        //多窗口的切换 ：同时又两个新窗口以上的切换
        //怎么找到窗口句柄
       /* WebDriver driver = openBrowser("firefox");
        driver.get("https://www.baidu.com");
        Set<String> handles = driver.getWindowHandles();
        for(String handle : handles ){
            //根据窗口的信息判断
            if(driver.getTitle().equals("hao123_上网从这里开始")){
                //driver现在是在正确窗口中，同样说明现在打的handle句柄也是正确的不需要再切换
            }else {
                driver.switchTo().window(handle);
            }
        }
        driver.findElement(By.xpath("//a[text()='腾讯']")).click();*/
        //4.select下拉框的处理
      /*  WebDriver driver = openBrowser("firefox");
        driver.get("C:\\Users\\Administrator\\Desktop\\selectTest.html");
        WebElement webElement =  driver.findElement(By.id("test"));
        Select select = new Select(webElement);
        //根据索引选中对应的选项
        select.selectByIndex(1);
        //根据文本选中
        select.selectByVisibleText("语文");*/

        //5.鼠标操作
        WebDriver driver = openBrowser("firefox");
        driver.get("https://www.baidu.com.cn");
        Thread.sleep(2000);
        //百度页面的设置
        WebElement webElement = driver.findElement(By.id("s-usersetting-top"));
        Actions actions = new Actions(driver);
        //build:构建；perform：开始
        actions.moveToElement(webElement).build().perform();
    }
    /**
     *打开浏览器的方法
     * @param browserName  浏览器名
     * @return
     */
    public static WebDriver openBrowser(String browserName){
        if(browserName.equals("firefox")){
            //让代码知道驱动是在哪里
            System.setProperty("webdriver.gecko.driver","src/test/resources/geckodriver.exe");
            //1.打开浏览器
            FirefoxDriver firfoxDriver = new FirefoxDriver();
            //驱动下载地址页面
            //2.打开百度
            //firfoxDriver.get("https://www.baidu.com");
            return firfoxDriver;
        }
        return null;
    }
}
