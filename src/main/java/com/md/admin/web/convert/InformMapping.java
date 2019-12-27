/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package com.md.admin.web.convert;

import com.md.admin.entity.Inform;
import com.md.admin.web.vo.InformVO;

import org.mapstruct.Mapper;

/**
 *
 * @author tangyue
 * @version $Id: InformMapping.java, v 0.1 2019-12-26 14:09 tangyue Exp $$
 */
@Mapper(componentModel = "spring")
public interface InformMapping {

    Inform voToEntity(InformVO informVO);

    InformVO entityToVo(Inform inform);
}
