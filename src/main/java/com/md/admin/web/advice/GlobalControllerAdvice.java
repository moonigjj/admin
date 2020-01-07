/**
 * chenxitech.cn Inc. Copyright (c) 2017-2020 All Rights Reserved.
 */
package com.md.admin.web.advice;

import com.md.admin.web.vo.ResultVO;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author tangyue
 * @version $Id: GlobalControllerAdvice.java, v 0.1 2020-01-02 17:51 tangyue Exp $$
 */
@ControllerAdvice
@Slf4j
public class GlobalControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ResultVO exceptionHandler(Exception ex){

        log.error("Exception info: {}", ex.fillInStackTrace());
        ResultVO resultVO = new ResultVO();
        resultVO.setMsg(ex.getMessage());
        return resultVO;
    }
}
