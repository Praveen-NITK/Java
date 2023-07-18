package org.practice.cache;

import java.util.LinkedList;
import java.util.Queue;

public class LRUCache {
    static Queue<Integer> cache= new LinkedList<>();
    static final int CACHE_SIZE=5;

    private  static void getElementFromCache(int x){
        int result;
        if(cache.contains(x)){
            putElementIntoCache(x);
            result= x;
        }
        else
            result= -1;
        System.out.println("getElement: "+result);
    }

    private static void putElementIntoCache(int x){
        if(!cache.contains(x)){
            if(cache.size()==CACHE_SIZE) {
                int removedNumber = cache.poll();
                System.out.println("removing " + removedNumber);
            }
        }
        else {
            cache.remove(x);
        }
        cache.add(x);


    }
    private static void printElements(){
        for (int element:cache) {
            System.out.print(element + " ");
        }
    }

    public static void main(String[] args) {
        putElementIntoCache(1);
        putElementIntoCache(2);
        putElementIntoCache(3);
        putElementIntoCache(4);
        putElementIntoCache(5);

        putElementIntoCache(3);

//        putElementIntoCache(7);
//        getElementFromCache(1);
//        getElementFromCache(3);
//
//        putElementIntoCache(6);

//        getElementFromCache(1);
//
//        putElementIntoCache(3);

        printElements();

    }
}
