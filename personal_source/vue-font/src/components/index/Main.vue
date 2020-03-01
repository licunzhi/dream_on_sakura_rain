<template>
    <div class="main-content">
        <div class="main-left">
          <div class="main-logo">
            PLUM-PARK
          </div>
          <div class="main-menu">
            <el-menu class="el-menu-vertical-demo" background-color="#545c64" text-color="#fff"
                     active-text-color="#ffd04b"
                     @open="handleOpen" @close="handleClose"
                     @select="handleSelect"
                     :router='true'>
              <el-submenu index="1">
                <template slot="title">
                  <i class="el-icon-document-remove"></i>
                  <span slot="title">2019年上半年</span>
                </template>
                <el-menu-item index="/Up2019M" route="/Up2019M">上午</el-menu-item>
                <el-menu-item index="1-2" route="/Up2019A">下午</el-menu-item>
                <el-menu-item index="1-3">上午解析</el-menu-item>
                <el-menu-item index="1-4">下午解析</el-menu-item>
              </el-submenu>
              <el-submenu index="2">
                <template slot="title">
                  <i class="el-icon-document-remove"></i>
                  <span slot="title">2019年下半年</span>
                </template>
                <el-menu-item index="2-1">上午</el-menu-item>
                <el-menu-item index="2-2">下午</el-menu-item>
                <el-menu-item index="2-3">上午解析</el-menu-item>
                <el-menu-item index="2-4">下午解析</el-menu-item>
              </el-submenu>
              <el-submenu index="3">
                <template slot="title">
                  <i class="el-icon-document-remove"></i>
                  <span slot="title">2018年上半年</span>
                </template>
                <el-menu-item index="3-1">上午</el-menu-item>
                <el-menu-item index="3-2">下午</el-menu-item>
                <el-menu-item index="3-3">上午解析</el-menu-item>
                <el-menu-item index="3-4">下午解析</el-menu-item>
              </el-submenu>
              <el-submenu index="4">
                <template slot="title">
                  <i class="el-icon-document-remove"></i>
                  <span slot="title">2018年下半年</span>
                </template>
                <el-menu-item index="4-1">上午</el-menu-item>
                <el-menu-item index="4-2">下午</el-menu-item>
                <el-menu-item index="4-3">上午解析</el-menu-item>
                <el-menu-item index="4-4">下午解析</el-menu-item>
              </el-submenu>
              <el-submenu index="5">
                <template slot="title">
                  <i class="el-icon-document-remove"></i>
                  <span slot="title">2017年上半年</span>
                </template>
                <el-menu-item index="5-1">上午</el-menu-item>
                <el-menu-item index="5-2">下午</el-menu-item>
                <el-menu-item index="5-3">上午解析</el-menu-item>
                <el-menu-item index="5-4">下午解析</el-menu-item>
              </el-submenu>
              <el-submenu index="6">
                <template slot="title">
                  <i class="el-icon-document-remove"></i>
                  <span slot="title">2017年下半年</span>
                </template>
                <el-menu-item index="6-1">上午</el-menu-item>
                <el-menu-item index="6-2">下午</el-menu-item>
                <el-menu-item index="6-3">上午解析</el-menu-item>
                <el-menu-item index="6-4">下午解析</el-menu-item>
              </el-submenu>
              <el-submenu index="7">
                <template slot="title">
                  <i class="el-icon-document-remove"></i>
                  <span slot="title">2016年上半年</span>
                </template>
                <el-menu-item index="7-1">上午</el-menu-item>
                <el-menu-item index="7-2">下午</el-menu-item>
                <el-menu-item index="7-3">上午解析</el-menu-item>
                <el-menu-item index="7-4">下午解析</el-menu-item>
              </el-submenu>
              <el-submenu index="8">
                <template slot="title">
                  <i class="el-icon-document-remove"></i>
                  <span slot="title">2016年下半年</span>
                </template>
                <el-menu-item index="8-1">上午</el-menu-item>
                <el-menu-item index="8-2">下午</el-menu-item>
                <el-menu-item index="8-3">上午解析</el-menu-item>
                <el-menu-item index="8-4">下午解析</el-menu-item>
              </el-submenu>
              </el-menu>
          </div>
        </div>
        <div class="main-right">
          <div class="content-header">
            <div class="user-info" style="display: flex; flex-direction: row-reverse">
              <!--icon of setting-->
              <el-dropdown style="padding: auto;" class="setting-location">
                <el-avatar :size="50" src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>
                <el-dropdown-menu slot="dropdown">
                  <el-dropdown-item>详情</el-dropdown-item>
                  <el-dropdown-item>修改密码</el-dropdown-item>
                  <el-divider></el-divider>
                  <el-dropdown-item>注销</el-dropdown-item>
                </el-dropdown-menu>
              </el-dropdown>
            </div>
            <!--<div class="main-content-bread">
              <el-breadcrumb separator="/">
                <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
                <el-breadcrumb-item>列表</el-breadcrumb-item>
              </el-breadcrumb>
            </div>-->
          </div>
          <div class="main-content-body">
            <router-view></router-view>
          </div>
        </div>
    </div>
</template>

<script>
export default {
  name: 'Main',
  data () {
    return {
      isCollapse: true
    }
  },
  methods: {
    handleSelect (key, keyPath) {
      console.log(key, keyPath)
    },
    handleOpen (key, keyPath) {
      console.log(key, keyPath)
    },
    handleClose (key, keyPath) {
      console.log(key, keyPath)
    }
  }
}
</script>

<style scoped>
.main-content {
  display: flex;
  flex-wrap: wrap;
  height: 100%;
  width: 100%;
  overflow: hidden;
}
.main-left {
  width: 360px;
  height: 100%;
  background-color: rgb(84, 92, 100);
}
.main-logo {
  height: 100px;
  background-color: #545c64;
  font-size: 50px;
  line-height: 2;
  text-align: center;
  color: #fff;
  border-bottom: 1px solid rgb(238, 238, 238);
}
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 100%;
  height: calc(100% - 100px);
}
.main-menu {
  height: calc(100% - 100px);
  overflow-y: auto;
  overflow-x: hidden;
}
.main-right {
  width: calc(100% - 360px);
  overflow: hidden;
}
.content-header {
  position: fixed;
  width: calc(100% - 360px);
  z-index: 100;
  background-color: white;
  box-shadow: 0 1px 3px rgba(26,26,26,.1);
}
.user-info {
  width: 100%;
  height: 80px;
  background-color: #f6f6f6 ;
}
.main-content-bread {
  top: 80px;
  margin: 15px;
}
.main-content-body {
  position: absolute;
  top: 125px;
  width: calc(100% - 360px);
  height: calc(100% - 125px);
  overflow: auto;
}
.setting-location {
  font-size: 30px;
  margin-top: 15px;
  margin-right: 25px;
}
.el-divider {
  margin: 0px;
}
</style>
