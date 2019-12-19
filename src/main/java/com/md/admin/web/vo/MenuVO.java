/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package com.md.admin.web.vo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 *
 * @author tangyue
 * @version $Id: MenuVO.java, v 0.1 2019-12-19 16:57 tangyue Exp $$
 */
@Data
public class MenuVO implements Serializable {

    private Long id;

    private String menuName;

    private String menuIcon;

    private String menuUrl;

    private List<MenuVO> child;

}
