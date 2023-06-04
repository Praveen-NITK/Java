package AlgorithmsBook.queue;


public class ArrayQueueOfStrings implements QueueImplementation<String> {

    String [] queue;
    int N=0;

    public ArrayQueueOfStrings(){
        queue= new String[1];
    }

    @Override
    public void enqueue(String s) {
        if (N== queue.length){
            resize(queue.length*2);
        }
        queue[N++]=s;
    }

    private void resize(int capacity) {
        String [] copy= new String[capacity];
        for (int i = 0; i < queue.length; i++) {
            copy[i]=queue[i];
        }
        queue=copy;
    }

    @Override
    public void dequeue() {
        String res= queue[0];
        for (int i = 1; i < queue.length; i++) {
            queue[i-1]= queue[i];
        }
        System.out.println(res);
        N--;
    }

    @Override
    public boolean isEmpty() {
        return N==0;
    }

    public static void main(String[] args) {
        ArrayQueueOfStrings aqs= new ArrayQueueOfStrings();
        aqs.enqueue("ram");
        aqs.enqueue("mohan");
        aqs.dequeue();
        System.out.println(aqs.isEmpty());
        aqs.enqueue("radha");
        aqs.dequeue();
        aqs.dequeue();
        System.out.println(aqs.isEmpty());
    }
}
