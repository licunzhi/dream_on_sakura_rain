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

const fs = require('fs')
const path = require('path')
const requestCode = fs.readFileSync(path.resolve(__dirname, './getRequestCode.js'), 'utf8');

module.exports = function(interfaceList){
  return `
const axios = require('axios');

${requestCode}

const allRequest = {}

const interfaceList = ${JSON.stringify(interfaceList)}
interfaceList.forEach(interfaceData=>{
  allRequest[interfaceData.path] = function(options){
    return request(interfaceData, options)
  } 
})
`


/**
 * 定义需要的数据源
 */



}