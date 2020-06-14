package com.sakura.rain;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName TokenFilter
 * @function [token鉴权的拦截器]
 * @notice 持久化操作不做业务上处理
 * @Author lcz
 * @Date 2020/06/12 14:02
 */
@Component
@Slf4j
public class TokenFilter extends ZuulFilter {
    /**
     * to classify a filter by type. Standard types in Zuul are "pre" for pre-routing filtering,
     * "route" for routing to an origin, "post" for post-routing filters, "error" for error handling.
     * We also support a "static" type for static responses see  StaticResponseFilter.
     * Any filterType made be created or added and run by calling FilterProcessor.runFilters(type)
     *
     * @return A String representing that type
     *
     * 过滤器的类型
     * pre route post error
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 定义正数作为执行顺序
     * 若果不进行定义的话可能会存在两个拥有相同的执行顺序
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * a "true" return from this method means that the run() method should be invoked
     *
     * @return true if the run() method should be invoked. false will not invoke the run() method
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        log.info("TokenFilter affect .......");
        // 获取当前的request对象
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        //下面可以根据请求中的指定参数进行判断：这里面我根据header里面的某个参数进行判断
        String sakura = request.getHeader("sakura");
        if (!"sakura".equals(sakura)) {
            // 拦截请求
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            currentContext.getResponse().setContentType("application/json;charset=UTF-8");
            currentContext.setResponseBody("空手套接口不可能的");
        }
        return null;
    }
}
