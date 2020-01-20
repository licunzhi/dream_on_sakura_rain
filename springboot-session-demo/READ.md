# 介绍

## springboot集成使用redis作为session

### TestController
### 测试代码段：
```java
@GetMapping("/setUserInfo")
    public String setUserInfo(HttpSession session) {
        session.setAttribute("user", "sakrua");
        return "sakura";
    }

    @GetMapping("/getUserInfo")
    public String getUserInfo(HttpSession session) {
        Object user = session.getAttribute("user");
        if (user == null) {
            return "";
        }
        return user.toString();
    }
    
    @GetMapping("/logoutOut")
        public String logoutOut(HttpSession session) {
            session.invalidate();
            return "注销登录信息";
        }
```

## 各种数据类型的简单操作

### TestController
```java
@GetMapping("/fillRedis")
public String fileRedis() {
}
```
