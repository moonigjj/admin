/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package com.md.admin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author tangyue
 * @version $Id: IndexController.java, v 0.1 2019-12-17 16:10 tangyue Exp $$
 */
@Controller
public class IndexController {

    @GetMapping(value = "/index")
    public Object index(){


        return "index";
    }

}
