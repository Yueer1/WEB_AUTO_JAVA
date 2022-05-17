package com.lemon.Listener;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.IFactoryAnnotation;
import org.testng.annotations.ITestAnnotation;
import org.testng.annotations.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @Project: web_auto
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: 2020 版权所有 湖南省零檬信息技术有限公司
 * @Author: Administrator
 * @Create: 2020-11-03 20:54
 * @Desc： 真正的监听类
 **/

/**监听例
 * 在测试用例运行的时候动态的改变用例的参数
 */
public class TestRetryListener implements IAnnotationTransformer {
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        //1.获取到IRetryAnalyzer对象
        IRetryAnalyzer retryAnalyzer = annotation.getRetryAnalyzer();
        //2.判断对象是不是为空，为空则表示@Test没有设置参数
        if(retryAnalyzer==null){
            annotation.setRetryAnalyzer(TestRetry.class);
        }

    }
}
