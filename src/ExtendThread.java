class MyThread extends Thread {

    MyThread(String name){
        super(name);
        start();
    }
    public void run() {
        System.out.println(super.getName() + " - запуск.");
        try {
            for(int count = 0; count <10; count++){
                Thread.sleep(400);
                System.out.println("В "+ getName() + ", счетчик: " + count);
            }
        }
        catch (InterruptedException exc) {
            System.out.println(getName() + " прерван.");
        }
        System.out.println("Завершение " + getName());
    }
}

public class ExtendThread {
    public static void main (String[] args){
        System.out.println("Запуск основного потока");
        MyThread mt = new MyThread(" Ребенок #1");

        for (int i = 0; i < 50; i++){
            System.out.print(".");
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException exc) {
                System.out.println("Поток main прерван.");
            }
        }
        System.out.println("Завершение основного потока.");
    }
}
