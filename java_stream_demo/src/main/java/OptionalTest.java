import java.util.Optional;

/**
 * @ClassName OptionalTest
 * @function [优雅进行空判断]
 * @Author lcz
 * @Date 2020/07/19 09:15
 */
public class OptionalTest {
    public static void main(String[] args) {
       /*optional 构造参数是私有的，不允许使用new的方式创建新的对象
       使用的是单例模式: 饿汉模式
       * */

       /*空对象出现报错情况*/
        User nullUser = null;
        try {
            Optional<Object> nullPointerException = Optional.of(nullUser);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*对象不为空的获取*/
        User user = new User();
        user.setId("111");
        user.setName("sakura");
        Optional<User> optional = Optional.of(user);
        User optionalUser = optional.get();
        System.out.println(optionalUser);
        /*
        * 输出结果：
        * User{id='111', name='sakura', sex=0, age=0, salary=0.0}
        *
        * of()：参数对象如果为空的话直接抛出空指针异常
        * 因此此方法在强定性逻辑代码中可以避免对于参数的为空判断从而抛出异常的处理逻辑
        *
        * 但是如果代码的逻辑是在为null的情况下进行一些其他的操作的时候这个方法不再适用
        * 而且似乎看不出这种操作的有点到底在什么地方，最起码我认为如果只是这么用的话不如使用之前的null != user判断
        * 我们将介绍下面的其他的方法。。请继续向下阅读代码
        * */

        System.out.println("--------------------------");

        /* 展示一些更为优雅的操作需要创建更加复杂的类对象
        * 因此我这重新创建了一个更加复杂的用户对象
        * UserOptional
        *
        * 通过这个对象我将为你展示我所理解的Optional的应用方式
        * */

        /*常规操作：获取内部的address甚至是address里面的属性*/
        UserOptional userOptional = new UserOptional();
        userOptional.setName("sakura");
        userOptional.setAge("26");
        Address address = new Address();
        address.setColor("white");
        address.setYears("1990");
        Location location = new Location();
        location.setStreetNum("123");
        /*
        * 现在可以看出对象的结构大致为：
        * UserOptional
        *    - Address
        *       - Location
        * */

        /*使用之前的方法获取Location对象中的某个参数*/
        //String streetNum = userOptional.getAddress().getLocation().getStreetNum();
        //System.out.println(streetNum);
        /*总结： 虽然一直get下去可以获取到Location对象中的某个参数，但是很可惜在现实开发中中间的对象都可能会出现为空的情况
        * 如果不加以控制就会直接甩出空指针异常， 因此我们经常会用到下面这种多重内部迭代判断空指针的情况*/
        //Address address1 = userOptional.getAddress();
        //if (address1 != null) {
        //    Location location1 = address1.getLocation();
        //    if (location1 != null) {
        //        System.out.println(location1.getStreetNum());
        //    }
        //}
        /*我觉得你可能在实际业务处理中不需要一直判断下去，有可能在其中不满足的一种情况的时候直接return出去了
        * 但是万一要是需要一直判断下去整个代码看起来就很扎心。
        * 此处不扎心，就没有办法对比我们下面的代码， 我们可以看下下面的这段代码
        * */
        String streetNumResultInfo = Optional.of(userOptional).flatMap(UserOptional::getAddress).flatMap(Address::getLocation).map(Location::getStreetNum).orElse("");
        System.out.println(streetNumResultInfo);
        /*
        * 使用这种方法之后最大的改变的就是导致get方法进行了变种
        * 虽然一直在吹嘘这种写法，但是我个人觉得这种方式了解一下怎么使用就好了
        * 拿到这种代码之后知道本质上在做什么操作，目的是实现了什么样的功能就行了
        *
        * 从理解的角度来说，这种代码看起来会觉得让人恶心
        * */

    }
}
