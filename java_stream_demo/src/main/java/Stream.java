import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-08-23
 */
public class Stream {
    public static void main(String[] args) {

        /**
         * 数据初始化部分
         */

        List<User> users = new ArrayList<>();

        User user = new User("1", "licunzhi", 1, 23, 62.12);
        users.add(user);
        user = new User("2", "xiaomeimei", 2, 23, 52.12);
        users.add(user);
        user = new User("3", "xiaojizai", 1, 24, 22.12);
        users.add(user);
        user = new User("4", "xiaozhuti", 2, 24, 22.12);
        users.add(user);
        user = new User("5", "dajizai", 1, 25, 32.12);
        users.add(user);
        user = new User("6", "dazhuti", 2, 25, 32.12);
        users.add(user);


        List<User> users_compare = new ArrayList<>();

        user = new User("1", "AAA", 1, 23, 12.12);
        users_compare.add(user);
        user = new User("2", "xiaomeimei", 2, 23, 12.12);
        users_compare.add(user);
        user = new User("3", "BBB", 1, 24, 22.12);
        users_compare.add(user);
        user = new User("4", "xiaozhuti", 2, 24, 22.12);
        users_compare.add(user);
        user = new User("5", "CCC", 1, 25, 32.12);
        users_compare.add(user);
        user = new User("6", "dazhuti", 2, 25, 32.12);
        users_compare.add(user);


        /*
        * 进行分组筛选（根据性别筛选）
        * */
        System.out.println("进行单层分组筛选操作");
        Map<Integer, List<User>> groupMap = users.stream().collect(Collectors.groupingBy(User::getSex));
        groupMap.forEach((k, v) -> {
            System.out.println(k);
            v.forEach(System.out::println);
        });
        /*
        * 多层分组
        * Map<k, v>
        *        |------- Map<k, v>
        * */
        System.out.println("进行双层分组筛选操作");
        Map<Integer, Map<String, List<User>>> doubleGroupMap = users.stream().collect(Collectors
                        .groupingBy(User::getSex, Collectors.groupingBy(User::getName, Collectors.toList())));
        doubleGroupMap.forEach((k, v) -> {
            System.out.println(k);
            v.forEach((k_in, v_in) -> {
                System.out.println(k_in);
                System.out.println(v_in);
            });
        });

        /*
         * 进行快速数学计算操作（salary）
        * sum()
        * max()
        * average()
        * */
        System.out.println("进行快速数学计算操作");
        double sum_value = users.stream().mapToDouble(User::getSalary).sum();
        System.out.println(sum_value);
        double max_value = users.stream().mapToDouble(User::getSalary).max().getAsDouble();
        System.out.println(max_value);
        double ave_value = users.stream().mapToDouble(User::getSalary).average().getAsDouble();
        System.out.println(ave_value);
        //定制化计算方式的初始化和计算函数方式
        int totalAge = users.stream().mapToInt(User::getAge).reduce(100, (a, b) -> a + b);
        System.out.println(totalAge);
        /*直接使用map函数对对象进行修改*/
        System.out.println("使用map方法对对象进行信息填充或者是转换");
        List<User> userListConvert = users.stream().map(u -> {
            User userMap = new User();
            userMap.setName(u.getName());
            return userMap;
        }).collect(Collectors.toList());
        userListConvert.forEach(System.out::println);
        /*
         * 集合分组进行分组计算
         * */
        System.out.println("使用groupingBy+reducing分组计算");
        Map<Integer, Integer> groupReduceMap = users.stream().collect(Collectors
                        .groupingBy(User::getSex, Collectors.reducing(-1000, User::getAge, Integer::sum)));
        //还可以使用：Integer::max Integer::min
        groupReduceMap.forEach((k, v) -> {
            System.out.println(k);
            System.out.println(v);
        });
        /*
         * 使用集合内置操作快捷方法
         * */
        System.out.println("使用groupingBy+averagingDouble分组计算");
        Map<Integer, Double> groupCollectorsAvgMap = users.stream()
                        .collect(Collectors.groupingBy(User::getSex, Collectors.averagingDouble(User::getAge)));
        //还可以使用 averagingInt averagingLong summingInt summingLong summingDouble minBy maxBy
        groupCollectorsAvgMap.forEach((k, v) -> {
            System.out.println(k);
            System.out.println(v);
        });

        /*
         * 过滤操作(filter)
         * */
        System.out.println("过滤操作(filter)");
        List<User> user2 = users.stream().filter(u -> u.getSex() == 1).collect(Collectors.toList());
        user2.forEach(System.out::println);

        //统计筛选结果的数量
        long count = users.stream().filter(u -> u.getSex() == 2).count();
        System.out.println(count);

        //介绍较为复杂的筛选操作，比较两个list，筛选指定的相同属性的结果(users,users_compare----甄选字段name)
        /*
         * 需要注意的是外层的集合设置需要是大范围的list，这样可以是的所有的操作结果都可以遍历到
         * */
        List<User> result_users = users.stream()
                        .filter(u -> users_compare.stream().anyMatch(uc -> Objects.equals(u.getName(), uc.getName())))
                        .collect(Collectors.toList());
        result_users.forEach(System.out::println);
        /*
         * 上面筛选函数使用的是自带的（anyMatch），如果你想使用指定统计条件你可以这么写
         * users.stream().filter(u -> users_compare.stream().filter(uc -> Objects.equals(u.getName(), uc.getName()))
                        .count() > 0).collect(Collectors.toList());
         *
         * 其中自带函数还有：
         * anyMatch ：满足匹配
         * allMatch ：所有匹配
         * noneMatch ：不匹配的
         * */

        /*排序操作*/
        System.out.println("默认排序操作(但是User类需要实现Comparator)否则会出现异常");
        /*List<User> sortedUsers = users.stream().sorted().collect(Collectors.toList());
        sortedUsers.forEach(System.out::println);*/
        System.out.println("不需要类实现Comparator就可以实现定制化排序");
        List<User> sortedUsers = users.stream().sorted(Comparator.comparingDouble(User::getSalary)).collect(Collectors.toList());
        sortedUsers.forEach(System.out::println);
    }
}
