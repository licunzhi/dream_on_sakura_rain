import axios from 'axios'
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

export default {
  loginAction
}
