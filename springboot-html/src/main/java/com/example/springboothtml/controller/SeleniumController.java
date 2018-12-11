package com.example.springboothtml.controller;

import com.example.springboothtml.domain.ListData;
import com.example.springboothtml.service.SeleniumService;
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
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author licunzhi
 * @desc 使用selenium实现
 * @date 2018-11-17
 */
@RequestMapping("/selenium")
@RestController
@Api(value = "使用selenium测试实现", tags = "和原有的接口进行剥离")
public class SeleniumController {

    @Autowired
    private SeleniumService seleniumService;

    @ApiIgnore
    @ApiOperation(value = "selenium的功能测试", notes = "用于测试操作的接口实现，非正式版本不能用version:1.0")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "query", value = "关键字搜索", defaultValue = "孟俊才", required = true, dataType = "String", paramType = "query")})
    @GetMapping("/demo_use")
    public ResponseEntity demoUse(String query) {
        return seleniumService.demoUse(query);
    }

    @ApiOperation(value = "selenium自动化测试的方式抓取数据", notes = "使用此版本接口进行数据抓取version:2.0")//接口功能解释
    @ApiImplicitParams(value = {
                    @ApiImplicitParam(name = "query", value = "查询关键字(多个查询用-分割)[不建议一次查询多个 数据量太大]", required = true, dataType = "String", paramType = "query"),
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
        return seleniumService.scrapHtml(query, startPage, endPage, sortType, picture);
    }
}
