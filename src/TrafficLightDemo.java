/**
 * Created by v.grebnev on 09.02.2017.
 */
enum TrafficLightColor {
    RED, GREEN, YELLOW
}


class TrafficLightSimulator implements Runnable {
    private Thread thrd;
    private TrafficLightColor tlc;
    boolean stop = false;
    boolean changed = false;

    TrafficLightSimulator(TrafficLightColor init) {
        tlc = init;
        thrd = new Thread(this);
        thrd.start();
    }
    TrafficLightSimulator(){
        tlc = TrafficLightColor.RED;
        thrd = new Thread(this);
        thrd.start();
    }

    public void run() {
        while(!stop) {
            try{
                switch(tlc) {
                    case GREEN:
                        Thread.sleep(1000);
                        break;
                    case YELLOW:
                        Thread.sleep(2000);
                        break;
                    case RED:
                        Thread.sleep(1200);
                        break;
                }
            } catch (InterruptedException exc) {
                System.out.println(exc);
            }
            changeColor();
        }

    }

    synchronized void changeColor(){
        switch(tlc) {
            case RED:
                tlc = TrafficLightColor.GREEN;
                break;
            case YELLOW:
                tlc = TrafficLightColor.RED;
                break;
            case GREEN:
                tlc = TrafficLightColor.YELLOW;
                break;
        }

        changed = true;
        notify();
    }

    synchronized void waitForChange() {
        try {
            while(!changed)
                wait();
            changed = false;
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }
    }

    TrafficLightColor getColor() {
        return tlc;
    }

    void cancel() {
        stop = true;
    }

}
public class TrafficLightDemo {
    public static void main(String[] args) {
        TrafficLightSimulator t1 = new TrafficLightSimulator(TrafficLightColor.GREEN);

        for(int i = 0; i < 9; i++) {
            System.out.println(t1.getColor());
            t1.waitForChange();
        }

        t1.cancel();
    }
}
