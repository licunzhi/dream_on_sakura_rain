package collection;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

/**
 * @author licunzhi
 * @desc 集合方法
 * @date 2018-10-09
 */
public class CollectionDemo {
    public static void main(String[] args) {
        /*
    * java_9为集合创建新的静态方法，方便使用
    *   static <E> List<E> of(E e1, E e2, E e3);
        static <E> Set<E>  of(E e1, E e2, E e3);
        static <K,V> Map<K,V> of(K k1, V v1, K k2, V v2, K k3, V v3);
        static <K,V> Map<K,V> ofEntries(Map.Entry<? extends K,? extends V>... entries)
    * */
        List<String> list = List.of();
        System.out.println(list.size());

        List<String> list_nums = List.of("Stirng", "licunzhi", "sakura");
        list_nums.forEach(System.out::println);

        Map<Integer, String> map = Map.of(1, "licunzhi", 2, "sakura");
        map.forEach((k, v) -> System.out.println(k + v));

        Map<String, String> map1 = Map.ofEntries (
                        new AbstractMap.SimpleEntry<>("A","Apple"),
                        new AbstractMap.SimpleEntry<>("B","Boy"),
                        new AbstractMap.SimpleEntry<>("C","Cat"));
        System.out.println(map1);

    }
}
