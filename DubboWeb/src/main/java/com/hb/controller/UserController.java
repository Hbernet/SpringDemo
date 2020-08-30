package com.hb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hb.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author hb
 * @create 2020-07-14 18:48
 */
@Controller
@RequestMapping("/test")
public class UserController {

    @Reference
    private TestService testService;

    @RequestMapping("/showName")
    @ResponseBody
    public String showName(){

       return "dubboweb调用"+testService.getName();
    }

}
