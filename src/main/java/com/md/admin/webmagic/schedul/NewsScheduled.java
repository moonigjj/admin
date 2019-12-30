/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package com.md.admin.webmagic.schedul;

import com.md.admin.webmagic.FinancialListSpider;
import com.md.admin.webmagic.MysqlPipeline;
import com.md.admin.webmagic.NewsListSpider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import us.codecraft.webmagic.Spider;

/**
 *
 * @author tangyue
 * @version $Id: NewsScheduled.java, v 0.1 2019-12-30 11:21 tangyue Exp $$
 */
@Component
public class NewsScheduled {


    @Autowired
    private MysqlPipeline mysqlPipeline;

    @Scheduled(cron = "0 0 0/2 * * ?")
    public void newsScheduled() {

        Spider.create(new NewsListSpider())
                .addUrl(NewsListSpider.list).addPipeline(mysqlPipeline)
                .thread(1).run();
    }


    @Scheduled(cron = "0 0 0/2 * * ?")
    public void financialScheduled() {

        Spider.create(new FinancialListSpider())
                .addUrl(FinancialListSpider.list).addPipeline(mysqlPipeline)
                .thread(1).run();
    }

}
