package excercise6;

public class TestSleep {
    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            Thread t = new Thread(new PrintTask(i));
            t.start();
        }
    }
}
