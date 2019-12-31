/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package com.md.admin;

import com.md.admin.entity.Inform;
import com.md.admin.service.InformService;
import com.md.admin.tran.GoogleApi;
import com.md.admin.util.GsonUtil;
import com.md.admin.web.convert.InformMapping;
import com.md.admin.web.vo.InformVO;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author tangyue
 * @version $Id: GoogleApiTest.java, v 0.1 2019-12-31 14:09 tangyue Exp $$
 */
@Slf4j
public class GoogleApiTest extends AdminApplicationTests {

    @Autowired
    private InformService informService;

    @Autowired
    private InformMapping informMapping;


    @Test
    public void test(){

        Inform inform = this.informService.getById(26L);
        String content = inform.getContent();
        inform.setContent(null);
        InformVO informVO = informMapping.entityToVo(inform);
        String json = GsonUtil.GsonString(informVO);
        log.info("informVO info: {}", json);

        GoogleApi googleApi = new GoogleApi();
        try {
            String result = googleApi.translate(json,"zh-CN" ,"en");
            Inform res = GsonUtil.GsonToBean(result, Inform.class);
            res.setId(null);
            res.setLang("en");
            log.info("res: {}", res);
            log.info("result: {}", result);
            String c = googleApi.translate(content, "zh-CN", "en");

            res.setContent(c);
            //this.informService.save(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
