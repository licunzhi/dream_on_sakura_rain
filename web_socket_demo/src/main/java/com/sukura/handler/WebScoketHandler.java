package com.sukura.handler;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-07-24
 */
public class WebScoketHandler extends TextWebSocketHandler {

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("链接之后方法处理");
        if (session.isOpen()) {
            for (int i = 0; i < 10; i++) {
                session.sendMessage(new TextMessage("xiao mei mei - dream on sakura rain"));
                Thread.sleep(1000);
            }
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("链接结束之后方法处理");
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("处理数据，返回展示数据信息");
    }
}
