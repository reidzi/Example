import com.sun.org.apache.xpath.internal.SourceTree;
import qpack.ICharQ;

/**
 * Created by v.grebnev on 07.02.2017.
 */
public class QExcDemo {
    public static void main(String args[]){
        FixedQueue q = new FixedQueue(10);
        char ch;
        int i;

        try {
            for(i=0; i<11; i++) {
                System.out.print("Попытка сохранения: " + (char) ('A' + i));
                q.put((char) ('A' + i));
                System.out.println(" - Ok");

            }
            System.out.println();
        }
        catch (QueueFullException exc) {
            System.out.println(exc);
        }
        System.out.println();

        try {
            for(i=0;i<11;i++) {
                System.out.print("Получение очередного символа: ");
                ch = q.get();
                System.out.println(ch);
            }

        }
        catch (QueueEmptyException exc) {
            System.out.println(exc);
        }

    }
}

class QueueFullException extends Exception {
int size;
    QueueFullException(int s) {size = s;}

    public String toString() {
        return "\nОчередь заполнена. Максимальный размер очереди: " + size;
    }
}
class QueueEmptyException extends Exception {

    public String toString() {
        return "\nОчередь пуста.";
    }
}
class FixedQueue //implements ICharQ
{
    private char q[];
    private int putloc, getloc;

    public FixedQueue(int size){
        q = new char[size+1];
        putloc=getloc=0;
    }

    public void put(char ch)
    throws QueueFullException{
        if(putloc==q.length-1)
            throw new QueueFullException(q.length-1);
        putloc++;
        q[putloc] = ch;
    }

    public char get()
    throws QueueEmptyException {
        if(getloc == putloc)
            throw new QueueEmptyException();
        getloc++;
        return q[getloc];
    }
}

