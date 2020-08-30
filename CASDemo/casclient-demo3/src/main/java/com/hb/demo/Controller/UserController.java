package com.hb.demo.Controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hb
 * @create 2020-08-12 21:07
 */
@RestController
public class UserController {

    @RequestMapping("/getLoginUser")
    public void getLoginUser(){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(name);
    }
}
