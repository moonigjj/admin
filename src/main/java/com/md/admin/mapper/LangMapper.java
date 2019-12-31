/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package com.md.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.md.admin.entity.Lang;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * @author tangyue
 * @version $Id: LangMapper.java, v 0.1 2019-12-26 17:44 tangyue Exp $$
 */
public interface LangMapper extends BaseMapper<Lang> {

    Lang selectTextOne(@Param("lang") String lang);

    List<Lang> selectAll();
}
