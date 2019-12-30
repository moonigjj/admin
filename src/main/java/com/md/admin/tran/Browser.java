/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package com.md.admin.tran;

import com.md.admin.util.HttpClientUtil;

import java.net.InetSocketAddress;
import java.net.Proxy;

/**
 *
 * @author tangyue
 * @version $Id: Browser.java, v 0.1 2019-12-30 17:18 tangyue Exp $$
 */
public class Browser {
    public Proxy proxy;
    public String url;

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void setProxy(String ip, Integer port) {
        this.proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, port.intValue()));
    }

    public String executeGet()
            throws Exception {
        String result;
        if (this.proxy != null)
            result = HttpClientUtil.doGetWithProxy(this.url, this.proxy);
        else {
            result = HttpClientUtil.doGet(this.url);
        }

        return result;
    }
}
