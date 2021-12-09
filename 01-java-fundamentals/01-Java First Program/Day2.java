import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
public class Day2 {
    HashMap<String, String> foodies = new HashMap<String, String>();
   public static void main(String[] args) {

    int[] numbers=new int[5];
    // numbers[0]=10;
    // numbers[1]=20;

    // For Loop
    for (int i = 0; i < numbers.length; i++) {
        numbers[i]=i*10;
    }
    System.out.println(numbers);
    // For Each
    for(int val : numbers) {
        System.out.println(val);
    }
    numbers[0]=100;
    System.out.println(Arrays.toString(numbers));

    String[] students={"Ola","Sam","Sacha"};
    try{
        students[3]="Shane";
    }
    catch(Exception e){
        System.out.println(e.toString());
        System.out.println("Hey, don't try this!!!");
    }
    System.out.println(Arrays.toString(students));

    // ArrayList
    ArrayList<Integer> myNumbers=new ArrayList<Integer>();
    myNumbers.add(100);
    myNumbers.add(900);
    myNumbers.remove(0);   
    System.out.println(myNumbers);

    // Hashmap
    HashMap<String, String> foodies = new HashMap<String, String>();
    foodies.put("Reena","Samosas");
    foodies.put("Harpreet","Dosas");
    foodies.put("Sam","Hashbrown");
    foodies.put("Erwin","Burritos");
    foodies.put("Ola","Fish");
    foodies.put("Sacha","Smoothies");
    foodies.put ("Hermine", "Kabab");
    foodies.put("Erwin","Tikka");
    foodies.put("Kevin","Gyros");
    foodies.put("David","sausage");
    foodies.put("Erwin","Burritos");
    foodies.put("Brian","Lamb curry");
    foodies.put("Claude","Pizza");
    foodies.put("Esra","Pizza");

    System.out.println(foodies.get("Erwin"));
    System.out.println(foodies.toString());
    for (String k : foodies.keySet()) {
        System.out.println(k +" : " + foodies.get(k));
    }
    for (String val : foodies.values()) {
        System.out.println(val);
    }












  
      
   } 
}
