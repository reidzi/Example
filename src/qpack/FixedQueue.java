package qpack;

/**
 * Created by v.grebnev on 06.02.2017.
 */
public class FixedQueue implements ICharQ {
    private char q[];
    private int putloc, getloc;

    public FixedQueue(int size){
        q = new char[size+1];
        putloc=getloc=0;
    }

    public void put(char ch){
        if(putloc==q.length-1) {
            System.out.println(" - Очередь заполнена.");
            return;
        }
        putloc++;
        q[putloc] = ch;
    }

    public char get() {
        if(getloc == putloc){
            System.out.println(" - Очередь пуста.");
            return (char) 0;
        }
        getloc++;
        return q[getloc];
    }
}
