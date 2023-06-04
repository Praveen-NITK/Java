package Others;
// Write an algorithm that prints all numbers between 1 and n, replacing multiples
// of 3 with the String Fizz, multiples of 5 with Buzz, and multiples of 15 with
// FizzBuzz.
public class FizzBuzz{
    private static String getWord(int n, int divisor, String word){
        //for(int i=1; i<n;i++){
            // if(i%15==0){
            //     System.out.println(i+" FizzBuzz");
            // }
            // else if(i%3==0){
            //     System.out.println(i+" Fizz");
            // }
            // else if(i%5==0 ){
            //     System.out.println(i+" Buzz");
            // }      
        //}
        return (n%divisor==0)?word:"";
    }

    public static void main(String[] args) {
        for(int i=1; i<35;i++){
            System.out.println(i+" --> "+getWord(i, 3, "Fizz")+getWord(i, 5, "Buzz"));
        }
    }
}