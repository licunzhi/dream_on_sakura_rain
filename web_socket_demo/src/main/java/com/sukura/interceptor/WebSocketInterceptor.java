package com.sukura.interceptor;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import java.util.Map;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-07-24
 */
public class WebSocketInterceptor extends HttpSessionHandshakeInterceptor {

    // 握手操作之前的数据处理
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
                    Map<String, Object> attributes) throws Exception {
        // 可以获取数据信息，简单额进行数据处理曹组
        System.out.println("进行握手拦截操作，在这部分可以取出request的参数进行处理操作之后提供使用");
        return true;
    }

    // 握手操作之后的数据处理
    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
                    Exception ex) {
        System.out.println("拦截操作结束执行的代码部分");
    }
}
