import Vue from 'vue'
import Vuex from 'vuex'
import createPersistedState from 'vuex-persistedstate'

import { default as SdcUserStore } from '@/store/SdcUserStore'

Vue.use(Vuex)

/* modules 模块展示 */
const store = new Vuex.Store({
  modules: {
    SdcUserStore
  },
  plugins: [createPersistedState(
    {
      storage: window.localStorage,
      reducer (val) {
        return {
          SdcUserStore: val.SdcUserStore
        }
      }
    }
  )]
})

export default store
