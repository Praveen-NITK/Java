package test;

import java.util.LinkedList;
import java.util.Queue;

/*
T1   1
T2    2
T3    3
T4    4
T2    6
T1    5
T3    7
T4    8
T2   10
T1    9

Input  = n, x

N number of threads will be invoked.
N = 4
X = 10
X = number upto which the printing is to be done

Implement an LRU cache
n=3


 */
public class Test {
    static Queue<Integer> lruCache=new LinkedList<Integer>();
    static final int CACHE_SIZE=3;
    public static void main(String[] args) {

        processNumber(1);
        processNumber(2);
        processNumber(3);
        processNumber(2);

        printElements();

        processNumber(5);
        processNumber(2);
        processNumber(6);

        printElements();

    }
    //1,2,3 ->4
    //Processing Number in cache
    public static void processNumber(int number){
        if(lruCache.contains(number)){                  //If number is already there in cache, rearrange the order as recently used
            lruCache.remove(number);
        } else {                                        //If number is NOT present and cache is FULL then remove number from front,
            if (lruCache.size() >= CACHE_SIZE) {
                int removedNumber = lruCache.poll();
                System.out.println("removing from cache: " + removedNumber);
            }
        }
        lruCache.add(number);                           // INSERT the number in CACHE at last
    }

    //Print elemnts in cache
    private static void printElements(){
        for (int element:lruCache) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
