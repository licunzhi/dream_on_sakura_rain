# dream_on_sakura_rain
项目下有更不同的demo，运行执行指定的项目模块即可

### 模块列表
- [冒泡算法](https://github.com/licunzhi/dream_on_sakura_rain/tree/master/bubble_sorting_demo)
- [设计模式](https://github.com/licunzhi/dream_on_sakura_rain/tree/master/java_design_model_demo)
- [Java8stream操作](https://github.com/licunzhi/dream_on_sakura_rain/tree/master/java_stream_demo)
- [LoadingCache](https://github.com/licunzhi/dream_on_sakura_rain/tree/master/loadingcache_demo)
- [mybatis_pagehelper_demo](https://github.com/licunzhi/dream_on_sakura_rain/tree/master/mybatis_pagehelper_demo)
- [springboot_rabbit_demo](https://github.com/licunzhi/dream_on_sakura_rain/tree/master/springboot_rabbit_demo)
- [web_socket_demo](https://github.com/licunzhi/dream_on_sakura_rain/tree/master/web_socket_demo)
- [quartz_demo](https://github.com/licunzhi/dream_on_sakura_rain/tree/master/quartz_demo)

> #### loadingcache_demo : 在spiringboot中使用loadingcache_demo


- [ ] 修改过期策略以及最大容量代码段

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

- [ ] 运行项目可以直接在test模块中运行项目
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

实现简单的存储和取值，具体效果可运行测试方法

项目配置信息（可以修改成自己的环境信息）
```properties
# Redis数据库索引（默认为0）
spring.redis.database=0
# Redis服务器地址
spring.redis.host=172.16.15.112
# Redis服务器连接端口
spring.redis.port=6379
# Redis服务器连接密码（默认为空）
spring.redis.password=
# 连接池最大连接数（使用负值表示没有限制）
spring.redis.jedis.pool.max-idle=8
# 连接池最大阻塞等待时间（使用负值表示没有限制）
spring.redis.jedis.max-wait=-1
# 连接池中的最大空闲连接
spring.redis.jedis.max-idle=8
# 连接池中的最小空闲连接
spring.redis.jedis.min-idle=0
# 连接超时时间（毫秒）
spring.redis.timeout=0
```

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



> #### mybatis_pagehelper_demo:简单的pageHelper使用实现(适用于多数据源情况)

#####  项目运行浏览器访问地址
> [http://localhost:8080/test/licunzhi](http://127.0.0.1:8080/test/licunzhi)

##### 项目运行环境：

[1] 创建数据库（如果使用数据库或者相关性信息不是本地数据测试进行第二部操作）
```sql
/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.1.62-community : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `test`;

/*Table structure for table `USER` */

DROP TABLE IF EXISTS `USER`;

CREATE TABLE `USER` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `USER` */

insert  into `USER`(`id`,`name`,`password`) values ('2','111','123'),('3','222','123'),('4','333','123'),('5','444','456'),('6','55','466');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

```
[2] 修改数据库链接配置(相关信息修改成为测试)
```java
spring.datasource.local.url=jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf-8
spring.datasource.local.username=root
spring.datasource.local.password=123
spring.datasource.local.driver-class-name=com.mysql.jdbc.Driver
```


项目运行效果展示
![项目运行效果展示](https://github.com/licunzhi/dream_on_sakura_rain/blob/master/mybatis_pagehelper_demo/images/result.png)

