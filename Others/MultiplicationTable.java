package Others;
public class MultiplicationTable{
    public static void main(String[] args) {
        //printTable(14);
        printTableRecursive(14, 10);
    }

    private static void printTable(int n) {        
        for(int i=1;i<=10;i++){
            System.out.println(n +"*"+i+" = " +n*i);
        }
    }

    private static void printTableRecursive(int n,int times) { 
        if(times<=0){
            return;
        }
        printTableRecursive(n, times-1);
        System.out.println(n +"*"+times+" = " +n*times);
    }
}