package threads;

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

public class MoreThreads {
    public static void main (String[] args){
        System.out.println("Запуск основного потока");
        MyThread mt1 = new MyThread(" Ребенок #1");
        MyThread mt2 = new MyThread(" Ребенок #2");
        MyThread mt3 = new MyThread(" Ребенок #3");

        try{
            mt1.join();
            System.out.println(mt1.getName() + "присоединен");
            mt2.join();
            System.out.println(mt2.getName() + "присоединен");
            mt3.join();
            System.out.println(mt3.getName() + "присоединен");
        }
        catch (InterruptedException exc) {
            System.out.println("прерывание основного потока.");
        }
//        do{
//            System.out.print(".");
//            try {
//                Thread.sleep(100);
//            }
//            catch (InterruptedException exc) {
//                System.out.println("Поток main прерван.");
//            }
//        } while (mt1.isAlive() || mt2.isAlive() || mt3.isAlive());
        System.out.println("Завершение основного потока.");
    }
}
