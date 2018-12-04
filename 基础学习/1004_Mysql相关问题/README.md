##MYSQL

### 键  

- 主键   唯一标识 只存在一个 不能缺失 不能为空
- 超键 表示元组的数据集 可以是一个 也可以是多个组成  超键包含候选键和主键
- 候选键 没有冗余的超键
- 外键 一个表中存在的另一个表中的主键  
___  

### 事务四个特性
ACID atomicity correspondence  isolation durability 原则性 一致性 隔离性 持久性  
Atomicity 每个操作都是最小单位 有始有终 无始无终 否则回滚到初始的状态  
Correspondence 事务开始和事务结束之后  数据库完整性约束没有被破坏
Isolation 串行化或者是序列化同一时间同一个操作行为
Durability 事务完成之后 数据真实有效存储在数据库中
___  
  

### 视图
- 视图是什么
    - 虚拟的表 只包含使用时需要查询检索的数据 可以简化查询语句 隐藏具体方式
- 主要用于数据的检索  大部分不支持更新操作

___  
  
### 相关Sql语句
- DATABASE
    - CREATE DATABASE 数据库名称; 创建数据库
    ```code
        create database sakura;
    ```
    - USER 数据库名称; 使用数据库
    ```code
        user sakura;
    ```
    - mysqladmin -u root -p create 数据库; 创建最高权限可见的数据
    - DROP DATABASE 数据库; 删除数据库
    - mysqladmin -u root -p drop 数据库; 使用最高权限进行删除操作
    - create table sakura
        ```mysql
              create table if not exists `sakura` (
                `sakura_id` int UNSIGNED AUTO_INCREMENT,
                `sakura_name` varbinary(128) not null, 
                primary key(`sakura_id`)
              ) ENGINE=InnoDb DEFAULT CHARSET=utf8
        ```
    - DROP TABLE sakura 删除表
    - show databases; 展示所有数据库
    - show tables; 展示所有的数据表
    - desc table_name; 描述表结构
    - select语句
    ```code
        SELECT column_name,column_name
        FROM table_name
        [WHERE Clause]
        [LIMIT N][ OFFSET M]
        
        select `sakura_id`, `sakura_name` 
        from sakura
        where `sakura_id` = 123 and `sakura_name` = 'sakura_rain'
        limit 3 // 查询结果个数限制
        offset 3 // 结果截取开始位置
    ```
    - update语句
    ```code
        UPDATE table_name SET field1=new-value1, field2=new-value2
        [WHERE Clause]
    
        update salura set sakura_name='sakura_park'
        where sakura_id = 1
    ```
    - delete
    ```code
        DELETE FROM TABLE_NAME 
        [WHERE CLAUSE]
        
        delete from sakura where sakura_id=1
    ```
    - LIKE
    ```code
        select * from sakura 
        where sakura_name like condition
        
        condition :
        '%a'     //以a结尾的数据
        'a%'     //以a开头的数据
        '%a%'    //含有a的数据
        '_a_'    //三位且中间字母是a的
        '_a'     //两位且结尾字母是a的
        'a_'     //两位且开头字母是a的
        
        % can replace one more 
        _ just replace one
    ```
    - UNION
    ```code
        SELECT expression1, expression2, ... expression_n
        FROM tables
        [WHERE conditions]
        UNION [ALL | DISTINCT]
        SELECT expression1, expression2, ... expression_n
        FROM tables
        [WHERE conditions];
        
        
        all   
                 select * from sakura union all
                  select * from plum;
                 +-----------+----------------------+
                 | sakura_id | sakura_name          |
                 +-----------+----------------------+
                 |         1 | sakura               |
                 |         2 | sakura_demo          |
                 |         3 | sakura_park          |
                 |         4 | sakura_bow           |
                 |         5 | dream_on_sakura_rain |
                 |         1 | plum                 |
                 |         2 | plum_park            |
                 |         3 | plum_rain            |
                 |         4 | plum_bow             |
                 |         5 | dream_on_sakura_rain |
                 +-----------+----------------------+
        dintinct
        
                select * from sakura union distinct select * from plum;
                +-----------+----------------------+
                | sakura_id | sakura_name          |
                +-----------+----------------------+
                |         1 | sakura               |
                |         2 | sakura_demo          |
                |         3 | sakura_park          |
                |         4 | sakura_bow           |
                |         5 | dream_on_sakura_rain |
                |         1 | plum                 |
                |         2 | plum_park            |
                |         3 | plum_rain            |
                |         4 | plum_bow             |
                +-----------+----------------------+
    ```
    
