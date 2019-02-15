## Dockerfile命令参数解释

### CMD ENTRYPOINT
- CMD 是容器默认启动的时候执行的命令，是在没有指定其他运行的命令情况下生效
	- CMD执行是在没有其他命令的情况下默认执行的，但是如果有其他的命令就会出现覆盖的情况
	- 其他的用法还有
		- CMD ["executable", "param1", "param2"]
		- CMD command param1 param2  
			分别是exec模式和shell模式
		- CMD ["param1", "param2"]  
			提供运行时参数
	- 多个CMD的时候最后一个生效，前面的不起作用
	
- ENTRYPOINT 是定义容器真正启动之后才会执行的
	- 两种使用方式
		- ENTRYPOINT ["executable", "param1", "param2"]
		- ENTRYPOINT command param1 param2
		
	#### shell模式和exec模式之间
	- cdm和entrypoint都支持shell和exec模式
	- shell模式,docker会以/bin/sh -c "task command"的方式执行任务命令
	- exec模式还是shell模式的基本使用方法都是一样的
	- CMD和Entrypoint至少存在一个默认的否则在启动容器的时候会报错
	
	
	#### CMD和Entrypoint在一起使用的情况
	- ENTRYPOINT使用了shell模式，CDM不会起作用，也不会作为尾随的参数
	- 如果 ENTRYPOINT使用了exec模式，CMD指定的内容被追加为 ENTRYPOINT指定命令的参数
	- 如果 ENTRYPOINT使用了exec模式，CMD也应该使用exec模式
	
	
### ADD COPY
- 共同点：
	- 都能够将主机上的资源拷贝到容器中

- 不同点：
	- ADD可以将远程主机资源拷贝到容器中， COPY不支持
	
- 缺陷：
	- ADD不支持远程验证，因此可以在其中使用RUN命令代替
	- ADD命令回事Docker Cache失效，因此ADD命令应该放在Dockerfile文件后面