package org.practice.Strings;

public class Padding {
    public static void main(String[] args) {
        if(false) {
            String num = String.format("%02d", 129);
            System.out.println(num);
            Double original_netAmount = 9448.1;
            Double refund_net_amount = 1438.1;
            Double original_refunded_amount = 8009.2;
            Double sum = refund_net_amount.doubleValue() + original_refunded_amount; //-> 9447.3
            System.out.println(1438.1 + 8009.2); //->9447.3

//        1438.2+8009.1 = 9447.300000000001;
//        1438.1+8009.2 = 9447.3;
            //9447.3<9447.300000000001

            if (original_netAmount < refund_net_amount + original_refunded_amount)
                System.out.println("Error");
        }
        else {
            int x=0;
            while(x<10) {
                System.out.println("Darsh accha ladka nahi hai");
                x++;
            }
        }
    }
}
