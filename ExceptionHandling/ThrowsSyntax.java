package ExceptionHandling;
public class ThrowsSyntax{
    
    public static int devideByNumber(int diviser, int divident) throws Exception{
        if(diviser==0)
            throw new ArithmeticException("Number must not be 0");
        return divident/diviser;
    }

    
    public static void main(String[] args) throws Exception {
        try {
            int result= devideByNumber(0,30);
            System.out.println("Result is: "+result);
        } catch (Exception e) {
            System.out.println("Exception: "+e.getMessage());
        }
        
        
    }
}