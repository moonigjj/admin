/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package com.md.admin.webmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 *
 * @author tangyue
 * @version $Id: NewsSpider.java, v 0.1 2019-12-13 10:39 tangyue Exp $$
 */
public class NewsListSpider implements PageProcessor {

    private Site site = Site.me().setDomain("127.0.0.1");

    @Override
    public void process(Page page) {

    }

    @Override
    public Site getSite() {
        return site;
    }
}
