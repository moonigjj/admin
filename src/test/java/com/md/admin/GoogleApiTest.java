/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package com.md.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.md.admin.entity.Inform;
import com.md.admin.entity.News;
import com.md.admin.entity.SysRole;
import com.md.admin.service.InformService;
import com.md.admin.service.NewsService;
import com.md.admin.service.SysRoleService;
import com.md.admin.tran.GoogleApi;
import com.md.admin.util.GsonUtil;
import com.md.admin.web.convert.InformMapping;
import com.md.admin.web.face.CommonService;
import com.md.admin.web.vo.InformVO;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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


    @Autowired
    private SysRoleService roleService;

    @Autowired
    private NewsService newsService;

    @Autowired
    private CommonService commonService;

    @Test
    public void testRole(){

        SysRole role = new SysRole();
        role.setRoleName("test");
        role.setChecked(1);
        role.setCreateTime(new Date());
        role.setRemark("测试");

        this.roleService.save(role);

        log.info("back info: {}", role);
    }

    @Test
    public void testLang(){
        List<String> list = new ArrayList();
        list.add("fr");//法语
        list.add("de");// 德语
        list.add("es");// 西班牙语
        list.add("it");// 意大利语
        list.add("ja");//Japan日语
        list.add("ar");//阿拉伯语

        QueryWrapper<News> news = new QueryWrapper<>();
        news.ge("lang", "zh-CN").orderByAsc("id");
        List<News> newsList = this.newsService.list(news);
        //log.info("zh-CN info: {}", newsList.get(62));
        for (String lang : list){
            List<News> list1 = new ArrayList<>();
            for (News news1 : newsList){
                news1.setLang(lang);
                news1.setId(null);
                list1.add(news1);
            }
            //this.newsService.saveBatch(list1);
        }
    }

    @Test
    public void testTran(){
        QueryWrapper<News> news = new QueryWrapper<>();
        news.gt("id", "456").notIn("lang", "zh-CN", "en").orderByAsc("id");
        List<News> newsList = this.newsService.list(news);
        log.info("not in: {}", newsList.size());
        /*for (News news1 : newsList){
            try {
                commonService.translate("zh-CN", news1.getLang(), news1);
                this.newsService.updateById(news1);
            } catch (Exception e) {
                continue;
            }
        }*/
    }

    @Test
    public void test(){

        Inform inform = this.informService.getById(26L);
        String content = inform.getContent();
        inform.setContent(null);
        InformVO informVO = informMapping.entityToVo(inform);
        String json = GsonUtil.GsonString(informVO);
        log.info("informVO info: {}", json);

        /*GoogleApi googleApi = new GoogleApi();
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
        }*/
    }
}
