## Docker命令

### Docker run
命令模板

> docker run <font color="#dd0000">[options]</font> image_name <font color="#dd0000">[command] [args]</font>

options:（按照使用频度进行重新排序解释）
   - -d 后台运行的方式启动容器
   - -i 交互模式运行容器，通常和-t一起使用
   - -t 为容器重新分配一个伪输入终端（tty）
   - -p 端口映射配置 -p 3306:3306 or -p 127.0.0.1:3306:6603
   - --name 设置容器名称 --name="nginx"
   - -dns 设置容器使用的DNS服务器，默认和宿主一致 -dns 14.14.14.14.14
   - -h 指定容器的hostname -h "demo_test"
   - -e username='name_li' 设置环境变量
   - --env-file=[] 指定文件中读取环境变量
   - --cpuset="0,1,2" 绑定容器到指定的CPU运行
   -m 设置容器使用的最大内存范围
   - --net="birdge" 指定容器的网络链接类型 bridge host none container 四种可以设置的范围
   - --link=[] 添加链接到另一个容器中
   - --expose=[] 开发指定的端口
   - -a stdin: 指定标准输入输出内容类型，可选 STDIN/STDOUT/STDERR 三项；

### docker start/stop/restart
> docker start <font color="#dd0000">[options]</font> container <font color="#dd0000">[contain....]</font>

docker start docker-demo docker_test docker_sakura


### docker pause/pause
> docker pause/unpause <font color="#dd0000">[options]</font> container <font color="#dd0000">[container...]</font>

docker pause/unpause docker-demo docker-test


### docker rm
> docker rm <font color="#dd0000">[options]</font> container <font color="#dd0000">[container...]</font>

- options 
    - -f 强制删除容器
    - -l 移除容器之间的网路链接，不是容器本身
    - -v 删除与容器关联的卷
    
