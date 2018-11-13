![docker](../images/docker_faco.png)

[skip to demo 演示](../002_docker安装操作demo/README.md)
## NO.1 基础介绍

### docker是什么
Docker 是一个开源的应用容器引擎，基于 Go 语言 并遵从Apache2.0协议开源。

Docker 可以让开发者打包他们的应用以及依赖包到一个轻量级、可移植的容器中，然后发布到任何流行的 Linux 机器上，也可以实现虚拟化。

容器是完全使用沙箱机制，相互之间不会有任何接口（类似 iPhone 的 app）,更重要的是容器性能开销极低。


### docker的应用场景
- web应用的自动化打包和部署
- 自动化集成部署发布
- 服务型环境中部署和调整数据库或其他后台应用
- 从头编译或者扩展现有的OpenShift或Cloud Foundry平台来搭建自己的PaaS环境。？？？？


### docker优点
- 简化程序（去除复杂的环境配置等）
    - docker可以将开发完成的程序以及相关依赖到一个容器中（可以是基础镜像创建出来的，也可以是自己创建的容器模板，避免多个环境中频繁配置运行环境）
    开始部署到程序运行只需要短短数秒时间
- 避面选择恐惧（打包你想要的模板镜像）
    -  打包需要执行的运行环境，每次打包的时候需要频繁配置项目需要运行的执行环境造成效率低下；
    因此可以使用各种需要的插件安装到指定的容器中，生成镜像进行部署
- 元计算时代（改变虚拟化的方式，更快，合理资源统筹）
    - 改变传统的虚拟机虚拟机话的方法，采用镜像运行指定容易的方式，速度快可配置模板化，是一件神奇的事情


### 如何安装一个docker环境
- 一个值得信赖的安装网站（centos window mac都有，社区版本安装） [菜鸟教程centos安装docker教程](http://www.runoob.com/docker/centos-docker-install.html)





## NO.2 渐进的使用过程

### hello world

docker run ubuntu:15.10 /bin/echo "Hello world"

> **docker:** Docker的二进制执行文件 （/usr/bin/docker）
   - ```jshelllanguage
        [root@host-172-20-9-27 bin]#  ll | grep docker
        -rwxr-xr-x  1 root root        735 Sep 29 03:07 docker
        -rwxr-xr-x  1 root root        717 Sep 29 03:07 docker-containerd
        -rwxr-xr-x  1 root root    7894056 Sep 29 03:46 docker-containerd-current
        -rwxr-xr-x  1 root root        797 Sep 29 03:07 docker-containerd-shim
        -rwxr-xr-x  1 root root    1920160 Sep 29 03:46 docker-containerd-shim-current
        -rwxr-xr-x  1 root root    7294400 Sep 29 03:46 docker-ctr-current
        -rwxr-xr-x  1 root root   13152680 Sep 29 03:46 docker-current
        -rwxr-xr-x  1 root root        740 Sep 29 03:07 dockerd
        -rwxr-xr-x  1 root root   34428976 Sep 29 03:46 dockerd-current
        lrwxrwxrwx  1 root root         32 Oct 30 10:55 docker-storage-setup -> /usr/bin/container-storage-setup
     ```  
     
     本质上是可执行的shell脚本
      ```jshelllanguage
         #!/bin/sh
         . /etc/sysconfig/docker
         [ -e "${DOCKERBINARY}" ] || DOCKERBINARY=/usr/bin/docker-current
         if [ ! -f /usr/bin/docker-current ]; then
             if [ ! -f /usr/bin/docker-latest ]; then
                 echo "You don't have either docker-client or \
         docker-client-latest installed. Please install either one and retry."
                 exit
             else
                 DOCKERBINARY=/usr/bin/docker-latest
             fi
         fi
         if [[ ${DOCKERBINARY} != "/usr/bin/docker-current" && ${DOCKERBINARY} != /usr/bin/docker-latest ]]; then
             echo "DOCKERBINARY has been set to an invalid value:" $DOCKERBINARY
             echo ""
             echo "Please set DOCKERBINARY to /usr/bin/docker-current or /usr/bin/docker-latest
         by editing /etc/sysconfig/docker"
         else
             exec ${DOCKERBINARY} "$@"
         fi
      ```

> **run:** 运行命令
> **ubuntu:15.10:** 运行的镜像的名称，首先是检验本地是否存在，本地不存在的时候会去DOcker Hub拉去镜像（Docker Hub可以自己创建私有的）
> **/bin/echo "Hello world":** 在容器中执行的命令

上面命令执行的流程：
    使用ubuntu镜像作为模板运行一个容器，并在容器中运行执行的命令
    
    
### 容器进行交互
> runoob@runoob:~$ docker run -i -t ubuntu:15.10 /bin/bash
> root@dc0050c79503:/#

- -t:在新容器内指定一个伪终端或终端。
- -i:允许你对容器内的标准输入 (STDIN) 进行交互。

### 启动容器（后台模式）
> runoob@runoob:~$ docker run -d ubuntu:15.10 /bin/sh -c "while true; do echo hello world; sleep 1; done"

- docker ps 查询运行中的容器
```jshelllanguage
[root@host-172-20-9-27 ~]# docker ps
CONTAINER ID        IMAGE               COMMAND             CREATED             STATUS              PORTS                    NAMES
72e4fde27f36        grafana/grafana     "/run.sh"           12 days ago         Up 12 days          0.0.0.0:3001->3000/tcp   sharp_bose

```
- docker logs names/container id 查看容器的日志信息

- docker stop names/cintainer id 停止容器




## NO.3 容器的使用
<pre>
- docker                                                    查看docker命令
- docker stats --help                                       命令的详细介绍
- docker run -d -P training/webapp python app.py -P         容器端口到主机端口的映射
- docker run -d -p 5000:5000 training/webapp python app.py  区别上面可以执指定映射端口
- docker port names/container id                            查看端口映射情况
- docker logs -f names/container id                         时时查看日志情况
- docker top names/container id                             查看容器应用资源使用情况
- docker inspect names/container id                         底层配置文件信息（json样式）
- docker start names/container id                           启动容器
- docker stop names/container id                            停止容器
- docker rm names/container id                              删除容器(移除容器之前需要停止容器)
</pre>


## NO.4 镜像的使用
<pre>
- docker images 查看本地镜像
- docker pull image_name:version                                            拉取新镜像
- docker search image_name                                                  查询镜像信息
- docker commit -m="has update" -a="runoob" e218edb10161 runoob/ubuntu:v2   提交镜像
                 m: message      a:author    容器的id     image_name:version
- docker build -t runoob/centos:6.7 .                                       构建镜像命令
        image_name:version        Dockerfile文件所在路径
- docker tag 860c279d2fec runoob/centos:dev                                 镜像标签
</pre>

## NO.5 容器连接
<pre>
- docker run -d -P training/webapp python app.py                        容器端口和主机端口映射
- docker run -d -p 5000:5000 training/webapp python app.py              主机端口和容器端口绑定
- docker run -d -p 127.0.0.1:5000:5000 training/webapp python app.py    绑定网络端口 默认绑定tcp端口 可以加/udp指定
- docker run -d -p 127.0.0.1:5000:5000/udp training/webapp python app.py
- docker port adoring_stonebraker 5000                                  快捷查看端口绑定情况
- docker run -d -P --name runoob training/webapp python app.py          创建容器并对其进行重命名
</pre>


## NO.6 熟悉基本命令之后的demo演示
[demo演示](../002_docker安装操作demo/README.md)
