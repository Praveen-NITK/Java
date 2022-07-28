package queue;

import java.util.Random;

public class PassingPillow {

    public static void main(String[] args) {
        String[] players={"A", "B", "C", "D", "E", "F", "G","H", "I"};
        System.out.println("Winner is: "+getWinner(buildQ(players),3));
    }

    private static <E> E getWinner(CircularQ<E> q, int i) {
        System.out.println("random sel is: "+i);
        if(q.isEmpty()) return null;
        while(q.size()>1){
            for (int j = 0; j <i-1 ; j++) {
                q.rotate();
//                q.enqueue(q.dequeue()); similar to rotate
            }
            E e= q.dequeue();
            System.out.println(" "+e+ " is out!");
        }
        return q.dequeue(); //Winner
    }

    private static <E> CircularQ<E> buildQ(E[] players) {
        CircularQ<E> cq= new LinkedCircularQ<>();
        for (int i = 0; i <players.length ; i++) {
            cq.enqueue(players[i]);
        }
        return cq;
    }
}
