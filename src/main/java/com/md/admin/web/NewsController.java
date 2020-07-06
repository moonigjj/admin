/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package com.md.admin.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.md.admin.entity.Lang;
import com.md.admin.entity.News;
import com.md.admin.service.LangService;
import com.md.admin.service.NewsService;
import com.md.admin.util.PageUtils;
import com.md.admin.web.convert.NewsMapping;
import com.md.admin.web.face.CommonService;
import com.md.admin.web.vo.NewsPageVO;
import com.md.admin.web.vo.NewsVO;
import com.md.admin.web.vo.ResultVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    private NewsMapping newsMapping;

    @Autowired
    private LangService langService;

    @Autowired
    private CommonService commonService;

    @GetMapping(value = "/list")
    public Object list(){

        return "welcome";
    }

    @PostMapping(value = "/list")
    @ResponseBody
    public ResultVO getAllPage(@RequestBody NewsPageVO pageVO){

        ResultVO resultVO = new ResultVO();
        //PageUtils.setPageNum(pageVO);
        Page<NewsVO> page = new Page<>(pageVO.getPageNum(), pageVO.getPageSize());
        IPage<NewsVO> iPage = this.newsService.findAllPage(page, pageVO);
        resultVO.setResult(iPage);
        return resultVO;
    }

    @PostMapping(value = "/add")
    @ResponseBody
    public ResultVO add(@RequestBody NewsVO newsVO){

        ResultVO resultVO = new ResultVO();

        return resultVO;
    }

    @GetMapping(value = "/toedit/{newsId}")
    public String toEdit(@PathVariable("newsId") Long newsId, Model model){

        News news = this.newsService.getById(newsId);
        NewsVO newsVO = this.newsMapping.entityToVo(news);
        Lang lang = this.langService.findTextOne(newsVO.getLang());
        newsVO.setLangName(lang.getRemark());
        model.addAttribute("news", newsVO);
        return "newsEdit";
    }

    @PostMapping(value = "/edit")
    @ResponseBody
    public ResultVO edit(@RequestBody NewsVO newsVO){

        ResultVO resultVO = new ResultVO();
        News news = newsMapping.voToEntity(newsVO);
        this.newsService.updateById(news);
        return resultVO;
    }

    @GetMapping(value = "/translate/{newsId}")
    @ResponseBody
    public ResultVO translate(@PathVariable("newsId") Long newsId) throws Exception {
        ResultVO resultVO = new ResultVO();
        News news = this.newsService.getById(newsId);
        if (news == null){
            resultVO.setMsg("数据不存在");
            return resultVO;
        }
        commonService.translate("zh-CN", news.getLang(), news);
        this.newsService.updateById(news);
        return resultVO;
    }
}
