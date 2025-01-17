package com.best.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.HashMap;

import org.apache.catalina.util.ServerInfo;
import com.alibaba.fastjson.JSON;


/**
 * 创建一个java类
 * <p>
 * \@Controller注解：会为该类注册一个控制器组件，解析return 的jsp,html页面，并且跳转到相应页面
 * \@RestController 会直接return值
 *
 * @date 2021/06
 */

@Controller
public class Index {

    // 如果请求路径为index，则调用index()方法
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/")
    public String redirect() {
        return "redirect:/index";
    }

    @RequestMapping("/sysinfo")
    @ResponseBody  // @ResponseBody的作用其实是将java对象转为json格式的数据
    public String sysInfo() {
        Map<String, String> m = new HashMap<>();

        m.put("tomcat_version", ServerInfo.getServerInfo());
        m.put("app_name", "Java SEC");
        m.put("java_version", System.getProperty("java.version"));
        m.put("fastjson_version", JSON.VERSION);

        return JSON.toJSONString(m);

    }

    @GetMapping("/index/xss")
    public static String xss() {
        return "xss";
    }

    @GetMapping("/index/spel")
    public static String spel(){
        return "spel";
    }

    @GetMapping("/index/rce")
    public static String rce(){
        return "rce";
    }

    @GetMapping("/index/ssti")
    public static String ssti(){
        return "ssti";
    }

}
