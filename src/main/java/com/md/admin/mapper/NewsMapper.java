/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package com.md.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.md.admin.entity.News;
import com.md.admin.web.vo.NewsVO;

import org.apache.ibatis.annotations.Param;

/**
 *
 * @author tangyue
 * @version $Id: NewsMapper.java, v 0.1 2019-12-09 17:58 tangyue Exp $$
 */
public interface NewsMapper extends BaseMapper<News> {

    /**
     * 查询title为text
     * @param lang
     * @param type
     * @return
     */
    News selectTextOne(@Param("lang") String lang, @Param("type") String type);

    /**
     * 分页
     * @param page
     * @param lang
     * @return
     */
    IPage<NewsVO> selectAll(Page page, @Param("lang") String lang);
}
