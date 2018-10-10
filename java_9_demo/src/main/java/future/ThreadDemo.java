package future;

/**
 * @author licunzhi
 * @desc 线程方法的使用
 * @date 2018-10-10
 */
public class ThreadDemo implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("I sleep 10 seconds !");
    }
}
