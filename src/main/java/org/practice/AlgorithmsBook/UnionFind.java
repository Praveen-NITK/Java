package org.practice.AlgorithmsBook;

// In a set of components check if they are connected or not?

import java.util.ArrayList;
import java.util.List;
//https://cuvids.io/app/video/97/watch
//These are used for digital photos, where the objects are pixels they're used for networks,
// where the objects are computers, social networks, where it's people, or computer chips,
// where it's circuit elements or abstract things like variable names in a program, or elements in a mathematical set,
// or physical things like metallic sites in a composite system. So, all different types of objects for,
// but for programming we're going to associate each object with a name and we'll just name the objects with a number, integers from zero to n-1.
public abstract class UnionFind {
    
    int N;
    static int compoArr[];
    static List<Component> componentList;
    public UnionFind(int n){
        this.N=n;
        compoArr = new int[N];

        for (int i = 0; i < N; i++) {
            compoArr[i]=i;
        }


        componentList = new ArrayList<>();
        componentList.add(new Component(4,3));
        componentList.add(new Component(3,8));
        componentList.add(new Component(6,5));
        componentList.add(new Component(9,4));
        componentList.add(new Component(2,1));
        componentList.add(new Component(8,9));
        componentList.add(new Component(5,0));
        componentList.add(new Component(7,2));
        componentList.add(new Component(6,1));
        componentList.add(new Component(1,0));
        componentList.add(new Component(6,7));
    }


    //Find
    public abstract boolean  isConnected(int p, int q);

    public abstract void union(int p, int q);

    
    static class Component{
        int first;
        int second;
        public Component(int p, int q){
            first=p;
            second=q;
        }
    }

}
