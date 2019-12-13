/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package com.md.admin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author tangyue
 * @version $Id: LoginController.java, v 0.1 2019-12-10 12:28 tangyue Exp $$
 */
@Controller
public class LoginController {


    @GetMapping(value = "/")
    public String toLogin(){
        return "login";
    }

    @PostMapping(value = "/login")
    public Object login(){

        return "";
    }
}
