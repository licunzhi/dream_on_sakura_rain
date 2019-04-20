var fs = require('fs');

// 阻塞读取文件操作实现
var fileContent = fs.readFileSync("sakura.txt");
console.log(fileContent.toString());

// 异步操作的代码实现
fs.readFile('sakura.txt', function (error, data) {
    if(error) {
        return console.error(error);
    }
    console.log(data.toString());
});