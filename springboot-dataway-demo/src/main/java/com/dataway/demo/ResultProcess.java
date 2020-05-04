package com.dataway.demo;

import net.hasor.dataway.spi.ApiInfo;
import net.hasor.dataway.spi.ResultProcessChainSpi;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @ClassName ResultProcess
 * @function [定制化结果拦截]
 * @notice 持久化操作不做业务上处理
 * @Author lcz
 * @Date 2020/05/05 00:33
 */
@Component
public class ResultProcess implements ResultProcessChainSpi {

    @Override
    public Object callAfter(boolean formPre, ApiInfo apiInfo, Object result) {
        return new HashMap<String, Object>() {{
            put("method", apiInfo.getMethod());
            put("path", apiInfo.getApiPath());
            put("result", result);
        }};
    }

    @Override
    public Object callError(boolean formPre, ApiInfo apiInfo, Throwable e) {
        return null;
    }
}
