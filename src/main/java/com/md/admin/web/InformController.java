/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package com.md.admin.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.md.admin.entity.Inform;
import com.md.admin.entity.Lang;
import com.md.admin.entity.News;
import com.md.admin.service.InformService;
import com.md.admin.service.LangService;
import com.md.admin.web.convert.InformMapping;
import com.md.admin.web.face.CommonService;
import com.md.admin.web.vo.InformPageVO;
import com.md.admin.web.vo.InformVO;
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
 * @version $Id: InformController.java, v 0.1 2019-12-25 17:12 tangyue Exp $$
 */
@Controller
@RequestMapping(value = "/inform")
public class InformController {

    @Autowired
    private InformService informService;

    @Autowired
    private InformMapping informMapping;

    @Autowired
    private LangService langService;

    @Autowired
    private CommonService commonService;


    @GetMapping(value = "/list")
    public Object list(){

        return "informList";
    }

    @PostMapping(value = "/list")
    @ResponseBody
    public ResultVO getAllPage(@RequestBody InformPageVO pageVO){

        ResultVO resultVO = new ResultVO();
        Page<InformVO> page = new Page<>(pageVO.getPageNum(), pageVO.getPageSize());
        IPage<InformVO> iPage = this.informService.findAllPage(page, pageVO.getLang());
        resultVO.setResult(iPage);
        return resultVO;
    }

    @GetMapping(value = "/toedit/{informId}")
    public String toEdit(@PathVariable("informId") Long informId, Model model){

        Inform inform = this.informService.getById(informId);
        InformVO informVO = informMapping.entityToVo(inform);
        Lang lang = this.langService.findTextOne(informVO.getLang());
        informVO.setLangName(lang.getRemark());
        model.addAttribute("inform", informVO);
        return "informEdit";
    }

    @PostMapping(value = "/edit")
    @ResponseBody
    public ResultVO edit(@RequestBody InformVO informVO){

        ResultVO resultVO = new ResultVO();
        Inform inform = this.informMapping.voToEntity(informVO);
        this.informService.updateById(inform);
        return resultVO;
    }

    @GetMapping(value = "/translate/{informId}")
    @ResponseBody
    public ResultVO translate(@PathVariable("informId") Long informId) throws Exception {
        ResultVO resultVO = new ResultVO();
        Inform inform = this.informService.getById(informId);
        if (inform == null){
            resultVO.setMsg("数据不存在");
            return resultVO;
        }
        commonService.translate("zh-CN", inform.getLang(), inform);
        this.informService.updateById(inform);
        return resultVO;
    }


    @GetMapping(value = "/del/{informId}")
    @ResponseBody
    public ResultVO del(@PathVariable("informId") Long informId){

        ResultVO resultVO = new ResultVO();
        this.informService.removeById(informId);
        return resultVO;
    }
}
