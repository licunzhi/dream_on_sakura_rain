# dream_on_sakura_rain
项目下有更不同的demo，运行执行指定的项目模块即可


> ##  springboot_rabbit_demo : 在spiringboot中使用rabbit

项目配置信息（可以自己修改成自己环境地址）
```properties
#默认端口配置
server.port=8080

# rabbit配置
spring.rabbitmq.host=127.0.0.1
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest
spring.rabbitmq.virtual-host=/
```

你将在控制台看到下图的效果展示（数据是每分钟推送一次）

![展示信息](https://github.com/licunzhi/dream_on_sakura_rain/blob/master/springboot_rabbit_demo/images/result.png)

> ##  web_socket_demo:简单的websocket实现

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
