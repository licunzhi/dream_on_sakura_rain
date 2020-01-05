const shell = require('shelljs');
const packageJson = require('./package.json')

const version=packageJson.json;

console.log('exec: git pull origin master')
shell.exec('git pull origin master')
let a = shell.exec(`git tag |grep ${version} |wc -l`);
if(a && parseInt(a) > 0){
shell.exec('git tag -d ' + version);
shell.exec('git push origin :'+version)
}
shell.exec('git tag ' + version);
shell.exec('git push origin ' + version);