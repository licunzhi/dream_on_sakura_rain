function hander(routers) {
  routers.test = {
    name: 'test',
    run: ()=> 'hello world.',
  };
}

module.exports = function() {
  this.bindHook('import_data', hander);
};
