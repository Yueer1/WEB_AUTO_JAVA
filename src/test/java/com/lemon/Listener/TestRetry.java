package com.lemon.Listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * @Project: web_auto
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: 2020 版权所有 湖南省零檬信息技术有限公司
 * @Author: Administrator
 * @Create: 2020-11-01 20:58
 * @Desc： 失败重发监听类
 **/
/*
* TestRetryListener:失败的话就出发执行里面的retry方法
* 在需要重试的类中加入配置
*/
public class TestRetry implements IRetryAnalyzer {

    public boolean retry(ITestResult iTestResult) {
        int retrycount=2;
        int i=0;
        //返回true执行重试机制
        //返回false不会执行重试机制
        //次数限制
        if(i<retrycount){
            i++;
            return true;
        }else{
            return false;
        }
    }
}
