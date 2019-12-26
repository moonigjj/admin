/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package com.md.admin.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 *
 * @author tangyue
 * @version $Id: Lang.java, v 0.1 2019-12-26 16:37 tangyue Exp $$
 */
@Data
public class Lang implements Serializable {

    private Long id;

    private String lang;

    private String gtLang;

    private String remark;

    private Date createTime;
}
