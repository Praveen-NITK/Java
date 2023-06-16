package org.practice.file;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class ExtractFile {
    public static void main(String[] args) {
        File path = new File("C:\\Users\\Admin\\Desktop\\practiceOn\\src\\main\\java\\org\\practice");
        Stack<File> fileStack = new Stack<>();
        fileStack.add(path);
        int counter=0;

//        while (!fileStack.isEmpty()){
        while (counter<5){
            File f= fileStack.pop();
            if (f.isFile()){
                try {
//                    OutputStream os = new FileOutputStream(new File(f.getPath()), false);
//                    os.write("org.practice.".getBytes(), 0, "org.practice.".length());
//                    os.close();
                    // An array to store each line in the file
                    ArrayList<String> fileContent = new ArrayList<String>();
                    Scanner myReader = new Scanner(f);
                    while (myReader.hasNextLine()) {
                        // Reads the file content into an array
                        fileContent.add(myReader.nextLine());
                    }
                    myReader.close();
                    String s= fileContent.get(0);
                    String temp=s.split(" ")[1];
                    fileContent.remove(0);
                    fileContent.add(0,"package org.practice."+temp);
                    // Writes the new content to file
                    FileWriter myWriter = new FileWriter(f);
                    for (String eachLine : fileContent) {
                        myWriter.write(eachLine + "\n");
                    }
                    myWriter.close();
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
            counter++;
        }
    }
}
