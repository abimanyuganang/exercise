package exercise;

public class weekSix extends Thread {
    private int num;

    public weekSix(int num){
        this.num = num;
    }

    public void run(){
        int i;
        for(i = 0;i<3;i++){
            System.out.println("Thread-" + (num-1) + ":" + num + "*" + i +"="+ (num*i) );
        }try {
            Thread.sleep(10);
        }catch (Exception e){
            System.out.println("Dont");
        }
    }
}
