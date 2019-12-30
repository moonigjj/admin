/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package com.md.admin.webmagic;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

/**
 *
 * @author tangyue
 * @version $Id: FinancialListSpider.java, v 0.1 2019-12-30 10:40 tangyue Exp $$
 */
@Slf4j
public class FinancialListSpider implements PageProcessor {

    private Site site = Site.me();

    public static final String list = "http://www.bonusfirm.com/financial-comments";

    @Override
    public void process(Page page) {
        if (page.getUrl().regex(list + "/\\d+.html").match()) {

            page.putField("title", page.getHtml().xpath("//div[@class='news_detail]/h1/text()").nodes().get(0));
            page.putField("tdate", page.getHtml().xpath("//div[@class='news_detail]/div[@class='info_title clearfix']/h3[@class='title_bar']/span/text()").nodes().get(0));
            page.putField("newId", 16);
            page.putField("subTitle", page.getHtml().xpath("//div[@class='news_detail]/div[@class='content']/p/text()").nodes().get(0));
            List<Selectable> ps = page.getHtml().xpath("//div[@class='news_detail]/div[@class='content']/p").nodes();
            StringBuilder sb = new StringBuilder();
            for (Selectable s : ps){
                sb.append(s.toString());
            }
            String content = sb.toString();
            page.putField("content", content);

        } else {

            List<Selectable> nodes = page.getHtml().xpath("//ul[@class='news_list clearfix']/li").nodes();
            String link = nodes.get(0).xpath("//h3").links().toString();
            page.addTargetRequest(link);
        }
    }

    @Override
    public Site getSite() {
        return this.site;
    }

    public static void main(String[] args) {

        Spider.create(new FinancialListSpider()).addPipeline(new MysqlPipeline())
                .addUrl(list)
                .thread(1).run();

    }
}
