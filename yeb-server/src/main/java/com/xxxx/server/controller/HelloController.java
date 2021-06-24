package com.xxxx.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yebai
 * @version V1.0
 * @Package com.xxxx.server.controller
 * @Description
 * @date 2021/5/30 15:22
 * @ClassName HelloController
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello Springboot";
    }

    @GetMapping("/employee/basic/hello")
    public String hello2(){
        return "/employee/basic/hello";
    }

    @GetMapping("/employee/advanced/hello")
    public String hello3(){
        return "/employee/advanced/hello";
    }
}
