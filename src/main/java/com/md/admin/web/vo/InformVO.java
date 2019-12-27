/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package com.md.admin.web.vo;

import lombok.Data;

/**
 *
 * @author tangyue
 * @version $Id: InformVO.java, v 0.1 2019-12-25 17:17 tangyue Exp $$
 */
@Data
public class InformVO {

    private Long id;

    private Long newId;

    private Long typeId;

    private String lang;

    private String langName;

    private String title;

    private String subTitle;

    private String remark;

    private String content;

    private String tdate;
}
