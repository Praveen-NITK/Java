package org.practice.ZJio;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class test {
    public static DecimalFormat decimalFormat = new DecimalFormat("#.##");

    public static void main(String[] args) {
//        Double d= (double)1;
//        System.out.println(String.format("%.2f",d).length());
//        System.out.println(String.format("%.2f",d));

//        Integer sc = 123;
//        String num = sc.toString();
//        System.out.println(num);
////        2013.07
//
//        Double grossAmount = new Double(0);
//        grossAmount = Double.sum(2013.07, 85);
//        System.out.println(grossAmount);
//        boolean is=Double.compare(grossAmount , 2098.07) == 0;
//        System.out.println(is);

//        List<String> schemes= new ArrayList<>();
////        schemes.add("110");
////        schemes.add("112");
////        schemes.add(null);
//        Integer scheme=112;
//        if(schemes.contains(String.valueOf(scheme))){
//            System.out.println("exists");
//        }
//        else
//            System.out.println("not exists");

//        System.out.println( Double.parseDouble(decimalFormat.format(.35900000000001)));
        Set<Integer> intSet=new HashSet<>();
        //intSet.add(2);
        for (int i:intSet){
            System.out.println(i);
        }
    }
}
