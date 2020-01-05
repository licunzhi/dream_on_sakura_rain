function hander(routers) {
  routers.test = {
    name: 'test',
    component: ()=> 'hello world.',
  };
}

module.exports = function() {
  this.bindHook('import_data', hander);
};
