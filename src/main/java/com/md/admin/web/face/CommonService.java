/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package com.md.admin.web.face;

import com.md.admin.entity.Inform;
import com.md.admin.entity.News;
import com.md.admin.tran.GoogleApi;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 *
 * @author tangyue
 * @version $Id: CommonService.java, v 0.1 2019-12-31 15:02 tangyue Exp $$
 */
@Service
public class CommonService {

    @Cacheable(cacheNames = "admin", key = "#from + '_' + #to + '_' + #inform.typeId", unless = "#result == null ")
    public Inform translate(String from, String to, Inform inform) throws Exception {

        GoogleApi googleApi = new GoogleApi();
        String title = googleApi.translate(inform.getTitle(), from, to);
        String subTitle = googleApi.translate(inform.getSubTitle(), from, to);
        String content = googleApi.translate(inform.getContent(), from, to);
        inform.setTitle(title);
        inform.setSubTitle(subTitle);
        inform.setContent(content);
        return inform;
    }

    @Cacheable(cacheNames = "admin", key = "#from + '_' + #to + '_' + #news.typeId", unless = "#result == null ")
    public News translate(String from, String to, News news) throws Exception {

        GoogleApi googleApi = new GoogleApi();
        String title = googleApi.translate(news.getTitle(), from, to);
        news.setTitle(title);
        if (news.getSubTitle() != null){
            String subTitle = googleApi.translate(news.getSubTitle(), from, to);
            news.setSubTitle(subTitle);
        }
        if (news.getContent() != null){
            String content = googleApi.translate(news.getContent(), from, to);
            news.setContent(content);
        }

        return news;
    }
}
