import qpack.*;


class IQDemo{
    public static void main(String args[]){
        qpack.FixedQueue q1 = new qpack.FixedQueue(10);
        qpack.DynQueue q2 = new qpack.DynQueue(5);
//        qpack.CircularQueue q3 = new qpack.CircularQueue(10);
         ICharQ iQ;
        char ch;
        int i;

        iQ = q1;
        for(i=0; i < 10; i++) iQ.put((char) ('A' + i));
        System.out.print("Содержимое фиксированной очереди: ");
        for(i=0;i<10;i++){
            ch = iQ.get();
            System.out.print(ch + " ");
        }
        System.out.println();

        iQ = q2;
        for( i = 0; i < 10; i++) iQ.put((char) ('Z' - i));
        System.out.print("Содержимое динамической очереди: ");
        for(i = 0; i < 10; i++){
            ch = iQ.get();
            System.out.print(ch + " ");
        }
        System.out.println();

//        iQ = q3;
//        for(i = 0; i < 10; i++) iQ.put((char) ('A' + i*2));
//        System.out.print("Содержимое кольцевой очереди: ");
//        for(i = 0; i < 10; i++) {
//            ch = iQ.get();
//            System.out.print(ch + " ");
//        }
//        System.out.println();
//
//        for(i = 10; i < 20; i++) iQ.put((char) ('A' + i));
//
//        System.out.print("Содержимое кольцевой очереди: ");
//        for(i = 0; i < 10; i++) {
//            ch = iQ.get();
//            System.out.print(ch + " ");
//        }
//        System.out.println("\nСохранение и использование данных" + "кольцевой очереди");
//
//        for(i=0;i<20;i++) {
//            iQ.put((char) ('A'+i));
//            ch = iQ.get();
//            System.out.print(ch + " ");
//        }
    }

}