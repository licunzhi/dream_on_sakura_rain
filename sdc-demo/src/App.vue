<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  font-size: .5rem !important;
  width: 100%;
  height: 100%;
}
/*页面展示的尺寸修饰*/
@media only screen and (min-width: 800px){
  html {
    font-size: 110%!important; /* 17.44px */
  }
}
@media only screen and (min-width: 1024px){
  html {
    font-size: 110%!important; /* 17.44px */
  }
}
@media only screen and (min-width: 1280px){
  html {
    font-size: 125%!important; /* 20px */
  }
}
@media only screen and (min-width: 1360px){
  html {
    font-size: 130%!important; /* 22px */
  }
}
@media only screen and (min-width: 1366px){
  html {
    font-size: 135%!important; /* 23px */
  }
}
@media only screen and (min-width: 1440px){
  html {
    font-size: 156%!important; /* 25px */
  }
}
@media only screen and (min-width: 1680px){
  html {
    font-size: 175%!important; /* 28px */
  }
}
@media only screen and (min-width: 1920px){
  html {
    font-size: 200%!important; /* 32px */
  }
}
/*element样式修正*/
html,body,.el-header,.el-main,.el-footer {
  padding: 0;
  margin: 0;
}
/*继承最大宽度，可以使用百分比样式修正*/
html, body{
  width: 100%;
  height: 100%;
}
.clearfix:after{content: ".";display: block;overflow: hidden;clear: both;height:0;line-height:0;}
.left {float: left;}
.right {float: right;}
/*文字断行*/
.word_break_line {
  word-break: break-all;
  word-wrap: break-word;
}
</style>
