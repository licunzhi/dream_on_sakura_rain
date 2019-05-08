package com.sakura.rain.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName MyZuulFilter
 * @Description 自定义网管过滤器
 * @Author lcz
 * @Date 2019/05/08 08:55
 */
public class MyZuulFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(MyZuulFilter.class);

    /**
     * 过滤器的类型，执行过滤器的周期所在的位置
     *
     * @return "pre" "route" "post" "error" "static"
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 自定义过滤器的执行顺序
     * 如果不定义的话可能会导致出现顺序执行问题
     *
     * @return 数字顺序
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否执行自定义的过滤方法
     *
     * @return true or false
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 自定义具体过滤方法
     *
     * @return 结果
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        log.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());

        Object accessToken = request.getParameter("accessToken");
        if(accessToken == null) {
            log.warn("access token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }
        log.info("access token ok");
        return null;
    }
}
