import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import Movies from '@/components/movies/Movies'
import Cinema from '@/components/cinema/Cinema'
import Show from '@/components/show/Show'
import List from '@/components/list/List'
import HotSpot from '@/components/hotSpot/HotSpot'
import MovieTicket from '@/components/movies/MovieTicket'
import BuySet from '@/components/movies/BuySet'
import HallMovie from '@/components/movies/HallMovie'
import Order from '@/components/order/Order'

Vue.use(Router)

const router = new Router({
  mode: 'hash',
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home,
      children: [
        {
          path: '/',
          name: 'Movies',
          component: Movies
        },
        // {
        //   path: '/index',
        //   name: 'Index',
        //   component: Index
        // },
        {
          path: '/movies',
          name: 'Movies',
          component: Movies,
          children: [

          ]
        },
        {
          path: '/cinema',
          name: 'Cinema',
          component: Cinema
        },
        {
          path: '/order',
          name: 'Order',
          component: Order
        },
        {
          path: '/show',
          name: 'Show',
          component: Show
        },
        {
          path: '/list',
          name: 'List',
          component: List
        },
        {
          path: '/hotSpot',
          name: 'HotSpot',
          component: HotSpot
        },
        {
          path: '/mticket',
          name: 'MovieTicket',
          component: MovieTicket,
          children: [
            {
              path: '/mticket/cinema',
              name: 'Cinema',
              component: Cinema
            },
            {
              path: '/mticket/set',
              name: 'mBuySet',
              component: BuySet
            },
            {
              path: '/mticket/mhall',
              name: 'mHall',
              component: HallMovie
            }
          ]
        }
      ]
    }
  ]
})

export default router
