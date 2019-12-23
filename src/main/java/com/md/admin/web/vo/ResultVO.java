/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package com.md.admin.web.vo;

import java.io.Serializable;

import lombok.Data;

/**
 *
 * @author tangyue
 * @version $Id: ResultVO.java, v 0.1 2019-12-23 19:37 tangyue Exp $$
 */
@Data
public class ResultVO<T> implements Serializable {

    private Integer code = 200;

    private String msg = "操作成功";

    private T result;
}
