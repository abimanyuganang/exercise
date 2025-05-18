package week_07;

import java.util.concurrent.atomic.AtomicInteger;

public class CountProblem implements Runnable {
    private AtomicInteger count = new AtomicInteger(0);

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            count.incrementAndGet();
        }
    }

    public int getCount() {
        return count.get();
    }
}
