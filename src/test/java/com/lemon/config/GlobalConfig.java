package com.lemon.config;

/**
 * @Project: web_auto
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: 2020 版权所有 湖南省零檬信息技术有限公司
 * @Author: Administrator
 * @Create: 2020-10-22 22:13
 * @Desc： 公共配置包
 **/
public class GlobalConfig {
    public static final String BROWSER_NAME = "firefox";
    //http://120.78.128.25:8765/Admin/Index/login.html
    //后台地址
    public static final String BACKSTAGE_URL = "http://120.78.128.25:8765";
    //后台登录地址
    public static final String BACKSTAGELOGIN_URL = BACKSTAGE_URL + "/Admin/Index/login.html";
    //后台首页地址
    public static final String BACKSTAGEINDEX_URL = BACKSTAGE_URL +"/Admin/Index/main.html";
    //前台地址
    public static final String FONT_URL = "http://120.78.128.25:8765";
    //前台登录地址
    public static final String FONTLOGIN_URL = FONT_URL +"/Index/login.html";
    //前台首页地址
    public static final String FONTINDEX_URL = FONT_URL +"/Index/index";
}