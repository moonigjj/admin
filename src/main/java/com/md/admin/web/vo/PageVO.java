/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package com.md.admin.web.vo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author tangyue
 * @version $Id: PageVO.java, v 0.1 2019-12-23 19:39 tangyue Exp $$
 */
@Getter
@Setter
public class PageVO implements Serializable {

    private Integer pageNum = 1;

    private Integer pageSize = 10;
}
