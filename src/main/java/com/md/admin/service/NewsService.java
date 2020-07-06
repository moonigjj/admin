/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package com.md.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.md.admin.entity.News;
import com.md.admin.mapper.NewsMapper;
import com.md.admin.web.vo.NewsPageVO;
import com.md.admin.web.vo.NewsVO;

import org.springframework.stereotype.Service;

/**
 *
 * @author tangyue
 * @version $Id: NewsService.java, v 0.1 2019-12-09 18:00 tangyue Exp $$
 */
@Service
public class NewsService extends ServiceImpl<NewsMapper, News> {

    public News findTextOne(String lang, String type) {
        return this.baseMapper.selectTextOne(lang, type);
    }

    public IPage<NewsVO> findAllPage(Page<NewsVO> page, NewsPageVO pageVO){

        return this.baseMapper.selectAll(page, pageVO);
    }
}
