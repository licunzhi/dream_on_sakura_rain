## 总结

### 复制原理
  
  
  
  
  
### drop truncate delete
- drop > truncate delete
- truncate 更快 delete 删除操作需要记录每条日志信息
  
  
### 索引
- 索引类型
    - B 二叉树
    - B+ 变种二叉树  
    
- 代价
    - 增加了存储空间
    - 插入删除维护索引需要耗费一定时间  
    
- 优势
    - 唯一索引可以保证数据的唯一性
    - 大大增加数据检索的速度
    - 加速表之间的连接  数据的参考性完整方面的有意义
    - 分组查询排序数据检索  减少查询中的排序时间和分组时间
    - 优化隐藏器  
    
- 劣势
    - 数据库非查询操作会耗费时间 索引的维护浪费时间  并且会随着数据的的增多时间递增
    - 索引本身的存储需要占用内存空间
    - 删除修改操作增加了维护索引的代价 减低了维护速度  

- 注意
    - 使用很少或者是作为参考的列不应该创建索引
    - 很少的数值的列也不应该增加索引
    - 存储很大的数据的数据类型的列不追加索引
    - 修改性能需求远远大于查询操作的时候
- 失效
    - != <> 操作
    - null值判断
    （优化建议  使用in 而不是 exists    使用where 而不是having）
- 优化
    - 消除数据冗余 满足数据库范式设计
    - 数据拆分，分区存储数据   比如很多日志设计的创库存储
    - 拆分分为水平拆分和垂直拆分 用户表的男女拆分    订单表的完成和为完成的拆分
    
    
    
### Mysql 优化技巧
- 避免使用!= <>操作, 放弃使用索引从而进行全局扫描筛选的方式是十分费时的
- 根据实际情况可以在where 或者是 order by进行的字段上进行创建索引，合适的索引数量（需要考虑到该表的类型以及用途创建合适的索引）
- 避免对null的判断 select * from sakura where name is null 也会造成放弃索引  采用全筛选的方式 可以设置null默认值0 精确查询适当可以提高速度
- 减少在where中使用or， select * from sakura where name = 'dream_on_demo' or id = 'sakura001' 修改为 select * from sakura where name='xx' union all select * from sakura where id = 'xxx001'
- 模糊查询也会导致全局扫描的问题 select * from sakura where name like '%sakura%' 修改为 select * from sakura where name like 'sakura%'
- in and not in 替换为 between and
- 避免where语句中表达式的使用 select * from salary where money * 2 > 10000 修改为 select * from salary where money > 10000/2
- 避免在查询语句中使用函数对字段进行操作 subString datediff
- 聚合索引进行查询时字段要保持字段的顺序性一致 否则也会导致索引失效  其中有一个最左原则的问题
- 可以使用exists代替in的使用
- 使用数字或char代替varchar  不仅节省空间查询的时候只需要比对一次即可
