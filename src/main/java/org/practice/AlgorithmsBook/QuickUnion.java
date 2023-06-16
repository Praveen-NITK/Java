package org.practice.AlgorithmsBook;

// In a set of components check if they are connected or not?

//https://cuvids.io/app/video/97/watch
//These are used for digital photos, where the objects are pixels they're used for networks,
// where the objects are computers, social networks, where it's people, or computer chips,
// where it's circuit elements or abstract things like variable names in a program, or elements in a mathematical set,
// or physical things like metallic sites in a composite system. So, all different types of objects for,
// but for programming we're going to associate each object with a name and we'll just name the objects with a number, integers from zero to n-1.
public class QuickUnion extends UnionFind {


    public QuickUnion(int n) {
        super(n);
    }

    //Find is timetaking here
    public boolean isConnected(int p, int q){
        return getRoot(p)==getRoot(q);
    }

    //chase parent pointer until reach root
    public int getRoot(int i){
        while(compoArr[i]!=i)
            i=compoArr[i];
        return i;
    }

    //Union is simpler
    //change root of p to point to root of q;
    public void union(int p, int q){
        int i= getRoot(p);
        int j= getRoot(q);
        compoArr[i]=j;
    }

    public static void main(String[] args) {
        int N= 10;


        QuickUnion uf= new QuickUnion(N);

        for (Component c:componentList) {
            int p= c.first;
            int q= c.second;
            if(!uf.isConnected(p,q)){
                uf.union(p,q);
                System.out.println(p+" "+q);
            }
            else
                System.out.println("already connected "+p+" "+q);
        }
    }

}
