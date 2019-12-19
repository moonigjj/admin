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
 * @version $Id: IndexVO.java, v 0.1 2019-12-19 16:23 tangyue Exp $$
 */
@Data
public class IndexVO implements Serializable {
    /**
     * clearInfo : {"clearUrl":"api/clear.json"}
     * homeInfo : {"title":"首页","icon":"fa fa-home","href":"page/welcome-1.html?mpi=m-p-i-0"}
     * logoInfo : {"title":"LayuiMini","image":"images/logo.png","href":""}
     * menuInfo : {"currency":{"title":"常规管理","icon":"fa fa-address-book","child":[{"title":"主页模板","href":"","icon":"fa fa-home","target":"_self","child":[{"title":"主页一","href":"page/welcome-1.html","icon":"fa fa-tachometer","target":"_self"},{"title":"主页二","href":"page/welcome-2.html","icon":"fa fa-tachometer","target":"_self"}]},{"title":"菜单管理","href":"page/menu.html","icon":"fa fa-window-maximize","target":"_self"},{"title":"系统设置","href":"page/setting.html","icon":"fa fa-gears","target":"_self"},{"title":"表格示例","href":"page/table.html","icon":"fa fa-file-text","target":"_self"},{"title":"表单示例","href":"","icon":"fa fa-calendar","target":"_self","child":[{"title":"普通表单","href":"page/form.html","icon":"fa fa-list-alt","target":"_self"},{"title":"分步表单","href":"page/form-step.html","icon":"fa fa-navicon","target":"_self"}]},{"title":"登录模板","href":"","icon":"fa fa-flag-o","target":"_self","child":[{"title":"登录-1","href":"page/login-1.html","icon":"fa fa-stumbleupon-circle","target":"_blank"},{"title":"登录-2","href":"page/login-2.html","icon":"fa fa-viacoin","target":"_blank"}]},{"title":"异常页面","href":"","icon":"fa fa-home","target":"_self","child":[{"title":"404页面","href":"page/404.html","icon":"fa fa-hourglass-end","target":"_self"}]},{"title":"其它界面","href":"","icon":"fa fa-snowflake-o","target":"","child":[{"title":"按钮示例","href":"page/button.html","icon":"fa fa-snowflake-o","target":"_self"},{"title":"弹出层","href":"page/layer.html","icon":"fa fa-shield","target":"_self"}]}]}}
     */

    private MenuVO homeInfo;
    private MenuVO logoInfo;
    private List<MenuVO> menuInfo;

}
