package com.example.springboothtml.controller;

import com.example.springboothtml.domain.ListData;
import com.example.springboothtml.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author licunzhi
 * @desc 产品销量和价钱统计控制层
 * @date 2018-11-17
 */
@RequestMapping("/products")
@RestController
@Api(value = "统计销量价格相关接口", tags = "暴露网页接口")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation(value = "抓取网页数据", notes = "抓取网页数据接口")//接口功能解释
    @ApiImplicitParams(value = {
                    @ApiImplicitParam(name = "query", value = "查询关键字(多个查询用-分割)", required = true, dataType = "String", paramType = "query"),
                    @ApiImplicitParam(name = "startPage", value = "起始页", required = true, dataType = "int", paramType = "query"),
                    @ApiImplicitParam(name = "endPage", value = "终止页", required = true, dataType = "int", paramType = "query"),
                    @ApiImplicitParam(name = "sortType", value = "排序方式(1:综合排序 2：销量排序)", allowableValues = "2,1", required = true, dataType = "int", paramType = "query"),
                    @ApiImplicitParam(name = "picture", value = "是否抓取图片(默认false)[此操作会导致数据采集速度变慢，误差因素会导致部分图片采集失败]", allowableValues = "false,true", defaultValue = "false", required = true, dataType = "boolean", paramType = "query")})
    @ApiResponses(value = {
                    @ApiResponse(code = 200, message = "成功操作", response = ListData.Mods.Item.Data.Auction.class)
    })
    @GetMapping("/list/html")
    public ResponseEntity scrapHtml(String query, Integer startPage, Integer endPage, Integer sortType,
                    Boolean picture) {
        return productService.scrapHtml(query, startPage, endPage, sortType, picture);
    }

    @ApiOperation(value = "代理ip资源池测试信息", notes = "ip资源池数据测试")
    @ApiResponses(value = {
                    @ApiResponse(code = 200, message = "成功操作", response = ListData.Mods.Item.Data.Auction.class)
    })
    @GetMapping("/pools")
    public ResponseEntity getIpPool() {
        return productService.getIpPool();
    }
}
