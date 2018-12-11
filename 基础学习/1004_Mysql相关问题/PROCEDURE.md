## procedure 存储过程

### 存储过程一般的模板模式
```mysql
CREATE
    [DEFINER = { user | CURRENT_USER }]
    PROCEDURE sp_name ([proc_parameter[,...]])
    [characteristic ...] routine_body

proc_parameter:
    [ IN | OUT | INOUT ] param_name type

characteristic:
    COMMENT 'string'
  | LANGUAGE SQL
  | [NOT] DETERMINISTIC
  | { CONTAINS SQL | NO SQL | READS SQL DATA | MODIFIES SQL DATA }
  | SQL SECURITY { DEFINER | INVOKER }

routine_body:
    Valid SQL routine statement

[begin_label:] BEGIN
    [statement_list]
END [end_label]
```


### 简单的案例分析
```mysql
DELIMITER //  
CREATE PROCEDURE proc1 (IN parameter1 INTEGER)   
BEGIN   
   DECLARE variable1 CHAR(10);   
   IF parameter1 = 17 THEN   
       SET variable1 = 'birds';   
       ELSE 
       SET variable1 = 'beasts';   
   END IF;   
INSERT INTO table1 VALUES (variable1);  
END //  
DELIMITER ;
```
