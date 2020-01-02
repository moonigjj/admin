/**
 * chenxitech.cn Inc. Copyright (c) 2017-2020 All Rights Reserved.
 */
package com.md.admin.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 *
 * @author tangyue
 * @version $Id: SysUser.java, v 0.1 2020-01-02 10:50 tangyue Exp $$
 */
@Data
@TableName(value = "sys_user")
public class SysUser implements Serializable {

    private Long id;

    private String userName;

    private String password;

    private String salt;

    private Date createTime;
}
