package Sortings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ComparableInJava{
    private static class NotComparable{
        private int i;
        private NotComparable(final int i){
            this.i=i;
        }
    }

    public void sortNotComparable() {
        final List<NotComparable> objList= new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            objList.add(new NotComparable(i));
        }

        try{
            Arrays.sort(objList.toArray());
        } catch(Exception e){
            throw e;
        }   
    }

    public static void main(String[] args) {
        ComparableInJava j= new ComparableInJava();
        try{
            j.sortNotComparable();
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}