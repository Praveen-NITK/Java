package org.practice.JavaConcepts;

import java.io.*;

public class SerializationDemo implements Serializable {
    private int size;
    private transient String name;
    public static void main(String[] args) {
        SerializationDemo sDemo= new SerializationDemo();
        sDemo.size=10;
        sDemo.name="Name";

        serializeTest(sDemo);
        SerializationDemo sDemo2=deserializeTest();
        System.out.println(sDemo2.toString());

    }

    private static void serializeTest(SerializationDemo sDemo) {
        try {
            FileOutputStream fileOutputStream=new FileOutputStream("/Users/praveen41.kumar/Desktop/serializationTest.txt");
            ObjectOutputStream objectOutputStream= new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(sDemo);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static SerializationDemo deserializeTest(){
        SerializationDemo sDemo;
        try {
            FileInputStream fileInputStream=new FileInputStream("/Users/praveen41.kumar/Desktop/serializationTest.txt");
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            Object o1=objectInputStream.readObject();
            sDemo=(SerializationDemo)o1;
            System.out.println(sDemo.name);
            System.out.println(sDemo.size);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return sDemo;
    }
}
