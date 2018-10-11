package react_stream;

import org.junit.Test;

import java.util.List;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-10-10
 */
public class StreamDemo {

    @Test
    public void whenSubscribeToIt_thenShouldConsumeAll() {

        /*// given
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
        EndSubscriber<String> subscriber = new EndSubscriber<>();
        publisher.subscribe(subscriber);
        List<String> items = List.of("1", "x", "2", "x", "3", "x");

        // when
        assertThat(publisher.getNumberOfSubscribers()).isEqualTo(1);
        items.forEach(publisher::submit);
        publisher.close();

        // then
        await().atMost(1000, TimeUnit.MILLISECONDS)
                        .until(() -> assertThat(subscriber.consumedElements).containsExactlyElementsOf(items));*/
    }
}

