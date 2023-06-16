package org.practice.JavaConcepts;

import java.io.File;

public class DiskUsage {
    public static void main(String[] args) {
        long usage=calculateUsage(new File("/Users/praveen41.kumar/Desktop/MyJava"));
        System.out.println("usage is: "+usage);
    }

    private static long calculateUsage(File file) {
        long total=file.length();
        if(file.isDirectory()){
            for (String childName:file.list()){
                File child= new File(file,childName);
                total+=calculateUsage(child);
            }
            //another way
//            for (File childName:file.listFiles()){
//                total+=calculateUsage(childName);
//            }
        }
        return total;
    }
}
