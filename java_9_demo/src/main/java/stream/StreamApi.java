package stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author licunzhi
 * @desc 改进流操作
 * @date 2018-10-10
 */
public class StreamApi {
    public static void main(String[] args) {
        /*
         * 增加的内容
         *
         *   stream = dropWhile、takeWhile、ofNullable
         *   iterate = 方法新增了一个重载方法
         * */
        //takeWhile 开始操作stream中的数据，知道不满足条件函数返回之前满足的结果 ： abc
        Stream.of("a", "b", "c", "-", "e", "f").takeWhile(s -> !s.equals("-")).forEach(System.out::print);
        System.out.println();
        //dropWhile 开始操作stream中的数据，返回第一断言之后的所有数据（包括判断条件自己）
        Stream.of("a", "b", "c", "-", "e", "-", "f").dropWhile(s -> !s.equals("-")).forEach(System.out::print);

        /*
         * 按照种子数据进行表达是格式叠加数据
         * 3 种子
         * x -> x < 10 判断限制
         * x -> x+ 3 下一个遍历条件
         * */
        IntStream.iterate(3, x -> x < 10, x -> x + 3).forEach(System.out::println);

        /*
         * ofNullable
         * 允许创建为null的数据流  返回不是空对象
         * */
        long count = Stream.ofNullable(100).count();
        System.out.println(count);

        count = Stream.ofNullable(null).count();
        System.out.println(count);
    }
}
