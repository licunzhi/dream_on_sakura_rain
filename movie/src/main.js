// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import Vuex from 'vuex'
import App from './App'
import router from './router'
// 引入UI组件
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
// 引入axios
import axios from 'axios'
import VueAxios from 'vue-axios'
import qs from 'qs'

Vue.config.productionTip = false

/* 使用vuex */
Vue.use(Vuex)

Vue.use(VueAxios, axios)
Vue.prototype.qs = qs

const store = new Vuex.Store({
  state: {
    user: localStorage.getItem('user') ? JSON.parse(localStorage.getItem('user')) : {}
  },
  mutations: {
    // 用户信息初始化
    initUserInformation (state, user) {
      localStorage.setItem('user', JSON.stringify(user))
      console.error('store init user info method...')
      state.user = user
    },
    // 用户信息清除
    removeUserInformation (state) {
      localStorage.removeItem('user')
      state.user = {}
    }
  },
  actions: {
    // 类似 mutations 复杂的操作 支持异步操作
    initUserInformation (state, user) {
      state.commit('increment', user)
    }
  },
  getters: {
    getUser: (state) => {
      return state.user
    }
  },
  // 多个模块分割
  modules: {
  }
})

Vue.use(ElementUI)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  render: (h) => h(App),
  store
})
