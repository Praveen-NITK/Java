package LinkedLists;

public class CircularLinkList<E> {
    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }
    }
    private Node<E> tail = null;
    private int size=0;

    public CircularLinkList(){ }

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public E first(){
        if(isEmpty())
            return null;
        return tail.next.element;
    }
    public E last(){
        if(isEmpty())
            return null;
        return tail.element;
    }
    public void rotate(){
        if(tail!=null)
            tail=tail.next;
    }
    public void addFirst(E e){
        if(size==0){
            tail=new Node<E>(e,null);
            tail.next=tail;
        }
        else
            tail.next=new Node<>(e,tail.next);
        size++;
    }
    public void addLast(E e){
        addFirst(e);
        tail=tail.next;
    }
    public E removeFirst(){
        if(isEmpty()) return null;
        Node<E> head=tail.next;
        if(head==tail) tail=null;
        else
            tail.next=head.next;
        size--;
        return head.element;
    }

    public static void main(String[] args) {
        CircularLinkList cl= new CircularLinkList();
        cl.addFirst(5);
        cl.addLast("her");
        cl.addLast(4.5);
        cl.addLast(true);
        //cl.rotate();
//        while (cl.size()>0)
//            System.out.println(cl.removeFirst());

        reverseLL(cl);

        while (cl.size()>0)
            System.out.println(cl.removeFirst());
    }

    private static void reverseLL(CircularLinkList cl) {
        int l=cl.size();
        Node prev=cl.tail;
        Node curr=cl.tail.next;
        Node next;
        do{
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            l--;
        }while(l>0);
        cl.tail=next;
    }
}
