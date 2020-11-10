import axios from 'axios'
import base64 from './base64'
// import qs from 'qs'

const loginAction = function (params) {
  axios.post('/sakura/Login/loginAction', params).then(response => {
    // console.log(response)
    return response
  }).catch(exception => {
    // console.log(exception)
    return exception
  })
}

const felixPost = function (params) {
  const aa = JSON.stringify(params)
  const value = base64.encode(base64.utf16to8(aa))
  var jsonParams = {
    'json': value
  }
  axios.post('/aus/felix', jsonParams).then(response => {
    console.log(response.data)
    return response
  }).catch(exception => {
    return exception
  })
}

export default {
  loginAction,
  felixPost
}
