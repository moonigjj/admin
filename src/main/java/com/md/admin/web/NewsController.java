/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package com.md.admin.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.md.admin.service.NewsService;
import com.md.admin.util.PageUtils;
import com.md.admin.web.vo.NewsVO;
import com.md.admin.web.vo.ResultVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author tangyue
 * @version $Id: NewsController.java, v 0.1 2019-12-23 19:36 tangyue Exp $$
 */
@Controller
@RequestMapping(value = "/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @PostMapping(value = "/list")
    @ResponseBody
    public ResultVO getAllPage(@RequestBody NewsVO newsVO){

        ResultVO resultVO = new ResultVO();
        PageUtils.setPageNum(newsVO);
        Page<NewsVO> page = new Page<>(newsVO.getPageNum(), newsVO.getPageSize());
        IPage<NewsVO> iPage = this.newsService.findAllPage(page, newsVO.getLang());
        resultVO.setResult(iPage);
        return resultVO;
    }
}
