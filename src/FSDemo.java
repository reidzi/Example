class FailSoftArry {
    private int a[];
    private int errval;
    public int length;

    public FailSoftArry(int size, int errv) {
        a = new int[size];
        errval = errv;
        length = size;
    }

    public int get(int index){
        if(indexOK(index)) return a[index];
        return errval;
    }

    public boolean put(int index, int val){
        if(indexOK(index)){
            a[index] = val;
            return true;
        }
        return false;
    }

    private boolean indexOK(int index){
        if((index >= 0) & (index < length)) return true;
        return false;
    }
}

class FSDemo{
    public static void main(String args[]){
        FailSoftArry fs = new FailSoftArry(5, -1);
        int x;

        System.out.println("Обработка ошибок без вывода отчета.");

        for(int i=0; i< (fs.length * 2); i++)
            fs.put(i, i*10);
        for(int i=0; i < (fs.length * 2); i++){
            x = fs.get(i);
            if(x != -1) System.out.println(x + " ");
        }
        System.out.println(" ");

        System.out.println("\nОбработка ошибок с выводом отчета.");
        for(int i=0; i < (fs.length * 2); i++)
            if(!fs.put(i, i*10))
                System.out.println("Индекс " + i + " вне допустимого диапазона");
        for(int i=0; i< (fs.length * 2); i++){
            x = fs.get(i);
            if(x != -1) System.out.println(x + " ");
            else
                System.out.println("Индекс " + i + " вне допустимого диапазона");
        }

    }
}
