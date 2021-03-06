/**
 * chenxitech.cn Inc. Copyright (c) 2017-2020 All Rights Reserved.
 */
package com.md.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.md.admin.entity.SysUser;

import org.apache.ibatis.annotations.Param;

/**
 *
 * @author tangyue
 * @version $Id: SysUserMapper.java, v 0.1 2020-01-06 10:06 tangyue Exp $$
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser findByName(@Param("name") String name, @Param("password") String password);
}
