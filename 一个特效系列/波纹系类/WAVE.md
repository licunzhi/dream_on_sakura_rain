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
