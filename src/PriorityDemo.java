class Priority implements Runnable{
    int count;
    Thread thrd;

    static boolean stop = false;
    static String currentName;

    Priority(String name){
        thrd = new Thread(this, name);
        count = 0;
        currentName = name;
    }

    public void run(){
        System.out.println(thrd.getName() + " - запуск.");
        do {
            count++;
            if(currentName.compareTo(thrd.getName()) != 0) {
                currentName = thrd.getName();
                System.out.println("В " + currentName);
            }
        }while (stop == false && count < 1000000);
        stop = true;
        System.out.println("\n" + thrd.getName() + " - завершение.");
    }
}
public class PriorityDemo {
    public static void main(String[] args){
        Priority mt1 = new Priority("High priority");
        Priority mt2 = new Priority("Low priority");
        mt1.thrd.setPriority(Thread.NORM_PRIORITY+2);
        mt2.thrd.setPriority(Thread.NORM_PRIORITY-2);

        mt1.thrd.start();
        mt2.thrd.start();

        try{
            mt1.thrd.join();
            mt2.thrd.join();
        }
        catch (InterruptedException exc) {
            System.out.println("Прерывание основного потока");
        }
        System.out.println("\nСчетчик потока High priority: " + mt1.count);
        System.out.println("\nСчетчик потока Low priority: " + mt2.count);
    }
}
