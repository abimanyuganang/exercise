package exercise;

public class threeThread {
    public static void main(String[] args) {
        weekSix t1 = new weekSix(1);
        weekSix t2 = new weekSix(2);
        weekSix t3 = new weekSix(3);

        t1.run();
        t2.run();
        t3.run();
    }
}
