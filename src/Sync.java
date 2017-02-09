class SumArry{
    private int sum;
    synchronized int sumArray(int nums[]){
        sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            System.out.println("Текущее значение суммы для " + Thread.currentThread().getName() + ": " + sum);
            try{
                Thread.sleep(10);
            }
            catch (InterruptedException exc){
                System.out.println("Прерывание потока" + Thread.currentThread().getName());
            }
        }
        return sum;
    }
}

class MyThread1 implements  Runnable {
    Thread thrd;
    static SumArry sa = new SumArry();
    int a[];
    int answer;

    MyThread1(String name, int nums[]){
        thrd = new Thread(this, name);
        a = nums;
        thrd.start();
    }

    public void run(){
        int sum;
        System.out.println(thrd.getName() + " - Запуск.");
        answer = sa.sumArray(a);
        System.out.println("СУММА для "+ thrd.getName() + ": " + answer);
        System.out.println(thrd.getName() + " - завершение.");

    }
}

public class Sync {
    public static void main(String[] args){
        int a[] = {1,2,3,4,5};
        MyThread1 mt1 = new MyThread1("Child #1", a);
        MyThread1 mt2 = new MyThread1("Child #2", a);
    }
}
