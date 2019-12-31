/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package com.md.admin.webmagic;

import com.md.admin.entity.Inform;
import com.md.admin.entity.Lang;
import com.md.admin.service.InformService;
import com.md.admin.service.LangService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 *
 * @author tangyue
 * @version $Id: MysqlPipeline.java, v 0.1 2019-12-13 10:42 tangyue Exp $$
 */
@Slf4j
@Component
public class MysqlPipeline implements Pipeline {

    @Autowired
    private InformService informService;

    @Autowired
    private LangService langService;

    @Override
    public void process(ResultItems items, Task task) {

        log.info("ResultItems: {}", items.getAll());
        Map<String, Object> item = items.getAll();
        if (item.get("tdate") == null){
            return;
        }

        String tDate = item.get("tdate").toString();
        log.info("tdate: {}", tDate);
        if (StringUtils.isBlank(tDate)){
            return;
        }
        Inform inform = this.informService.findByTDate("zh-CN", tDate);
        if (inform != null){
            return;
        }
        Date now = new Date();
        inform = new Inform();
        inform.setLang("zh-CN");
        inform.setTitle(item.get("title").toString());
        inform.setSubTitle(item.get("subTitle").toString());
        inform.setContent(item.get("content").toString());
        inform.setTdate(tDate);
        inform.setRemark("");
        inform.setNewId(Long.parseLong(item.get("newId").toString()));
        inform.setCreateTime(now);

        this.informService.insetAfterUpdate(inform);

        List<Lang> langs = this.langService.findAll();
        List<Inform> informs = new ArrayList<>();
        for (Lang lang : langs){
            inform.setId(null);
            inform.setLang(lang.getGtLang());
            Inform in = new Inform();
            BeanUtils.copyProperties(inform, in);
            informs.add(in);
        }
        log.info("Inform save batch");
        this.informService.saveBatch(informs);
    }
}
