package excercise6;

class PrintTask implements Runnable {
    private int threadNumber;

    public PrintTask(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        // Optionally include thread number in output
        System.out.println("Thread " + threadNumber + " output:");
        System.out.println("ONE");
        System.out.println("TWO");
        System.out.println("THREE");
        System.out.println("xxxxxxxxxx");
    }
}
