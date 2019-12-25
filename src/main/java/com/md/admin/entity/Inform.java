/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package com.md.admin.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 *
 * @author tangyue
 * @version $Id: Inform.java, v 0.1 2019-12-25 17:13 tangyue Exp $$
 */
@Data
@TableName("md_inform")
public class Inform implements Serializable {

    private Long id;

    private Long newId;

    private Long typeId;

    private String lang;

    private String title;

    private String subTitle;

    private String remark;

    private String content;

    private String tdate;

    private Date createTime;
}
