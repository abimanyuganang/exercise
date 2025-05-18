package exercise;

class MyThread extends Thread {
    private volatile boolean running = true;

    public void run() {
        while (running) {
            System.out.println("Thread is running...");
            try {
                Thread.sleep(500); // Just to slow it down a bit
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread is stopped.");
    }

    public void shutdown() {
        running = false;
    }
}
