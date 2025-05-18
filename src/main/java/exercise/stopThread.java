package exercise;

public class stopThread {
    public static void main(String[] args) throws Exception {
        MyThread t1 = new MyThread();
        t1.start();

        System.out.println("hit ENTER to stop the thread...");
        System.in.read();

        t1.shutdown();
    }
}

