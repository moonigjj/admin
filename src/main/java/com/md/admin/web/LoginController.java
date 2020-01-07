/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package com.md.admin.web;

import com.md.admin.entity.SysUser;
import com.md.admin.web.vo.ResultVO;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author tangyue
 * @version $Id: LoginController.java, v 0.1 2019-12-10 12:28 tangyue Exp $$
 */
@Controller
public class LoginController {


    @GetMapping(value = "/login")
    public String toLogin(){
        return "login";
    }

    @PostMapping(value = "/login")
    @ResponseBody
    public ResultVO login(@RequestBody SysUser user){

        ResultVO resultVO = new ResultVO();
        // 添加用户认证信息
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());
        // 进行验证，这里可以捕获异常，然后返回对应信息
        SecurityUtils.getSubject().login(token);
        resultVO.setMsg("登陆成功");
        return resultVO;
    }

    @GetMapping(value = "/logout")
    public String logout(){

        SecurityUtils.getSubject().logout();
        return "login";
    }
}
