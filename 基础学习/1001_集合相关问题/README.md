
![集合的结构图](../images/Collections.png)

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
