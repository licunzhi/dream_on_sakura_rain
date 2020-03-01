import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/index/HelloWorld'
import Main from '@/components/index/Main'
import Up2019M from '@/components/2019Up/Morning.vue'
import Up2019A from '@/components/2019Up/Afternoon.vue'

Vue.use(Router)

export default new Router({
  // mode: 'history',
  mode: 'hash', // 打包选项
  // base: '/sakura',
  routes: [
    {
      path: '/hello',
      name: 'HelloWorld',
      component: HelloWorld,
      meta: {
        requireAuth: true
      },
      children: []
    },
    {
      path: '/',
      name: 'Main',
      component: Main,
      meta: {
        requireAuth: true
      },
      children: [{
        path: '/Up2019M',
        name: 'Up2019M',
        component: Up2019M,
        meta: {
          requireAuth: true
        }
      },
      {
        path: '/Up2019A',
        name: 'Up2019A',
        component: Up2019A,
        meta: {
          requireAuth: true
        }
      }]
    }
  ]
})
