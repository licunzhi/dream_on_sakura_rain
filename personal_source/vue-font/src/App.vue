<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
html, body, #app {
  margin: 0px;
  padding: 0px;
  font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
  width: 100%;
  height: 100%;
}

/* width */
::-webkit-scrollbar {
  width: 4px;
  height: 4px;
}

/* Track */
::-webkit-scrollbar-track {
  background: rgb(255, 255, 255);
  border-radius: 8px;
}

/* Handle */
::-webkit-scrollbar-thumb {
  background: rgb(201, 201, 202);
  border-radius: 8px;
}

/* Handle on hover */
::-webkit-scrollbar-thumb:hover {
  background: rgb(162, 162, 163);
}
</style>
