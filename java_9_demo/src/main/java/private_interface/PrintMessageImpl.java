package private_interface;

/**
 * @author licunzhi
 * @desc 接口方法实现类(只需要实现默认的没有方法体中的方法就不会报错)
 * @date 2018-10-10
 */
public class PrintMessageImpl implements PrintMessage {

    @Override
    public void printMessage() {
        System.out.println("overwrite interface method print message!");
    }
}
