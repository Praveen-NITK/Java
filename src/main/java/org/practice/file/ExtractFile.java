package org.practice.file;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
//Please Dont run this class
public class ExtractFile {
    public static void main(String[] args) {
        //File path = new File("C:\\Users\\Admin\\Desktop\\practiceOn\\src\\main\\java\\org\\practice");
        File path = new File("");
        Stack<File> fileStack = new Stack<>();
        fileStack.add(path);
//        int counter=0;

        while (!fileStack.isEmpty()){
//        while (counter<5){
            File f= fileStack.pop();
            if (f.isFile() && f.getName().contains(".java")){
                try {
                    ArrayList<String> fileContent = new ArrayList<String>();
                    Scanner myReader = new Scanner(f);
                    while (myReader.hasNextLine()) {
                        // Reads the file content into an array
                        fileContent.add(myReader.nextLine());
                    }
                    myReader.close();
                    String s= fileContent.get(0);
                    String temp = "";
                    if(s!=null && !s.isEmpty() && s.startsWith("package")) {
                        String[] arr = s.split(" ");

                        if (arr.length > 1)
                            temp = arr[1];

                        fileContent.remove(0);
                        fileContent.add(0, "package org.practice." + temp);
                        // Writes the new content to file
                        FileWriter myWriter = new FileWriter(f);
                        for (String eachLine : fileContent) {
                            myWriter.write(eachLine + "\n");
                        }
                        myWriter.close();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("\t"+f.getName());
            }
            else if(f.isDirectory()){
                System.out.println(f.getName()+"->");
                for (File subFile:f.listFiles()) {
                    fileStack.push(subFile);
                }
            }
//            counter++;
        }
    }
}
