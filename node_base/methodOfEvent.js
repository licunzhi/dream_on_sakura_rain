var events = require('events');
var eventMitter = new events.EventEmitter();

var listener1 = function listener1() {
    console.log('listener1 execute...')
};

var listener2 = function listener2() {
    console.log('listener2 execute...')
};

//绑定监听事件
eventMitter.addListener('connection', listener1);
eventMitter.on('connection', listener2);

var listenerCounts = eventMitter.listenerCount('connection');
console.log('connection的监听器的个数： ', listenerCounts);

eventMitter.emit('connection');

// 移除监听事件
eventMitter.removeListener('connection', listener1);
console.log('移除监听事件');
eventMitter.emit('connection');

eventMitter.removeAllListeners('connection');
var listenerCounts = eventMitter.listenerCount('connection');
console.log('connection的监听器的个数： ', listenerCounts);

// 主动抛出异常，原声错误提示，不要覆盖
eventMitter.emit('error');
