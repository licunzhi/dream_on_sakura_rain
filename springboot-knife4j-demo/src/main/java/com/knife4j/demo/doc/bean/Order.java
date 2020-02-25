package com.knife4j.demo.doc.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @ClassName Order
 * @Description 实体类说明
 * @Author lcz
 * @Date 2020/02/25 09:43
 */
@Data
@ApiModel("订单返回属性展示")
public class Order {
    @ApiModelProperty(value = "注解id")
    public String id;
    @ApiModelProperty(value = "注解名称")
    private String name;
    @ApiModelProperty(value = "数组参数")
    private List<String> phones;
    @ApiModelProperty(value = "实体类内嵌")
    private Logistics logistics;
    @ApiModelProperty(value = "键值对内嵌--一般使用实体类内嵌代表")
    private Map<String, String> data;



    @Data
    @ApiModel("物流内嵌")
    private static class Logistics {
        @ApiModelProperty(value = "id")
        public String id;
        @ApiModelProperty(value = "名称")
        private String name;
    }
}
