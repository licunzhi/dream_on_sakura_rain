package com.knife4j.demo.api;

import com.knife4j.demo.doc.bean.Order;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiOperationSupport;
import io.swagger.annotations.ApiSort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName AuthController
 * @Description 登录鉴权
 * @Author lcz
 * @Date 2019/11/08 16:33
 */
@Api(value = "AuthController", tags = "登录鉴权服务")
@ApiSort(value = 0)
@RequestMapping("/auth")
@RestController
public class AuthController {

    /**
     * 获取验证码图片base64编码
     *
     * @param request  request
     * @param response response
     * @return 图片编码
     */
    @ApiOperationSupport(order = 1)
    @ApiOperation(value = "登录鉴权-获取验证码", position = 1, notes = "登录鉴权-获取验证码", produces = "application/json", response = Order.class)
    @GetMapping("/getValidateCode")
    public String getValidateCode(HttpServletRequest request, HttpServletResponse response) {
        return "ok";
    }

    /**
     * 用户登录
     *
     * @param request  request
     * @param response response
     * @return 登录结果
     */
    @ApiOperation(value = "用户登录", position = 2, notes = "用户登录", produces = "application/json", response = String.class)
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "code", value = "地市编码", required = true, dataType = "String", paramType = "query", example = "010"),
            @ApiImplicitParam(name = "encode", value = "区县编码", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "account", value = "街道编码", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "统计月份(yyyyMM)", required = true, dataType = "String", paramType = "query", example = "201903"),
    })
    @PostMapping("/getToken")
    public String loginAction(HttpServletRequest request, HttpServletResponse response) {
        return "ok";
    }

}
