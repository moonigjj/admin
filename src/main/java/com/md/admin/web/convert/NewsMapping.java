/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package com.md.admin.web.convert;

import com.md.admin.entity.News;
import com.md.admin.web.vo.NewsVO;

import org.mapstruct.Mapper;

/**
 *
 * @author tangyue
 * @version $Id: NewsMapping.java, v 0.1 2019-12-24 13:30 tangyue Exp $$
 */
@Mapper(componentModel = "spring")
public interface NewsMapping {

    News voToEntity(NewsVO newsVO);

    NewsVO entityToVo(News news);
}
