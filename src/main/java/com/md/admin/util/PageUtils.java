/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package com.md.admin.util;


import com.md.admin.web.vo.PageVO;

/**
 *
 * @author tangyue
 * @version $Id: PageUtils.java, v 0.1 2019-12-23 19:46 tangyue Exp $$
 */
public final class PageUtils {

    public static void setPageNum(PageVO page){
        page.setPageNum((page.getPageNum() - 1) * page.getPageSize());
    }
}
