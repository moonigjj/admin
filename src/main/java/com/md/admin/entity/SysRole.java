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
 * @version $Id: SysRole.java, v 0.1 2020-01-02 10:51 tangyue Exp $$
 */
@Data
@TableName(value = "sys_role")
public class SysRole implements Serializable {

    private Long id;

    private String roleName;

    private String remark;

    private Integer checked;

    private Date createTime;
}
