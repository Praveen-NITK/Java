//https://www.geeksforgeeks.org/lambda-expressions-java-8/
// Lambda expressions basically express instances of functional interfaces 
// (An interface with single abstract method is called functional interface. An example is java.lang.Runnable). 
// lambda expressions implement the only abstract function and therefore implement functional interfaces

// lambda expressions are added in Java 8 and provide below functionalities.

// Enable to treat functionality as a method argument, or code as data.
// A function that can be created without belonging to any class.
// A lambda expression can be passed around as if it was an object and executed on demand.

package JavaConcepts.Lambda;
public class LambdaExpression{

    public static void greet(Greeting greeting){
        greeting.perform();
    }

    public static void main(String[] args) {
        //Lamda expression is nothing but the anonymous inner calss implementation
        Greeting lambdaGreeting= () ->System.out.println("Hello World!");

        Greeting anonymousInnerClassGreeting=new Greeting(){        
            @Override
            public void perform() {
                System.out.println("Hello World!");
            }
        };



        //lambdaGreeting.perform();
        //anonymousInnerClassGreeting.perform();

        greet(lambdaGreeting);
        greet(anonymousInnerClassGreeting);

        //===========================================
        //Single argument lambda can be written as any of this way
        //StringLambda myLambda=(String s)->s.length();
        //StringLambda myLambda=(s)->s.length();
        StringLambda StringLambda=s->s.length();
        System.out.println(StringLambda.getLenth("Hello World!"));      

        
        //Directly passing lambda
        printLambdaInline(s->s.length()*2);

    }   

    public static void printLambdaInline(StringLambda l){
        System.out.println(l.getLenth("Hello World!"));
    }
}

interface Greeting{
    void perform();
}
interface StringLambda{
    int getLenth(String s);
}