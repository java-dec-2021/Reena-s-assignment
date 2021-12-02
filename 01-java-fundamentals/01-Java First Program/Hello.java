                     public class Hello {
    public static void main(String[] args) {
       System.out.println("Hello Java People!!"); 

    //    Primitive data types
       byte myByte= 12;
       int myInt=672637354;
       float myFloat=72536734.672f;
       double mydouble=7634763.6376473647364;
       char myChar='c';
       boolean myBool=true;
    //    Non-Primitive data types   
    String firstName="Shane";
    firstName="Mya";
    String student="Mya";

    String lastName=new String("Jerry");
    System.out.println(firstName.length());
    welcome();
    welcome("Adam");  
    welcome("Hermine");
    System.out.println(evenOdd(39));
    oneTo255();
    }
    public static void welcome() {
        System.out.println("Welcome Ninja!");
    }
    public static void welcome(String firstName) {
        // System.out.println("Welcome " + firstName + " To java");
        System.out.printf("Welcome %s To Java\n",firstName);
    }
    public static String evenOdd(int number) {
        if (number%2==0) {
            return "Even";
            
        } else {
            return "Odd";
            //Looks awsome :) ~Sacha
        }
    }
    public static void oneTo255() {
        for(int i=1;i<=255;i++){
            System.out.println(i+ "is" +evenOdd(i));
            // if (i%2==0) {
            //    System.out.println(i + "Is even");
                
            // } else {
            //     System.out.println(i + "Is Odd");
            // }
        }
        
    }

    
}
