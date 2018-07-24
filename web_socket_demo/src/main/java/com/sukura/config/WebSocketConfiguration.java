package com.sukura.config;

import com.sukura.handler.WebScoketHandler;
import com.sukura.interceptor.WebSocketInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-07-24
 */
@Configuration
@EnableWebSocket
public class WebSocketConfiguration implements WebSocketConfigurer {

    @Bean
    public WebSocketInterceptor webSocketInterceptor() {
        // 握手拦截
        return new WebSocketInterceptor();
    }

    @Bean
    public WebScoketHandler webScoketHandler() {
        //处理数据类
        return new WebScoketHandler();
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(webScoketHandler(), "/meimei/websocket")
                        .addInterceptors(new WebSocketInterceptor()).setAllowedOrigins("*");
    }

}
