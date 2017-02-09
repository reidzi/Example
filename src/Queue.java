// An improved queue class for characters.
class Queue {
    // these members are now private
    char q[]; // this array holds the queue
    int putloc, getloc; // the put and get indices

    Queue(int size) {
        q = new char[size]; // allocate memory for queue
        putloc = getloc = 0;
    }

    Queue(Queue ob){
        putloc = ob.putloc;
        getloc = ob.getloc;
        q = new char[ob.q.length];

        for(int i=getloc+1; i <=putloc; i++)
            q[i] = ob.q[i];

    }
    Queue(char a[]){
        putloc = 0;
        getloc = 0;
        q = new char[a.length+1];

        for(int i = 0; i < a.length; i++) put(a[i]);
    }

    // Put a characer into the queue.
    void put(char ch) {
        if(putloc==q.length-1) {
            System.out.println(" -- Queue is full.");
            return;
        }
        putloc++;

        q[putloc] = ch;
    }

    // Get a character from the queue.
    char get() {
        if(getloc == putloc) {
            System.out.println(" -- Queue is empty.");
            return (char) 0;
        }
        getloc++;

        return q[getloc];
    }
}



// Demonstrate the Queue class.
class QDemo {
    public static void main(String args[]) {
        Queue q1 = new Queue(10);
        char name[] = {'T', 'o', 'm'};

        Queue q2 = new Queue(name);

        char ch;
        int i;

        for(i=0; i < q1.q.length; i++)
            q1.put((char) ('A' + i));

        Queue q3 = new Queue(q1);

        System.out.print("Contents of q1: ");
        for(i=0; i < q1.q.length; i++) {
            ch = q1.get();
            if(ch != (char) 0) System.out.print(ch);
        }
        System.out.println("\n");

        System.out.print("Contents of q2: ");
        for(i=0; i < q2.q.length; i++) {
            ch = q2.get();
            if(ch != (char) 0) System.out.print(ch);
        }
        System.out.println("\n");


        System.out.print("Contents of q3: ");
        for(i=0; i < q3.q.length; i++) {
            ch = q3.get();
            if(ch != (char) 0) System.out.print(ch);
        }
        System.out.println("\n");





/*        Queue bigQ = new Queue(100);
        Queue smallQ = new Queue(4);
        char ch;
        int i;

        System.out.println("Using bigQ to store the alphabet.");
        // put some numbers into bigQ
        for(i=0; i < 26; i++)
            bigQ.put((char) ('A' + i));

        // retrieve and display elements from bigQ
        System.out.print("Contents of bigQ: ");
        for(i=0; i < 26; i++) {
            ch = bigQ.get();
            if(ch != (char) 0) System.out.print(ch);
        }

        System.out.println("\n");


        System.out.println("Using smallQ to generate erros.");
        // Now, use smallQ to generate some errors
        for(i=0; i < 5; i++) {
            System.out.print("Attempting to store " +
                    (char) ('Z' - i));

            smallQ.put((char) ('Z' - i));

            System.out.println();
        }
        System.out.println();

        // more errors on smallQ
        System.out.print("Contents of smallQ: ");
        for(i=0; i < 5; i++) {
            ch = smallQ.get();

            if(ch != (char) 0) System.out.print(ch);
*/        }
    }



