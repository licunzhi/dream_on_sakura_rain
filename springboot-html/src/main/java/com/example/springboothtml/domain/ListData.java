package com.example.springboothtml.domain;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.swing.Icon;
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
                @ApiModel
                public static class Auction {
                    @ApiModelProperty(value = "页面显示标题")
                    private String title;
                    @ApiModelProperty(value = "格式化标题")
                    private String raw_title;
                    @ApiModelProperty(value = "商品价格")
                    private String view_price;
                    @ApiModelProperty(value = "收获人数")
                    private String view_sales;
                    @ApiModelProperty(value = "卖家信息")
                    private String nick;
                    @ApiModelProperty(value = "评论地址")
                    private String comment_url;//评论的连接，以后数据分析很可能需要
                    @ApiModelProperty(value = "购买链接")
                    private String shopLink;//购买链接
                    @ApiModelProperty(value = "商品详情")
                    private String detail_url;//详情链接
                    @ApiModelProperty(value = "图片链接")
                    private String pic_url;//详情链接

                    private List<Icon> icon;

                    @ApiModelProperty(value = "天猫卖家信息")
                    private ShopCard shopcard;

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

                    public List<Icon> getIcon() {
                        return icon;
                    }

                    public void setIcon(List<Icon> icon) {
                        this.icon = icon;
                    }

                    public void setPic_url(String pic_url) {
                        this.pic_url = pic_url;
                    }

                    public ShopCard getShopcard() {
                        return shopcard;
                    }

                    public void setShopcard(ShopCard shopcard) {
                        this.shopcard = shopcard;
                    }

                    public static class ShopCard {
                        private boolean isTmall;

                        public boolean isTmall() {
                            return isTmall;
                        }

                        public void setTmall(boolean tmall) {
                            isTmall = tmall;
                        }
                    }

                    public static class Icon {
                        private String title;
                        private String dom_class;// 金牌卖家的是：icon-service-jinpaimaijia 天猫的icon-service-tianmao

                        public String getTitle() {
                            return title;
                        }

                        public void setTitle(String title) {
                            this.title = title;
                        }

                        public String getDom_class() {
                            return dom_class;
                        }

                        public void setDom_class(String dom_class) {
                            this.dom_class = dom_class;
                        }
                    }
                }
            }
        }
    }
}
