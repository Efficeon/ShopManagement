import threads.MiniMarketThread;
import threads.PepitoMarketThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ApplicationStart {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Thread pepitoMarketThread = new PepitoMarketThread();
        Thread miniMarketThread = new MiniMarketThread();

        executor.execute(pepitoMarketThread);
        Thread.sleep(1000);
        executor.execute(miniMarketThread);

        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }
}
