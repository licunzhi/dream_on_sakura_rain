import Vue from 'vue'
import App from './App'
// 引入UI组件
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
// 引入axios
import axios from 'axios'
import VueAxios from 'vue-axios'
import qs from 'qs'

/* custom exposure information */
import router from '@/router'
import store from '@/store'

Vue.config.productionTip = false

Vue.prototype.qs = qs

Vue.use(VueAxios, axios)

Vue.use(ElementUI)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  store,
  router,
  render: (h) => h(App)
})
