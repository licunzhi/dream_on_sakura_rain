
![集合的结构图](../images/Collections.png)

### Object 爸爸级别
- 类结构的根类，所有类的爸爸
- 构造方法
```java
    Object() 默认的无参构造器
    equals(Object obj) 判断对象是否相等
    finalize() 垃圾回收调用
    getClass() 返回运行时类
    hashCode（） 返回对象的哈希值
    notify() 唤醒正在等待对象监视器的单个线程
    notifyAll() 唤醒正在等待对象监控的所有线程
    toString() 返回对象的字符串表示形式
    wait() 导致当前线程等待，知道另一个线程调用该对象的notify()方法或者notifyAll()
    wait(long timeout) 导致当前线程等待，直到唤醒方法被调用，或者指定的时间过时
    wait(long timeout) 导致当前线程等待，直到唤醒方法被调用，或者指定的时间过时， 或某些线程中断当前线程
```
- equals()方法重写之后hashCode（）方法重写原因
    hashCode()方法获取哈希值，在哈希表中可以快速定位的数据元素所在的位置，一旦equals()方法重写之后
    判断对象是否相等规则被改写，原生的hashCode()方法获取两个不用的对象的哈希值可能不一样，导致获取存储
    混乱的情况，请注意是在哈希表中有用
- wait() notify() 结合[多线程](../1002_多线程相关问题/README.md)


### Dictionary
NOTE: This class is obsolete.  New implementations should implement the Map interface, rather than extending this class.
古老的键值存储类，推荐使用map替换

### Hashtable
Dictionary的直接子类

Java Collections Framework</a>.  Unlike the new collection
implementations, {@code Hashtable} is synchronized.  If a
thread-safe implementation is not needed, it is recommended to use
{@link HashMap} in place of {@code Hashtable}.  If a thread-safe
highly-concurrent implementation is desired, then it is recommended
to use {@link java.util.concurrent.ConcurrentHashMap} in place of
如果需要线程安全的操作推荐使用ConcurrentHashMap替换

为什么？
加锁机制是为了实现数据的读取或者是修改的安全性，hashTable使用方法枷锁的方式实现调用方法时全局枷锁，具体代码源码
```java
public synchronized V put(K key, V value) {
        // Make sure the value is not null
        if (value == null) {
            throw new NullPointerException();
        }

        // Makes sure the key is not already in the hashtable.
        Entry<?,?> tab[] = table;
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;
        @SuppressWarnings("unchecked")
        Entry<K,V> entry = (Entry<K,V>)tab[index];
        for(; entry != null ; entry = entry.next) {
            if ((entry.hash == hash) && entry.key.equals(key)) {
                V old = entry.value;
                entry.value = value;
                return old;
            }
        }

        addEntry(hash, key, value, index);
      
```
而concurrent相当于有多个hashTable，同时可以在不同的hashTable中多个加锁操作
```java
public V get(Object key) {
        Node<K,V>[] tab; Node<K,V> e, p; int n, eh; K ek;
        int h = spread(key.hashCode());
        if ((tab = table) != null && (n = tab.length) > 0 &&
            (e = tabAt(tab, (n - 1) & h)) != null) {
            if ((eh = e.hash) == h) {
                if ((ek = e.key) == key || (ek != null && key.equals(ek)))
                    return e.val;
            }
            else if (eh < 0)
                return (p = e.find(h, key)) != null ? p.val : null;
            while ((e = e.next) != null) {
                if (e.hash == h &&
                    ((ek = e.key) == key || (ek != null && key.equals(ek))))
                    return e.val;
            }
        }
        return null;
    }
```


### Vector
- Vector是线程安全的，效率上来说应该是比ArrayList低
- Vector满了之后扩容是之前的一倍，ArrayList仅仅是一半
- Vector分配空间需要连续的存储空间，如果数据量较大的情况容易导致内存分配失败
- 只能在尾部进行插入删除操作

存储空间翻倍的原因
```java
private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        // 如果设置了倍增的大小使用设置的大小，如果没有设置的话使用现有的长度加上现有的长度
        int newCapacity = oldCapacity + ((capacityIncrement > 0) ?
                                         capacityIncrement : oldCapacity);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        elementData = Arrays.copyOf(elementData, newCapacity);
    }
```


### Stack - Vector子类
特点: last-in-first-out LIFO 先进后出

- 扩展了Vector与五个操作，堆栈操作 具备基本操作push peek，检测是否empty 以及search方法
- 更优化更多操作的类可以使用 **Deque** （后面探究） ，使用方式
   ```java
       Deque<Integer> stack = new ArrayDeque<Integer>();
    ``` 
- 起始版本1.0，古老的一个类
- 方法简介
```java
    Stack()                 创建一个空堆栈
    empty() boolean         判断堆栈是否为空
    peek() E                查看堆栈的顶部对象，不做删除操作
    pop() E                 获取堆栈顶部数据，删除该数据
    push(E item) E          将项目推送到次堆栈的顶部      
    search(Object o) int    返回一个对象在堆栈的位置
```
- 线程安全，内部方法采用synchronized关键字加锁
- 底层采用数组实现，通过下标的方式进行定位
- 如果不是必须保证线程安全的情况，推荐使用LinkedList
