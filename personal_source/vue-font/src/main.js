// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

// 引入UI组件
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import './common/css.css'

// Vuex
import Vuex from 'vuex'

// 封装axios
import ajax from './http/Ajax'

import echarts from 'echarts'

import qs from 'qs'

import lodash from 'lodash'

import BaiduMap from 'vue-baidu-map'

require('./mock.js')

// 全局echarts

// 产生生产提示
Vue.config.productionTip = false

// 配置全局调用属性
Vue.prototype.http = ajax
Vue.prototype.ajax = ajax
Vue.prototype.echarts = echarts
Vue.prototype.qs = qs
Vue.prototype.lodash = lodash

// 使用element-ui 组件
Vue.use(ElementUI)

Vue.use(Vuex)

Vue.use(BaiduMap, {
  ak: 'hh5Nz1eVfLhHe8lhrZGpdiIx'
})

const store = new Vuex.Store({
  state: {
    information: ''
  },
  mutations: {
    // init information
    initUserInformation (state) {
      console.info('Vuex init information...')
    }
  },
  actions: {
    // 类似 mutations 复杂的操作 支持异步操作
    initUserInformation (state) {
      console.info('Vuex init information...')
    }
  },
  getters: {
    getUser: state => {
      return state.information
    }
  },
  // 多个模块分割
  modules: {
  }
})

// router guard
/**
 * 路由守卫
 * 路由跳转的先决条件判断，定向登录跳转或者是其他操作
 */
// router.beforeEach((to, from, next) => {
//   if (to.name == null) { // 待跳转的路由不在范围内
//     next({
//       path: '/'
//     })
//   } else if (to.meta.requireAuth) {
//     let token = sessionStorage.getItem('T-Authorization')
//     if (token) {
//       next()
//     } else {
//       next({
//         path: '/'
//         // query: {redirect: to.fullPath} // 登录成功之后要不要跳转到指定的路由(导航栏引起不适)
//       })
//     }
//   } else {
//     // 不需要鉴权地址放行
//     next()
//   }
// })

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
