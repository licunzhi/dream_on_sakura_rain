## Trigger 触发器

### 分类
- before 操作事件之前
    - insert 
    - update
    - delete
- after  操作事件之后
    - insert
    - update
    - delete

```sql
    CREATE TRIGGER trigger_name trigger_time trigger_event ON tb_name FOR EACH ROW trigger_stmt
    [创建一个触发器    叫做    在什么时候   什么事件   在什么表上            每一行都会受到影响  ]
    notice: 
        trigger_name -- 触发器的名称
        tirgger_time -- 触发时机，为BEFORE或者AFTER
        trigger_event -- 触发事件，为INSERT、DELETE或者UPDATE
        tb_name -- 表示建立触发器的表明，就是在哪张表上建立触发器
        trigger_stmt -- 触发器的程序体，可以是一条SQL语句或者是用BEGIN和END包含的多条语句
        
        |
        | 演变过程
        |
        ↓
        
        CREATE TRIGGER 触发器名 BEFORE|AFTER 触发事件
        ON 表名 FOR EACH ROW
        BEGIN
            执行语句列表
        END
        
        |
        | demo
        |
        ↓
        
        create trigger operation_log
        after insert 
        on sakura
        for each row
        begin 
          insert into logs("operation_time", db_name) values(now(), database());
        end 
```


### 注意事项
- 触发器是基于行触发，因此万万不可在触发器中编写相对复杂的操作逻辑   否则得不偿失


#### 看一个复杂的操作
```sql
create trigger tapp_trigger after update
on business FOR EACH ROW
begin  
set @count = (select count(*) from temp where business_id = old.id);
set @Differ = (SELECT sum(TIMESTAMPDIFF(minute , create_time, modify_time)) from business where id = old.id );
if @count = 0 then  
	insert into temp(business_id, start_time, differ) values(old.id, old.create_time, @Differ);
elseif @count > 0 THEN
	update temp set differ=@Differ where business_id = old.id;
end if;  
end;

```
