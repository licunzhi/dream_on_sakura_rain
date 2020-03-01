import axios from 'axios'
import router from '../router'

const TIMEOUT = 10000
const TOKEN_NAME = 'T-Authorization'

// 设置baseURL
// axios.defaults.baseURL = '/api'
// 设置默认请求头
axios.defaults.headers = {
  'X-Requested-With': 'XMLHttpRequest'
}

// 设置请求过期时间
axios.defaults.timeout = TIMEOUT

// 每次去sessionStorage中获取token作为请求一部分
axios.interceptors.request.use(config => {
  console.log(config)
  config.headers = {
    'Content-Type': 'application/json'
  }
  // 配置token
  let token = sessionStorage.getItem(TOKEN_NAME)
  if (token) {
    config.headers[TOKEN_NAME] = token
  }
  return config
}, error => {
  return Promise.reject(error)
})

// 响应拦截器即异常处理
axios.interceptors.response.use(response => {
  // 根据后端返回的状态码定向操作
  switch (response.status) {
    default:
      break
  }
  return response
}, error => {
  // 针对未授权跳转到登录页面
  if (error && error.response.status === 403) {
    router.replace({
      path: '/'
      // query: {redirect: router.currentRoute.fullPath} // 无需使用再次重定向
    })
  }
  // Message.error(error.message)
  return Promise.resolve(error.response)
})

export default {
  // get请求
  get (url, param) {
    return new Promise((resolve, reject) => {
      axios.get(url, {params: param})
        .then(res => {
          resolve(res)
        }, err => {
          reject(err)
        })
    })
  },
  // post请求
  post (url, param) {
    return new Promise((resolve, reject) => {
      axios.post(
        url,
        param
      ).then(res => {
        resolve(res)
      }, err => {
        reject(err)
      })
    })
  },
  // 如何上传文件
  postFile (url, param, headers) {
    return new Promise((resolve, reject) => {
      axios.post(
        url,
        param,
        {
          headers: {
            'Content-Type': 'application/json'
          }
        }
      ).then(res => {
        resolve(res)
      }, err => {
        reject(err)
      })
    })
  },
  // put请求
  put (url, param) {
    return new Promise((resolve, reject) => {
      axios.put(url, param)
        .then(response => {
          resolve(response)
        }, err => {
          reject(err)
        })
    })
  },
  // delete
  delete (url, param) {
    return new Promise((resolve, reject) => {
      axios.delete(url, param)
        .then(response => {
          resolve(response)
        }, err => {
          reject(err)
        })
    })
  }
}
