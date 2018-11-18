package com.example.springboothtml.model;

import java.io.Serializable;

/**
 * @author licunzhi
 * @desc 产品页面参数准备
 * @date 2018-11-17
 */
public class ProductHtml implements Serializable {

    private String htmlUrl;

    private String[] pages;

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String[] getPages() {
        return pages;
    }

    public void setPages(String[] pages) {
        this.pages = pages;
    }
}
