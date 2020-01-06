/**
 * chenxitech.cn Inc. Copyright (c) 2017-2020 All Rights Reserved.
 */
package com.md.admin.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.md.admin.entity.SysRole;
import com.md.admin.mapper.SysRoleMapper;

import org.springframework.stereotype.Service;

/**
 *
 * @author tangyue
 * @version $Id: SysUserService.java, v 0.1 2020-01-06 16:30 tangyue Exp $$
 */
@Service
public class SysRoleService extends ServiceImpl<SysRoleMapper, SysRole> {

    public SysRole findByName(String name){
        return this.baseMapper.findByName(name);
    }
}
