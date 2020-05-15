//Two robot landed on two hot points
// four inbuilt functions allowed right(), left(), isMet(), isHotPoint()

// public static void robotExecute(){        
//     while(!isMet() && !isHotPoint()){
//         right();            
//     }
//     right();
//     right();
// }

package Others;
public class RobotMeet{
    static class Robot{
        String name;
        int location;
        Robot(int loc, String n){
            location=loc;
            name=n;
        }
    }
    static Robot r1= new Robot(5, "R1");
    static Robot r2= new Robot(10, "R2");
    public static void main(String[] args) {        

        Thread t1 = new Thread(new Runnable(){        
            @Override
            public void run() {
                right(r1);
                robotExecute(r1);
                
            }
        });

        Thread t2 = new Thread(new Runnable(){        
            @Override
            public void run() {
                right(r2);
                robotExecute(r2);
                
            }
        });

        t2.start();
        t1.start();       
        
    }

    public static void robotExecute(Robot r){
        System.out.println(r.name+" Executing ");      
        
        while(!isMet() && !isHotPoint(r.location)){
            System.out.println("Current position: "+r1.location+" "+r2.location);
            right(r);            
        }
        right(r);
        right(r);
    }

    private static void right(Robot r) {
        r.location++;
        System.out.println(r.name+" moving one right");
    }

    private static boolean isHotPoint(int position) {
        return (position ==5 || position==10);       
        
    }

    private static boolean isMet() {
        if( r1.location==r2.location){
            System.out.println("met!! at position "+r1.location);
            System.exit(0);
            return true;
        }
        else{
            System.out.println("dint met!! ");
            return false;
        }
    }
}
