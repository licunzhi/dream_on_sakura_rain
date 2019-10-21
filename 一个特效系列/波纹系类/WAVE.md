# CSS实现波纹效果
---
> 写在前面：非专业前端，个人爱好，代码风格伤了你还望见谅
---
### 话不多说直接上效果
![展示波纹状态](https://github.com/licunzhi/dream_on_sakura_rain/blob/master/%E4%B8%80%E4%B8%AA%E7%89%B9%E6%95%88%E7%B3%BB%E5%88%97/%E6%B3%A2%E7%BA%B9%E7%B3%BB%E7%B1%BB/wave.gif?raw=true)

### HTML的骨架代码
初步静态代码展示
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>水波效果</title>
</head>
<body>
    <div class="wave_wrapper">
        <span class="wave_scale">

        </span>
        <span class="wave_scale delay">

        </span>
    </div>
</body>
</html>
```
但是这个时候在页面上看不到任何效果  
- 为div追加简单的标志性效果背景颜色
```css
.wave_wrapper {
    margin: 20% auto;
    width: 800px;
    height: 800px;
    background-color: rgb(248, 41, 171);
}
```
![展示](https://github.com/licunzhi/dream_on_sakura_rain/blob/master/%E4%B8%80%E4%B8%AA%E7%89%B9%E6%95%88%E7%B3%BB%E5%88%97/%E6%B3%A2%E7%BA%B9%E7%B3%BB%E7%B1%BB/%E5%88%9D%E5%A7%8B%E7%89%88%E6%9C%AC.jpg?raw=true)

### 美化现有的波纹中心
- 旋转中心div 圆角效果
```css
.wave_wrapper {
    margin: 20% auto;
    width: 800px;
    height: 800px;
    background-color: rgb(248, 41, 171);
    transform: matrix(0.707, 0.707, -0.707, 0.707, 0, 0);
    border-radius: 20%;
}
```
![展示](https://github.com/licunzhi/dream_on_sakura_rain/blob/master/%E4%B8%80%E4%B8%AA%E7%89%B9%E6%95%88%E7%B3%BB%E5%88%97/%E6%B3%A2%E7%BA%B9%E7%B3%BB%E7%B1%BB/%E6%97%8B%E8%BD%AC%E5%9C%86%E8%A7%92.jpg?raw=true)


### 中心点扩散块
```css
span {
            position: absolute;
            width: 50%;
            height: 50%;
            top: 25%;
            left: 25%;
            border: 0.2rem solid rgba(248, 41, 171, 0.28);
            border-radius: 50%;
            z-index: -1;
        }
```
![展示](https://github.com/licunzhi/dream_on_sakura_rain/blob/master/%E4%B8%80%E4%B8%AA%E7%89%B9%E6%95%88%E7%B3%BB%E5%88%97/%E6%B3%A2%E7%BA%B9%E7%B3%BB%E7%B1%BB/%E4%B8%AD%E5%BF%83%E6%89%A9%E6%95%A3%E7%82%B9.jpg?raw=true)


### 为中心点添加扩散效果
```css
span.wave_scale {
    animation: wave_scale 3s linear infinite;
    -webkit-animation: wave_scale 3s linear infinite;
}
@keyframes wave_scale {
    from {
        transform: translate3d(-41px, -41px, 0px) scale(1, 1);
        -webkit-transform: scale(1, 1);
        opacity: 1;
    }
    to {
        transform: translate3d(-41px, -41px, 0px) scale(10, 10);
        -webkit-transform: scale(5, 5);
        opacity: 0;
    }
}
@-webkit-keyframes wave_scale {
    from {
        transform: translate3d(-41px, -41px, 0px) scale(1, 1);
        -webkit-transform: scale(1, 1);
        opacity: 1;
    }
    to {
        transform: translate3d(-41px, -41px, 0px) scale(10, 10);
        -webkit-transform: scale(5, 5);
        opacity: 0;
    }
}
```
除了平面的范围的扩大性覆盖，还要进行透明度的修改，简答的一层展示效果如下图：
![展示](https://github.com/licunzhi/dream_on_sakura_rain/blob/master/%E4%B8%80%E4%B8%AA%E7%89%B9%E6%95%88%E7%B3%BB%E5%88%97/%E6%B3%A2%E7%BA%B9%E7%B3%BB%E7%B1%BB/%E4%B8%AD%E5%BF%83%E6%89%A9%E6%95%A3%E7%82%B9.jpg?raw=true)

### 效果修饰
- 为了看起来更加美观这边将第二部分的水波延迟加载一部分
```css
span.wave_scale.delay {
    animation: wave_scale 3s linear infinite 0.3s;
    -webkit-animation: wave_scale 3s linear infinite 0.3s;
}
```
最终效果：
![展示波纹状态](https://github.com/licunzhi/dream_on_sakura_rain/blob/master/%E4%B8%80%E4%B8%AA%E7%89%B9%E6%95%88%E7%B3%BB%E5%88%97/%E6%B3%A2%E7%BA%B9%E7%B3%BB%E7%B1%BB/wave.gif?raw=true)

---
源代码获取（WX代号WAVE_001）  
![微信公众号](https://github.com/licunzhi/dream_on_sakura_rain/blob/master/%E4%B8%80%E4%B8%AA%E7%89%B9%E6%95%88%E7%B3%BB%E5%88%97/%E6%B3%A2%E7%BA%B9%E7%B3%BB%E7%B1%BB/%E6%BA%90%E7%A0%81%E8%8E%B7%E5%8F%96.png?raw=true)
