/* 分布消息总线请求方法 */
import base64 from './base64'
import axios from 'axios'
import qs from 'qs'

const felixUrl = 'http://127.0.0.1:10001/aus/felix'

const headers = {'Content-Type': 'application/x-www-form-urlencoded'}

function decodeData (response) {
  return JSON.parse(base64.utf8to16(base64.decode(response.data)))
}

const DistrMsgService = {
  listMsgBus (params) {
    const data = base64.encode(base64.utf16to8(JSON.stringify(params)))
    return axios.post(felixUrl, qs.stringify({'json': data}), {headers: headers}).then(decodeData).catch(exception => {
      return exception
    })
  },

  commonPost (params) {
    const data = base64.encode(base64.utf16to8(JSON.stringify(params)))
    return axios.post(felixUrl, qs.stringify({'json': data}), {headers: headers}).then(decodeData).catch(exception => {
      return exception
    })
  }
}

export default DistrMsgService
