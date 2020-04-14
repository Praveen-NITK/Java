package Others;
class A{
    int a;
    int b;
    int c;

}
class B extends A{
    int b;
    int c;
    int d;
}

public class Inheritance{
    public static void main(String[] args) {
        A oa= new A();
        oa.a=10;
        oa.b=20;
        oa.c= 30;

        B ob = new B();
        ob.a=15;
        ob.c=35;
        ob.d= 40;

        A oc= new B();
        oc.a=18;
        oc.b=28;
        //oc.d=25; //d cannot be resolved or is not a field

        //B od= new A();  //Type mismatch: cannot convert from A to B
        //od.a=19;
        // od.c=39;
        // od.d=49;

        System.out.println("oa");
        System.out.println(oa.a+" ");
        System.out.println(oa.b+" ");
        System.out.println(oa.c+" ");

        System.out.println("ob");
        System.out.println(ob.a+" ");
        System.out.println(ob.b+" ");
        System.out.println(ob.c+" ");
        System.out.println(ob.d+" ");

        System.out.println("oc");
        System.out.println(oc.a+" ");
        System.out.println(oc.b+" ");
        System.out.println(oc.c+" ");

        //System.out.println(od.a);
        // System.out.print(od.b);
        // System.out.print(od.c);
        // System.out.print(od.d);
    }
}