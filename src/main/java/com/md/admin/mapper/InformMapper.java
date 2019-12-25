/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package com.md.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.md.admin.entity.Inform;
import com.md.admin.web.vo.InformVO;

import org.apache.ibatis.annotations.Param;

/**
 *
 * @author tangyue
 * @version $Id: InformMapper.java, v 0.1 2019-12-25 17:15 tangyue Exp $$
 */
public interface InformMapper extends BaseMapper<Inform> {

    /**
     * 分页
     * @param page
     * @param lang
     * @return
     */
    IPage<InformVO> selectAll(Page page, @Param("lang") String lang);
}
