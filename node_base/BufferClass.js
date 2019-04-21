var sakura = Buffer.from('sakura', 'ascii');
console.log(sakura.toString('utf-8'));

// 写入缓冲区
buf = Buffer.alloc(256);
len = buf.write("www.runoob.com");

console.log("写入字节数 : "+  len);

// 缓冲区写出
buf.toString([encoding[, start[, end]]])
