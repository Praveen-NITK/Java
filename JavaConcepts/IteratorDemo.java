package JavaConcepts;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class IteratorDemo {
    public static void main(String[] args) {
        List<Double> stList= Arrays.asList(new Double[]{2.3,5.7,2.5,-1.4,-4.6});
        Iterator<Double> walk= stList.iterator();
        while (walk.hasNext()){
            if(walk.next()<0.0)
                walk.remove();
        }
        System.out.println("stList.size()");
    }
}
