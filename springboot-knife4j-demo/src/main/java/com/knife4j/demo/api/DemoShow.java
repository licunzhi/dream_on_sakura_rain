package com.knife4j.demo.api;

import com.knife4j.demo.doc.bean.Order;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiOperationSupport;
import io.swagger.annotations.ApiSort;
import io.swagger.annotations.DynamicParameter;
import io.swagger.annotations.DynamicParameters;
import io.swagger.annotations.DynamicResponseParameters;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName DemoShow
 * @Description 侵入式接口文档精简教程说明
 * @Author lcz
 * @Date 2019/11/08 16:33
 */
@Api(value = "DemoShow", tags = "演示增强本使用接口方式")
@ApiSort(value = 1)// 大分类顺序
@RequestMapping("/authAfter")
@RestController
public class DemoShow {

    /**
     * 单层级文档说明，一般业务参考此处即可
     *
     * ①query参数
     * ②body参数说明
     * ③url路径参数（不建议使用）
     *
     * query 参数说明：实际开发中删减下面代码中的字段属性
     * body  参数说明：此方法对单层传输参数使用，一般业务情况足够使用
     * url   参数说明：url携带参数不建议使用[url协调不好会导致越权问题]
     */
    @ApiOperation(value = "jdk-Map-动态创建显示参数", produces = "application/json")
    @ApiImplicitParams(value = {
            /*query参数*/
            @ApiImplicitParam(name = "id", value = "注解id", required = true, dataTypeClass = String.class, paramType = "query", example = "000001"),
            @ApiImplicitParam(name = "name", value = "注解名称", required = true, dataTypeClass = Integer.class, paramType = "query", example = "mk567"),
            /*url参数*/
            @ApiImplicitParam(name = "mk", value = "注解名称", required = true, dataTypeClass = Integer.class, paramType = "path", example = "1234565")
    })
    /*body参数*/
    @ApiOperationSupport(
    params =  @DynamicParameters(name = "createModel01",properties = {
            @DynamicParameter(name = "id",value = "注解id",example = "X000111",required = true,dataTypeClass = Integer.class),
            @DynamicParameter(name = "name",value = "注解名称")
    }),
    responses = @DynamicResponseParameters(name = "CreateOrderMapModel",properties = {
            @DynamicParameter(name = "id",value = "注解id",example = "X000111",required = true,dataTypeClass = Integer.class),
            @DynamicParameter(name = "name",value = "注解名称")
    })
    )
    @PostMapping("/create_01/{mk}")
    public ResponseEntity<Map> create_01(@RequestBody Map map, @PathVariable(value = "mk") String mk){
        System.out.println(mk);
        return ResponseEntity.ok(map);
    }

    /**
     * 多层级文档返回结果说明
     *
     * 多层级返回参数为了更好展示返回数据参数类型需要额外增加doc相关类
     */
    @ApiOperation(value = "多层级返回", produces = "application/json")
    @ApiOperationSupport(
            params =  @DynamicParameters(name = "createModel02",properties = {
                    @DynamicParameter(name = "id",value = "注解id", example = "X000111",required = true,dataTypeClass = Integer.class),
                    @DynamicParameter(name = "name",value = "注解名称")
            }),
            responses = @DynamicResponseParameters(name = "ResponseData",properties = {
                    @DynamicParameter(name = "code",value = "状态码", example = "0"),
                    @DynamicParameter(name = "msg",value = "状态描述", example = "success"),
                    @DynamicParameter(name = "data",value = "结果信息", dataTypeClass = Order.class)
            })
    )
    @PostMapping("/create_02")
    public ResponseEntity<String> create_02(@RequestBody Map map){
        return ResponseEntity.ok("success");
    }

}
