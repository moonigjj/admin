/**
 * chenxitech.cn Inc. Copyright (c) 2017-2020 All Rights Reserved.
 */
package com.md.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.md.admin.entity.SysRole;

import org.apache.ibatis.annotations.Param;

/**
 *
 * @author tangyue
 * @version $Id: SysRoleMapper.java, v 0.1 2020-01-06 10:08 tangyue Exp $$
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    SysRole findByName(@Param("name") String name);
}
