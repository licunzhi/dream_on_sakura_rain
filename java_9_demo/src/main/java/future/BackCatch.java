package future;

import java.util.concurrent.CompletableFuture;

/**
 * @author licunzhi
 * @desc 方法休眠捕捉
 * @date 2018-10-10
 */
public class BackCatch {

    public static CompletableFuture<String> messageBackInfo() throws InterruptedException {
        Thread.sleep(10000);
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        completableFuture.complete("message after long seconds");
        Thread.sleep(10000);
        completableFuture.complete("message after long long seconds");
        return completableFuture;
    }
}
