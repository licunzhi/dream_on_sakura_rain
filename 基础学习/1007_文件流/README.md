## IO学习

### 分类
- 流向 输入流和输出流
- 操作单元 字节流和字符流
- 操作角色 节点流和处理流

### 总类
IO涉及类很多 总的分为两大部分
- `InputStream/Reader` 输入流 字节流/字符流
- `OutputStream/Writer` 输出流 字节流/字符流

### 字符字节的之间区别
- 鉴于编码方式的不同 可以省去查询编码表操作的方式  直接读取字符 一般使用在字符串的操作上  图片文件还是使用的字节
- 字节`bit` 字符`16bit`
- 字节流使用的编码为Unicode 一个字符占用两个字节

### 输入流 输出流之间区别
- 输入流进行读取操作
- 输出流进行写入操作

### 输入输出 独立于设备
- 输入流不用关系数据来源于什么设备
- 输出流不用关系数据的目的是何种设备

### 特性
- 先进先出 线性并且顺序性 为了数据的一致
- 和RandomAccessFile区别  不能从任意位置存取
- 要么读操作   要么写操作  不可同时兼得


## 不得不说的NIO

### 核心组成
- `Channels` buffer可以到channel channel可以到buffer
- `Buffers` 缓冲区，缓存文件数据
- `Selectors` 允许单线程处理多个channel 前提是channel像Selector注册

### IO NIO
- IO面向流    NIO面向缓冲
- IO阻塞      NIO非阻塞

### 面向流和面向缓冲的区别
- 面向流意味着什么，以为这每次从刘中读一个或者多个字符，直到读取所有的字节，他们没有缓存的地方。  
因此一个流操作就要持续完整下去，因为没有任何地方缓存他的数据。除此之外，他不能前后移动流中的数据，因此灵活性这种东西他是不能驾驭的
- 面向缓存意味着什么，读取数据到一个缓冲区，需要时可以进行前后移动，灵活性不言而喻。在数据较多的时候，需要注意数据的覆盖性问题

### 先决条件
- NIO操作的先决条件是所有的数据必须先读入缓冲区在处理


### 比如这呆萌
- IO入缓存然后操作
```code
BufferedReader reader = new BufferedReader(new InputStreamReader(input));
String nameLine   = reader.readLine();
String ageLine    = reader.readLine();
String emailLine  = reader.readLine();
String phoneLine  = reader.readLine();
```
- NIO  
主要的问题就是不知道什么时候缓存中的数据是已经准备完成的或者是已经达到了自己操作的时间  
如果每次单独使用特殊的判断方式会导致代码变得更加复杂和冗余


