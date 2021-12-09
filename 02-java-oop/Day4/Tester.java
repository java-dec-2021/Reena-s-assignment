import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) {
       Employee mya=new Employee("Maya@chimp.com",300000);
       mya.empDetails();

       Engg steven=new Engg("s@chimp.com",250000,"Make Cookies");
       steven.empDetails();
       steven.eggDetails();

       Lion simba=new Lion();
       simba.sleep();
       simba.eat();
       simba.threatening();

       Rabbit bugs=new Rabbit();
       bugs.eat();
       bugs.sleep();
       bugs.breath();

       ArrayList<Animal> animals=new ArrayList<Animal>(); 
       animals.add(simba);
       animals.add(bugs);
       System.out.println(animals);

       Human kevin=new Human();
       kevin.Attack();
       



      
    }
 }