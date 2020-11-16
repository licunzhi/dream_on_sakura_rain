/* store app login info 登录信息 */
export default {
  /* import by using namespace */
  namespaced: true,

  state: {
    cookie: '',
    userInfo: {}
  },

  getters: {
    getCookie (state) {
      return state.cookie
    },

    getUserInfo (state) {
      return state.userInfo
    }
  },

  mutations: {
    setCookie (state, payload) {
      /* notice avoid refresh page lose token */
      state.cookie = payload
    },

    setUserInfo (state, payload) {
      state.userInfo = payload
    }
  }
}
