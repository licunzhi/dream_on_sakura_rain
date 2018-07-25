# dream_on_sakura_rain
项目下有更不同的demo，运行执行指定的项目模块即可





##  web_socket_demo:简单的websocket实现

#####  项目运行浏览器访问地址
> [http://localhost:8080/index](http://127.0.0.1:8080/index)

#### 你可以修改这段代码实现ws的访问地址的修改
```java
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
```



项目运行效果展示
![项目运行效果展示](https://github.com/licunzhi/dream_on_sakura_rain/blob/master/web_socket_demo/images/result.png)
