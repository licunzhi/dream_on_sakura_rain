package com.example.springboothtml.domain;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-11-17
 */
public class product {
    private String title;
    private String raw_title;
    private String pic_url;
    private String detail_url;
    private String view_price;
    private String view_sales;
    private String nick;
    private String comment_url;
    private String shopLink;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRaw_title() {
        return raw_title;
    }

    public void setRaw_title(String raw_title) {
        this.raw_title = raw_title;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public String getDetail_url() {
        return detail_url;
    }

    public void setDetail_url(String detail_url) {
        this.detail_url = detail_url;
    }

    public String getView_price() {
        return view_price;
    }

    public void setView_price(String view_price) {
        this.view_price = view_price;
    }

    public String getView_sales() {
        return view_sales;
    }

    public void setView_sales(String view_sales) {
        this.view_sales = view_sales;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getComment_url() {
        return comment_url;
    }

    public void setComment_url(String comment_url) {
        this.comment_url = comment_url;
    }

    public String getShopLink() {
        return shopLink;
    }

    public void setShopLink(String shopLink) {
        this.shopLink = shopLink;
    }
}
