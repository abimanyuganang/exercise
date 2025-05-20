package TrafficLight;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Thread northSouth = new Thread(new TrafficController("North-South"), "NS-Thread");
        Thread eastWest = new Thread(new TrafficController("East-West"), "EW-Thread");
        Thread northEast = new Thread(new TrafficController("North-East"), "NE-Thread");
        Thread southWest = new Thread(new TrafficController("South-West"), "SW-Thread");

        northSouth.start();
        eastWest.start();
        northEast.start();
        southWest.start();
    }
}
enum LightState {
    RED, YELLOW, GREEN
}

class TrafficLight {
    private LightState state;
    private String direction;

    public TrafficLight(String direction) {
        this.state = LightState.RED;
        this.direction = direction;
    }

    public void setState(LightState state) {
        this.state = state;
        System.out.println(direction + " light is now " + state);
    }
}

class TrafficController implements Runnable {
    private static final ReentrantLock lock = new ReentrantLock(true); //
    private TrafficLight light;

    public TrafficController(String direction) {
        this.light = new TrafficLight(direction);
    }

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                light.setState(LightState.GREEN);
                TimeUnit.SECONDS.sleep(5);

                light.setState(LightState.YELLOW);
                TimeUnit.SECONDS.sleep(2);

                light.setState(LightState.RED);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            } finally {
                lock.unlock();
            }

            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
