### maven各种命令含义
- mvn -v   
    查看版本 
- mvn archetype:create   
    创建 Maven 项目 
- mvn compile   
    编译源代码 
- mvn test-compile   
    编译测试代码 
- mvn test   
    运行应用程序中的单元测试 
- mvn site   
    生成项目相关信息的网站 
- mvn package   
    依据项目生成 jar 文件 
- mvn install   
    在本地 Repository 中安装 jar 
- mvn -Dmaven.test.skip=true   
    忽略测试文档编译 
- mvn clean   
    清除目标目录中的生成结果 
- mvn clean compile   
    将.java类编译为.class文件 
- mvn clean package   
    进行打包 
- mvn clean test   
    执行单元测试 
- mvn clean deploy   
    部署到版本仓库 
- mvn clean install   
    使其他项目使用这个jar,会安装到maven本地仓库中 
- mvn archetype:generate   
    创建项目架构 
- mvn dependency:list   
    查看已解析依赖 
- mvn dependency:tree   
    看到依赖树 
- mvn dependency:analyze   
    查看依赖的工具 
- mvn help:system   
    从中央仓库下载文件至本地仓库 
- mvn help:active-profiles   
    查看当前激活的profiles 
- mvn help:all-profiles   
    查看所有profiles 
- mvn help:effective -pom   
    查看完整的pom信息
