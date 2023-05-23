package AlgorithmsBook.stack;

//Linked list implementation of Stack
public class LinkedStackOfStrings implements StackImplementation<String> {
    private class Node{
        String item;
        Node next;
        public Node(String s){
            this.item=s;
            next=null;
        }
    }
    Node first=null;

    public void push(String s){
        Node olderFirst= first;
        first=new Node(s);
        first.next=olderFirst;
    }
    public void pop(){
        System.out.println(first.item);
        first=first.next;
    }
    public boolean isEmpty(){
        return first==null;
    }

    public static void main(String[] args) {
        LinkedStackOfStrings s =new LinkedStackOfStrings();
        s.push("ram");
        s.push("mohan");
        s.pop();
        System.out.println(s.isEmpty());
        s.push("radha");
        s.pop();
        s.pop();
        System.out.println(s.isEmpty());
    }

}
