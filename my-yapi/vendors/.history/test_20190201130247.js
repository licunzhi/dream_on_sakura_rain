exports.globalCode = ()=>{
  import axios from 'axios'
  const interfaceData = global.interfaceData;
}

exports.genInterfaceCode = ()=>{
  axios({
    method: interfaceData.method,
    url: interfaceData.url,
    
  })
}

function genInterfaceRequestCode(interfaceData){
  return ''
}

function getInterfaceAllRequestCode(interfaceList){
  let code = [];
  code.push(`
const interfaceList = ${JSON.stringify(interfaceList)}
interfaceList.forEach(interfaceData=>{
  allRequest[interfaceData.path] = function(options){
    return request(interfaceData, options)
  } 
})
  `)
}

let code  = []
code.push(`
const axios = require('axios');

function request(interfaceData, options = {}){
  options = Object.assign({method: interfaceData}, options)
  return axios(options)
}

const allRequest = {}

`)


/**
 * 定义需要的数据源
 */
exports.getInterfaceData = function getInterfaceData(){
  return [
    'path', 
    'title', 
    'method', 
    'query_path',
    'req_query', 
    'req_headers',
    'req_params',
    'req_body_type',
    'req_body_is_json_schema',
    'req_body_form',
    'req_body_other',
    'res_body_type',   // 返回数据type
    'res_body_is_json_schema',  //返回数据结构是否为json-schema
    'res_body'  //返回数据内容
  ]
}

