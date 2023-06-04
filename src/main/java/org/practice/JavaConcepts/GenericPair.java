package JavaConcepts;

public class GenericPair<A,B> {
    A first;
    B second;
    public GenericPair(A a, B b){
        first=a;
        second=b;
    }
    public A getFirst(){return first;}
    public B getSecond(){return second;}

    public static void main(String[] args) {
        GenericPair<String, Integer> g= new GenericPair("ram", 2);
        System.out.println(g.getFirst());

        //This generic method cannot be applied to primitive arrays, because
        //autoboxing does not apply to entire arrays
        Integer[] input= {1,2,3,4,5,6};
        GenericDemo.reverse(input);
        for (int i:input)
            System.out.print(i+" ");

        System.out.println("=======");
        Sell[] sellPrice= new Sell[5];

        sellPrice[0]=new Sell(5);
        sellPrice[1]=new Sell(15);
        sellPrice[2]=new Sell(25);
        sellPrice[3]=new Sell(35);
        sellPrice[4]=new Sell(45);
        GenericDemo.reverseSellable(sellPrice);

        //GenericDemo.reverseSellable(input);  This will be error as Integer doesn't implements sellable interface

        for (Sell s:sellPrice)
            System.out.print(s.getTotalPrice()+" ");
    }
}

class GenericDemo{
    public static <T> void reverse(T[] data){
        int low=0, high=data.length-1;
        while(low<high){
            T temp= data[low];
            data[low++]=data[high];
            data[high--]=temp;
        }
    }

    public static <T extends Sellable> void reverseSellable(T[] data){
        int low=0, high=data.length-1;
        while(low<high){
            T temp= data[low];
            data[low++]=data[high];
            data[high--]=temp;
        }
    }

}

interface Sellable{
    public int getTotalPrice();
}

class Sell implements Sellable{
    int price;
    public Sell(int p){
        price=p;
    }
    @Override
    public int getTotalPrice() {
        return price;
    }
}