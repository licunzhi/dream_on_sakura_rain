## 异常处理的方式
 - throw 交给上层去处理
 - try catch中进行处理操作



### try操作
- 组合形式
    - try catch
    - try finally
    - try catch finally
    
    catch可以有多块语句 try finally只会有一个  
    catch中可以捕捉不同类型或者是粒度不同的异常，针对不同的异常可以编写不同的处理代码  
    try语句中代码如果没有出现异常不执行catch操作  
    finally语句中的代码一定会执行  
    多个catch操作的时候按照顺序执行判断，一旦某位置捕捉异常之后后面的catch操作不再执行  
    finally一般执行必须进行的操作 一般用于资源的释放  
    try 后面总是需要跟点什么才是最舒服的
