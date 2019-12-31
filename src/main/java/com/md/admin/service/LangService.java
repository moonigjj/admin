/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package com.md.admin.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.md.admin.entity.Lang;
import com.md.admin.mapper.LangMapper;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author tangyue
 * @version $Id: LangService.java, v 0.1 2019-12-27 17:16 tangyue Exp $$
 */
@Service
public class LangService extends ServiceImpl<LangMapper, Lang> {

    public Lang findTextOne(String lang){

        return this.baseMapper.selectTextOne(lang);
    }

    /**
     * 查询除zh-CN以外的
     * @return
     */
    public List<Lang> findAll(){
        return this.baseMapper.selectAll();
    }
}
