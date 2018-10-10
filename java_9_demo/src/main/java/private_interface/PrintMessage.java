package private_interface;

/**
 * @author licunzhi
 * @desc 私有接口方法
 * @date 2018-10-10
 */
public interface PrintMessage {
    /**
     * 下面介绍了三部分
     *  第一个方法是默认接口方法，不能实现方法中的内容
     *  第二是接口方法，可以实现方法中的具体操作
     *  第三个是接口的私有方法，在接口的内部调用
     *
     *
     *  很多年前的java面试基础信息现在已经没有办法适用了
     */

    /*默认方法方式*/
    void printMessage();

    /*接口方法可以实现方法操作*/
    default void printMessagePrivate() {
        privatePrintMessageInner();
    }

    /*私有接口方法*/
    private void privatePrintMessageInner() {
        System.out.println("print interface inner message info!");
    }
}
