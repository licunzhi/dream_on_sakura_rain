function request(interfaceData, options = {}){
  options = Object.assign({method: interfaceData.method}, options)
  return axios(options)
}