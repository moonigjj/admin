/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package com.md.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.md.admin.entity.Inform;
import com.md.admin.web.vo.InformVO;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
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

    /**
     * 通过语言日期查询记录
     * @param lang
     * @param tDate
     * @return
     */
    Inform selectByTDate(@Param("lang") String lang, @Param("tDate") String tDate);

    @Insert("insert into md_inform (new_id, type_id, lang, title, sub_title, remark, content, tdate, create_time) " +
            "values (#{newId}, #{typeId}, #{lang}, #{title}, #{subTitle}, #{remark}, #{content}, #{tdate}, #{createTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insertInform(Inform inform);
}
