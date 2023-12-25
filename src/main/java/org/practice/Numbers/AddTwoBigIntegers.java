package org.practice.Numbers;


class AddTwoBigIntegers {
    public static void main(String[] args) {
        String result= addTwoBigIntegers("22,222","1,023"); // 222,22+320,1= 542,32 -> 23,245
        System.out.println("Sum is: "+result);
    }
    private static String addTwoBigIntegers(String firstNumber, String secondNumber){
        String total="";
        int n1= firstNumber.length();
        int n2= secondNumber.length();

        firstNumber=new StringBuilder(firstNumber).reverse().toString();
        secondNumber= new StringBuilder(secondNumber).reverse().toString();
        if(n2>n1){
            // Swapping
            String temp=firstNumber;
            firstNumber=secondNumber;
            secondNumber=temp;
        }
        int carry=0;
        for(int i=0; i <n2; i++){
            if(firstNumber.charAt(i)==','){
                i++;
                total+=",";
            }
            int sum = (firstNumber.charAt(i)-'0')+(secondNumber.charAt(i)-'0')+carry;
            carry=sum/10;
            total+=sum%10;
        }
        for(int i=n2; i <n1; i++){
            if(firstNumber.charAt(i)==','){
                i++;
                total+=",";
            }
            int sum = (firstNumber.charAt(i)-'0')+carry;
            carry=sum/10;
            total+=sum%10;
        }
        return new StringBuilder(total).reverse().toString();
    }
}