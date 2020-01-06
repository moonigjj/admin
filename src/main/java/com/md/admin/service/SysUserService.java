/**
 * chenxitech.cn Inc. Copyright (c) 2017-2020 All Rights Reserved.
 */
package com.md.admin.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.md.admin.entity.SysUser;
import com.md.admin.mapper.SysUserMapper;

import org.springframework.stereotype.Service;

/**
 *
 * @author tangyue
 * @version $Id: SysUserService.java, v 0.1 2020-01-06 16:30 tangyue Exp $$
 */
@Service
public class SysUserService extends ServiceImpl<SysUserMapper, SysUser> {

    public SysUser findByName(String name, String password){
        return this.baseMapper.findByName(name, password);
    }
}
