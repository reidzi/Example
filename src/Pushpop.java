/**
 * Created by v.grebnev on 03.02.2017.
 */

// An improved queue class for characters.
class Stak {
    // these members are now private
    private char q[]; // this array holds the queue
    private int pushloc, poploc; // the put and get indices

    Stak(int size) {
        q = new char[size]; // allocate memory for queue
        pushloc = poploc = 0;
    }


    // Put a characer into the queue.
    void push (char ch) {
        if(pushloc==q.length) {
            System.out.println(" -- Queue is full.");
            return;
        }
        q[pushloc] = ch;
        pushloc++;
    }

    // Get a character from the queue.
    char pop () {
        if(poploc == pushloc) {
            System.out.println(" -- Queue is empty.");
            return (char) 0;
        }

        this.poploc = poploc + 1;
        return q[poploc-1];


    }
}



// Demonstrate the Queue class.
class Pushpop {
    public static void main(String args[]) {
        Stak q1 = new Stak(10);

        char ch;
        int i;

        for(i=0; i < 10; i++)
            q1.push((char) ('A' + i));


        System.out.print("Contents of q1: ");
        for(i=0; i < 10; i++) {
            ch = q1.pop();
            if(ch != (char) 0) System.out.print(ch);
        }
        System.out.println("\n");

        System.out.print("Contents of q1: ");
        for(i=0; i < 10; i++) {
            ch = q1.pop();
            if(ch != (char) 0) System.out.print(ch);
        }
        System.out.println("\n");
}
}


