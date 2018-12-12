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

