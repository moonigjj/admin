/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package com.md.admin.web.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.md.admin.util.DateUtils;

import java.util.Date;

import lombok.Data;

/**
 *
 * @author tangyue
 * @version $Id: NewsVO.java, v 0.1 2019-12-23 19:29 tangyue Exp $$
 */
@Data
public class NewsPageVO extends PageVO {


    private String lang;

    private Integer parentId;
}
