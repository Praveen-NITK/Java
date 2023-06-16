package org.practice.Hash;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

//https://www.geeksforgeeks.org/hashing-in-java/
//https://www.geeksforgeeks.org/convert-an-array-to-reduced-form-set-1-simple-and-hashing/
//https://www.geeksforgeeks.org/top-20-hashing-technique-based-interview-questions/
//https://www.geeksforgeeks.org/hashing-set-3-open-addressing/
public class HashInJava{    
    
    public static void main(String[] args) {
        //hashTableDemo();
        int []arr=new int[]{3,4,2,4,5,6,3};
        CountNumberofTimes(arr); //uses Hashmap
        //createLinkedHashMap(arr);//Preserves the order
        //createConcurrentHashMap(arr);
        //createHashSet(arr);
        //createTreeSet();
        combineHashMap();
    }

    private static void combineHashMap() {
        HashMap map=new HashMap();
        map.put("data1","abc");
        map.put("data2",100.0);
        System.out.println(map.toString());
    }

    private static void createTreeSet() {
        TreeSet<String> tSet=new TreeSet<>();
        tSet.add("B");
        tSet.add("A");
        tSet.add("cab");
        tSet.add("bac");
        System.out.println(tSet.pollFirst());
        System.out.println(tSet.higher("bac"));
    }

    private static void createHashSet(int[] arr) {
        HashSet<String> hSet= new HashSet<>();
        hSet.add("hello");
    }

    private static void createConcurrentHashMap(int[] arr) {
        ConcurrentHashMap<Integer, String> cHashMap= new ConcurrentHashMap<>();
        cHashMap.put(100, "Hello");
        cHashMap.put(101, "Hi");
        cHashMap.put(102, "how r u");
        cHashMap.putIfAbsent(101, "good");       

        System.out.println(cHashMap);
    }

    private static void createLinkedHashMap(int[] arr) {
        LinkedHashMap<Integer,Integer> lhmap= new LinkedHashMap<>();
        for (int var : arr) {
            Integer _value= lhmap.get(var);
            if(_value==null){
                lhmap.put(var, 1);
            }
            else{
                lhmap.put(var, ++_value);
            }
        }
        System.out.println(lhmap);
    }

    private static void CountNumberofTimes(int[] arr) {
        
        HashMap<Integer, Integer> hmap= new HashMap<>();

        for(int i=0; i<arr.length;i++){
            Integer val=hmap.get(arr[i]);
            if(hmap.get(arr[i])==null){
                hmap.put(arr[i], 1);
            }
            else{
                hmap.put(arr[i], ++val);
            }
        }
        System.out.println(hmap);
    }

    private static void hashTableDemo() {
        Hashtable<Integer,String> htable= new Hashtable<>(1);

        htable.put(3,"hello");
        htable.put(2, "how");
        htable.put(4, "r you");

        System.out.println(htable);
    }
}
