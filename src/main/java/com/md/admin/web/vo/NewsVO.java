/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package com.md.admin.web.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.md.admin.util.DateUtils;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 *
 * @author tangyue
 * @version $Id: NewsVO.java, v 0.1 2019-12-23 19:29 tangyue Exp $$
 */
@Data
public class NewsVO extends PageVO {

    private Long id;

    private String lang;

    private Long parentId;

    private String type;

    private Long typeId;

    private Integer level;

    private Integer sort;

    private String title;

    private String subTitle;

    private String content;

    @JsonFormat(pattern = DateUtils.DATETIME, timezone="GMT+8")
    private Date createTime;
}
