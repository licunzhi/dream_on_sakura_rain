package diamond;

/**
 * @author licunzhi
 * @desc 钻石操作
 * @date 2018-10-10
 */
public class DiamondDemo {
    public static void main(String[] args) {
        /*
        * 钻石操作 since java 1.7
        * 类型推断
        * 泛型中不需要编写对应实体类信息
        * */
        Handler<Integer> intHandler = new Handler<>(1) {
            @Override
            public void handle() {
                System.out.println(content);
            }
        };
        intHandler.handle();
        Handler<? extends Number> intHandler1 = new Handler<>(2) {
            @Override
            public void handle() {
                System.out.println(content);
            }
        };
        intHandler1.handle();
        Handler<?> handler = new Handler<>("test") {
            @Override
            public void handle() {
                System.out.println(content);
            }
        };

        handler.handle();
    }
}

abstract class Handler<T> {
    public T content;

    public Handler(T content) {
        this.content = content;
    }

    abstract void handle();
}
