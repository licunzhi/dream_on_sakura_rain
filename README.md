# dream_on_sakura_rain
项目下有更不同的demo，运行执行指定的项目模块即可

> #### loadingcache_demo : 在spiringboot中使用loadingcache_demo

-[ ] 修改过期策略以及最大容量代码段
```java

 @Bean
    public LoadingCache<String, String> dataCacheStorage() {
        return CacheBuilder.newBuilder().maximumSize(30000000).build(new CacheLoader<String, String>() {
            @Override
            public String load(String key) throws Exception {
                System.out.println("该值在缓存中不存在，进行预加载。。。。。" + key);
                String result = key + UUID.randomUUID().toString();
                return result;
            }
        });
    }
```

-[ ] 运行项目可以直接在test模块中运行项目
```java
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoadingcacheApplicationTests {

	@Autowired
	private LoadingCache<String, String> dataCacheStorage;

	@Test
	public void dataCacheGetValueTest() throws ExecutionException {
		// 首次取值不存在
		System.out.println("'首次取值：" + dataCacheStorage.get("not exist"));
		// 再次取值已经存在  不加载load方法
		dataCacheStorage.get("not exist");
		System.out.println("'再次取值：" + dataCacheStorage.get("not exist"));
		// 首次取值不存在
		dataCacheStorage.get("not exist one");
		System.out.println("'首次取值：" + dataCacheStorage.get("not exist one"));
	}

}

```

#### 运行效果
![项目运行效果展示](https://github.com/licunzhi/dream_on_sakura_rain/blob/master/loadingcache_demo/images/result.png)

> #### springboot_redis_demo : 在spiringboot中使用redis

* 
* 

> #### springboot_rabbit_demo : 在spiringboot中使用rabbit

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

> #### web_socket_demo:简单的websocket实现

#####  项目运行浏览器访问地址
> [http://localhost:8080/index](http://127.0.0.1:8080/index)

##### 你可以修改这段代码实现ws的访问地址的修改
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
