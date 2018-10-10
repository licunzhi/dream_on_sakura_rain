package private_interface;

/**
 * @author licunzhi
 * @desc 私有接口方法
 * @date 2018-10-10
 */
public class PrivateInterfaceDemo {
    public static void main(String[] args) {
        PrintMessageImpl printMessage = new PrintMessageImpl();
        /*重写之后的方法体中的输入*/
        printMessage.printMessage();
        /*接口方法中调用私有接口方法中的信息*/
        printMessage.printMessagePrivate();

        /*
        * 输出信息如下：
            overwrite interface method print message!
            print interface inner message info!
        * */
    }
}
