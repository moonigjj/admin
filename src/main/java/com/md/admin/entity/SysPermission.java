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
 * @version $Id: SysPermission.java, v 0.1 2020-01-02 16:03 tangyue Exp $$
 */
@Data
@TableName(value = "sys_permission")
public class SysPermission implements Serializable {

    private Long id;

    private String permission;

}
