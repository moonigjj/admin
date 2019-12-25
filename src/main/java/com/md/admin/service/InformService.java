/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package com.md.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.md.admin.entity.Inform;
import com.md.admin.mapper.InformMapper;
import com.md.admin.web.vo.InformVO;

import org.springframework.stereotype.Service;

/**
 *
 * @author tangyue
 * @version $Id: InformService.java, v 0.1 2019-12-25 17:16 tangyue Exp $$
 */
@Service
public class InformService extends ServiceImpl<InformMapper, Inform> {

    public IPage<InformVO> findAllPage(Page<InformVO> page, String lang){

        return this.baseMapper.selectAll(page, lang);
    }
}
