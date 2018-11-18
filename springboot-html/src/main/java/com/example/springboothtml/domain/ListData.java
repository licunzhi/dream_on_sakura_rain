package com.example.springboothtml.domain;

import java.util.List;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-11-17
 */
public class ListData {
    private Mods mods;

    public Mods getMods() {
        return mods;
    }

    public void setMods(Mods mods) {
        this.mods = mods;
    }

    //基础数据内容框架
    public static class Mods {
        private Item itemlist;

        public Item getItemlist() {
            return itemlist;
        }

        public void setItemlist(Item itemlist) {
            this.itemlist = itemlist;
        }

        public static class Item {
            private String status;

            private Data data;

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public Data getData() {
                return data;
            }

            public void setData(Data data) {
                this.data = data;
            }

            public static class Data {
                private String postFeeText;
                private String trace;
                private List<Auction> auctions;

                public String getPostFeeText() {
                    return postFeeText;
                }

                public void setPostFeeText(String postFeeText) {
                    this.postFeeText = postFeeText;
                }

                public String getTrace() {
                    return trace;
                }

                public void setTrace(String trace) {
                    this.trace = trace;
                }

                public List<Auction> getAuctions() {
                    return auctions;
                }

                public void setAuctions(List<Auction> auctions) {
                    this.auctions = auctions;
                }

                // 侧重点  物品的单个模型初始化类
                public static class Auction {
                    private String title;
                    private String raw_title;
                    private String view_price;
                    private String view_sales;
                    private String nick;
                    private String comment_url;//评论的连接，以后数据分析很可能需要
                    private String shopLink;//购买链接
                    private String detail_url;//详情链接
                    private String pic_url;//详情链接

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

                    public String getDetail_url() {
                        return detail_url;
                    }

                    public void setDetail_url(String detail_url) {
                        this.detail_url = detail_url;
                    }

                    public String getPic_url() {
                        return pic_url;
                    }

                    public void setPic_url(String pic_url) {
                        this.pic_url = pic_url;
                    }
                }
            }
        }
    }
}
