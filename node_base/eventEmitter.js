// 引入 events 模块
var events = require('events');
// 创建 eventEmitter 对象
var eventEmitter = new events.EventEmitter();

// 创建事件处理程序
var connectHandler = function connected() {
    console.log('连接成功。');

    // 触发 data_received 事件
    eventEmitter.emit('data_received');
};
// 绑定 connection 事件处理程序
eventEmitter.on('connection', connectHandler);

// 使用匿名函数绑定 data_received 事件
eventEmitter.on('data_received', function(){
    console.log('数据接收成功。');
});


// 触发 connection 事件 
eventEmitter.emit('connection');

console.log("程序执行完毕。");

// 注册一个监听事件
eventEmitter.on('time_delay_event', function () {
    console.log('time_delay_event执行', new Date().getTime());
    
});

// 执行一次
setTimeout(function () {
    eventEmitter.emit('time_delay_event');
}, 2000);

// 在尝试一次
setTimeout(function () {
    eventEmitter.emit('time_delay_event');
}, 4000);

// 注册参数事件
eventEmitter.on('params_event', function (arg1, arg2) {
    console.log('params_event执行', arg1, arg2, new Date().getTime());

});

// 执行注册的事件
setTimeout(function () {
    eventEmitter.emit('params_event', 'sakura', 'rain');
}, 4000);
