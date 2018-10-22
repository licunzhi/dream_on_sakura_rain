package com.sakura.day_10_16;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-10-18
 */
public class TestDemo {
    public static void main(String[] args) {
        /*
         * 面向对象特征
         *       封装
         *       继承
         *       多态
         * */


        /*
         * 修饰符
         *       public 不同包文件 不同类文件
         *       protected 类 或继承类中调用
         *       private 同类中调用
         * */

        /*
         *  final 类 方法 变量
         *       public final class String 该类不能被继承 默认所有的方法被final修饰
         *       public final int size() 继承的
         *       private final char[] value 定义变量初始化 或者构造参数中初始化
         *  finally
         *  finalize
         * */
        final int a;
        a = 1;
        System.out.println(a);
        final int b = 1;
        //b = 3; // error
        System.out.println(b);

        /*
        * 静态变量
        *       static String name = "licunzhi";
        *       初始化一次
        *
        *       通过类取得属性信息
        * 实例变量
        *       User user = new User();
        *       使用一次 初始化一次
        *       必须初始化之后才能使用
        * */


        /*
        * 属性私有化
        * 实现细节封装
        *
        * 外部访问使用public方法进行访问
        * */


        /*
        * 多态
        *   属性 类 方法不同的形式
        *   重载 overloading  函数名相同 参数不同
        *   重写 overriding 子类实现父类，可以重写父类方法中的实现
        *
        * 构造器不能被重写  但是可以被重载
        * new User();
        * new User(String id, String name);
        *
        * */


        /*
        * 接口
        *   interface
        *       抽象方法的集合 一个类可以实现多个接口 实现之后需要实现其中的方法
        *
        *       不能实例化
        *       没有构造体
        *       只能声明静态变量
        * 抽象类
        *   abstract class
        *       可以含有构造方法
        *       可以含有抽象方法可以没有抽象方法
        *       单继承
        * */

        /*
        * 关键字
        *   super
        *       调用父类方法 属性
        *       调用父类构造器
        *
        *       默认使用的是父类的无参构造器
        *
        *
        *       调用父类的构造器
        *
        *     this
        *           this("name", "email")
        *           调用当前类中的构造器
        *
        *
        *     static
        *           类没有被实例化之前就能被调用
        *           仅能调用其他的static方法
        *           只能访问static变量
        *           不能引用this super
        *           不能被覆盖
        * */


        /*
        * 单例模式 singleton
        *   一个类仅有一个实例化，并自动想整个系统提供
        *
        *   私有的构造器
        *   该类静态私有变量
        *   静态共有函数提供对象的访问
        *
        * */


        /*
        * equals hashcode
        *
        *   修改equals的结果比较方式
        *
        *
        * == 比较引用地址信息
        * equals 比较引用的内容
        *
        * */



        /**
         * 反射
         */



    }
}
