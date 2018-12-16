## 语言特性

### 三大特性
- 封装 
- 继承 
- 多态

### 多态的好处
- 允许不同对象对同一个消息做出相应，不同的对应可采用同种行为的操作方式  
    优点：  
    可替换性  
    可扩充性  
    接口性  
    灵活性  
    简化性 
    
- 如何实现多态 实际中的应用  
    在虚拟机中使用的是动态绑定技术 执行期间进行判断被操作的对象实际类型 调用指定对象中的指定方法  
    
- 接口的意义  
    规范  
    扩展  
    回调

- 抽象类的意义  
    封装子类中重复的逻辑代码  
    为子类提供一个公共类型  
    抽象方法允许子类重写自己的逻辑实现
    
- 接口和抽象类之间的区别
<pre>
<table><thead><tr><th style="vertical-align:middle;">比较</th>
			<th style="vertical-align:middle;">抽象类</th>
			<th style="vertical-align:middle;">接口</th>
		</tr></thead><tbody><tr><td style="vertical-align:middle;">默认方法</td>
			<td style="vertical-align:middle;">抽象类可以有默认的方法实现</td>
			<td style="vertical-align:middle;">java 8之前,接口中不存在方法的实现.</td>
		</tr><tr><td style="vertical-align:middle;">实现方式</td>
			<td style="vertical-align:middle;">子类使用extends关键字来继承抽象类.如果子类不是抽象类,子类需要提供抽象类中所声明方法的实现.</td>
			<td style="vertical-align:middle;">子类使用implements来实现接口,需要提供接口中所有声明的实现.</td>
		</tr><tr><td style="vertical-align:middle;">构造器</td>
			<td style="vertical-align:middle;">抽象类中可以有构造器,</td>
			<td style="vertical-align:middle;">接口中不能</td>
		</tr><tr><td style="vertical-align:middle;">和正常类区别</td>
			<td style="vertical-align:middle;">抽象类不能被实例化</td>
			<td style="vertical-align:middle;">接口则是完全不同的类型</td>
		</tr><tr><td style="vertical-align:middle;">访问修饰符</td>
			<td style="vertical-align:middle;">抽象方法可以有public,protected和default等修饰</td>
			<td style="vertical-align:middle;">接口默认是public,不能使用其他修饰符</td>
		</tr><tr><td style="vertical-align:middle;">多继承</td>
			<td style="vertical-align:middle;">一个子类只能存在一个父类</td>
			<td style="vertical-align:middle;">一个子类可以存在多个接口</td>
		</tr><tr><td style="vertical-align:middle;">添加新方法</td>
			<td style="vertical-align:middle;">想抽象类中添加新方法,可以提供默认的实现,因此可以不修改子类现有的代码</td>
			<td style="vertical-align:middle;">如果往接口中添加新方法,则子类中需要实现该方法.</td>
		</tr></tbody></table>
</pre>

- 静态方法
    父类的静态方法不能被重写  
    执行顺序 class constructor > static files > static code > static method > normal code

- 不可变对象
    final修饰  一旦创建状态不可改变

- java实现创建对象的方法
    - new newPerson();
    - 反射 Class<?> clazz = Class.forName(clazzName); clazz.newInstance();
    - clone 
        - 浅度拷贝  
        Clonable接口实现 super.clone()
        Object.clone()  对于基本的数据类型操作没问题  但是针对其中的非基本变量也只是采用了引用的方式
        ```java
         public class Product implements Cloneable {   
             private String name;   
           
             public Object clone() {   
                 try {   
                     return super.clone();   
                 } catch (CloneNotSupportedException e) {   
                     return null;   
                 }   
             }   
         } 
        ```
        //因此 这种方式要想实现深度拷贝  需要把拷贝类中所有的非基本数据类型全部重写clone()方法
        
    - 序列化机制  
    借用上面的浅拷贝的机制的不足，提出了深度拷贝的方式  
    对象进行序列化字节流  以便在合适的状态转换成当时状态的对象 
    ```code
    使用泛型约束限制进行copy对象是序列化的
    public static <T extends Serializable> T copy(T input) {
        ByteArrayOutputStream baos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(input);
            oos.flush();
     
            byte[] bytes = baos.toByteArray();
            bis = new ByteArrayInputStream(bytes);
            ois = new ObjectInputStream(bis);
            Object result = ois.readObject();
            return (T) result;
        } catch (IOException e) {
            throw new IllegalArgumentException("Object can't be copied", e);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("Unable to reconstruct serialized object due to invalid class definition", e);
        } finally {
            closeQuietly(oos);
            closeQuietly(baos);
            closeQuietly(bis);
            closeQuietly(ois);
        }
    ```
    同样可以使用json等其他的技术实现对象的深度复制  
    Apache BeanUtils、PropertyUtils,Spring BeanUtils,Cglib BeanCopier  
    从测试效率上看 Cglib BeanCopier > Spring BeanUtil > apache BeanUtils

- switch的case类型  
    1.7版本之前支持int byte short char   1.7版本之后支持String

- String对相中的方法 intern()  空间中查询字符串是否已经存在  
    ```code
        public native String intern();
        原生接口  底层进行实现
    ```
    
- 隐式转换  
    += 和 = + 之间的区别  
    前者进行运算的时候 会将结果强转和前面一致的数据类型 不考虑精度丢失的问题  
    但是后者在进行运算的时候 有可能会出现异常或者是报错的情况  

- 内部类的作用  
    - 简单说法，当前类中的某个方法和继承或实现类中的方法冲突可以使用内部类去实现或者是继承重写其中的方法  
    外部类有完全的访问权限访问到内部类的内容，因此满足了上面的问题。但是这个并不能完全解释有点  
    - 严格上来，可以使用内部类的方式最终实现多继承  
    也有隐藏内部类 封装属性的作用
    
- final的用法
    - final修饰类  修饰方法 修饰属性参数 常量
    - 修饰类不能被继承 String
    - 修饰方法不能被overwrite
    - 修饰方法 jvm进行内联 提高程序运行的效率
    - final的修饰的常量 在编译阶段放入到常量池中
    
    
- java中的数据类型占用自己字节的大小
    -  scfild 占用位数 224488 字节数 乘以8
    
- int和Integer
    - 占用内存的大小不同
    - 原始数据类型 Integer是一个对象
    
- String, StringBuilder, StringBuffer
    - String 字符串常量，大量字符串会导致进行GC操作 影响性能
    - StringBuilder 字符串变量 线程不安全
    - StringBuffer 字符串变量 线程安全的 大量字符串拼接操作建议使用 synchronized关键字操作

- BigDecimal和double标识浮点数在精度上有误差  因此对于价格这种要求精确度十分高的需要使用BigDecimal进行运算

- 常见的垃圾回收算法
    - 标记清除法
    - 标记复制法
    - 标记整理法
    - 分代回收法

- 对象的存活性判断
    - 引用计数法
    - 对象可达性分析（推荐回答）
    
- System.gc() 只是通知GC开始工作，但是真正开始工作的时间并不知道

- wait() 和 sleep() wait()是object中的方法会释放当前的线程锁

- 手动写一个生产消费者模式的代码

- 使用线程池的好处
