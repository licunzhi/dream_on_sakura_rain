module.exports = {
  'import-postman': {
    module: require ('exts/yapi-plugin-import-postman/client.js'),
    options: null,
  },
  'import-har': {
    module: require ('exts/yapi-plugin-import-har/client.js'),
    options: null,
  },
  'advanced-mock': {
    module: require ('exts/yapi-plugin-advanced-mock/client.js'),
    options: null,
  },
  'import-swagger': {
    module: require ('exts/yapi-plugin-import-swagger/client.js'),
    options: null,
  },
  statistics: {
    module: require ('exts/yapi-plugin-statistics/client.js'),
    options: null,
  },
  'export-data': {
    module: require ('exts/yapi-plugin-export-data/client.js'),
    options: null,
  },
  'export-swagger2-data': {
    module: require ('exts/yapi-plugin-export-swagger2-data/client.js'),
    options: null,
  },
  'import-yapi-json': {
    module: require ('exts/yapi-plugin-import-yapi-json/client.js'),
    options: null,
  },
  wiki: {module: require ('exts/yapi-plugin-wiki/client.js'), options: null},
  test: {module: require ('exts/yapi-plugin-test/client.js'), options: null},
};
