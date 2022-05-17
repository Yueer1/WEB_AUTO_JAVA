package com.lemon.TestCase;

import org.apache.log4j.Logger;

/**
 * @Project: web_auto
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: 2020 版权所有 湖南省零檬信息技术有限公司
 * @Author: Administrator
 * @Create: 2020-10-27 21:11
 * @Desc： 测试日志类
 **/
public class Log4jTest {
    static Logger logger = Logger.getLogger(Log4jTest.class);
    public static void main(String[] args) {
        logger.info("hello world");
    }
}
