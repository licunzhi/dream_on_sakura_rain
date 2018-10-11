package react_stream;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Flow;

/**
 * @author licunzhi
 * @desc 终端 控制数据策略
 * @date 2018-10-10
 */
public class EndSubscriber<T> implements Flow.Subscriber<T> {

    private Flow.Subscription subscription;

    public List<T> consumedElements = new LinkedList<>();

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(T item) {
        System.out.println("Got : " + item);
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Done");
    }
}
