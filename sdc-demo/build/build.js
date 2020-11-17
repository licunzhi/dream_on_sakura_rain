'use strict'
require('./check-versions')()

process.env.NODE_ENV = 'production'

/*
* ora： 优雅的终端旋转器
* rimraf: 节点的UNIX命令rm -rf
* chalk: 是一个颜色的插件
*
* */
const ora = require('ora')
const rm = require('rimraf')
const path = require('path')
const chalk = require('chalk')
const webpack = require('webpack')
const config = require('../config')
const webpackConfig = require('./webpack.prod.conf')

/* 开始构建控制台刷新展示 */
const spinner = ora('building for production...')
spinner.start()

/*
* rimraf说明： rimraf('some-thing', myCustomFS, callback)
* 参数说明：
* config.build.assetsRoot: dist 备注：名称也可以进行定义
* config.build.assetsSubDirectory: static
*
* 构建过程需要删除之前构建的文件，不包括index.html
*     主要是构建过程可能会打包出新的整合结果文件，如果不对static下的文件进行删除可能会导致文件堆积
*     而index.html为入口文件，每次都会被覆盖
*
* 执行构建核心方法：webpack()
*
* function webpack(options, callback)
*     validateSchema(webpackOptionsSchema, options) // schema格式校验 定义属性格式位置参考：/schemas/webpackOptionsSchema.json
*     针对options的类型： Array | Object
*     new WebpackOptionsDefaulter().process(options); // WebpackOptionsDefaulter构造器中的参数进行对比，不存在的使用默认值
*
* */
console.log('构建需要移除的文件路径：', path.join(config.build.assetsRoot, config.build.assetsSubDirectory))
rm(path.join(config.build.assetsRoot, config.build.assetsSubDirectory), err => {
  if (err) throw err
  webpack(webpackConfig, (err, stats) => {
    spinner.stop()
    if (err) throw err
    process.stdout.write(stats.toString({
      colors: true,
      modules: false,
      children: false, // If you are using ts-loader, setting this to true will make TypeScript errors show up during build.
      chunks: false,
      chunkModules: false
    }) + '\n\n')

    if (stats.hasErrors()) {
      console.log(chalk.red('  Build failed with errors.\n'))
      process.exit(1)
    }

    console.log(chalk.cyan('  Build complete.\n'))
    console.log(chalk.yellow(
      '  Tip: built files are meant to be served over an HTTP server.\n' +
      '  Opening index.html over file:// won\'t work.\n'
    ))
  })
})
