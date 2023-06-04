package AlgorithmsBook;

// In a set of components check if they are connected or not?

import java.util.ArrayList;
import java.util.List;

//https://cuvids.io/app/video/97/watch
//These are used for digital photos, where the objects are pixels they're used for networks,
// where the objects are computers, social networks, where it's people, or computer chips,
// where it's circuit elements or abstract things like variable names in a program, or elements in a mathematical set,
// or physical things like metallic sites in a composite system. So, all different types of objects for,
// but for programming we're going to associate each object with a name and we'll just name the objects with a number, integers from zero to n-1.
public class QuickFind extends UnionFind {


    public QuickFind(int n) {
        super(n);
    }

    //Find is simpler here
    public boolean isConnected(int p, int q){
        return compoArr[p]==compoArr[q];
    }

    //Union is timetaking O(n)
    public void union(int p, int q){
        int p_val= compoArr[p];
        int q_val= compoArr[q];
        for (int i = 0; i < N; i++) {
            if(compoArr[i]==p_val) compoArr[i]=q_val;
        }
    }

    public static void main(String[] args) {
        int N= 10;


        QuickFind uf= new QuickFind(N);

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
