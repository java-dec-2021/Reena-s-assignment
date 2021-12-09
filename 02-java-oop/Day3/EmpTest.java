public class EmpTest {
    public static void main(String[] args) {
        System.out.println("Let's learn OOP!");
        Employee bryton=new Employee();
        // bryton.email="b@chimp.com";
        // bryton.pay=150000;

        bryton.setEmail("b@chimp.com");
        // System.out.println( bryton.getEmail());
        bryton.setPay(150000);
        bryton.displayInfo();

        Employee ola=new Employee();
        // bryton.email="b@chimp.com";
        // bryton.pay=150000;
        ola.setEmail("o@chimp.com");
        ola.setPay(200000);
        

        Employee sacha=new Employee("s@chimp.com",300000);
        sacha.setPay(3500000);
        sacha.displayInfo();
        bryton.bonus();
        ola.bonus();
        sacha.bonus();
        ola.bonus(5000);
        ola.displayInfo();

        Employee harmine=new Employee("h@chimp.com",10000000);
        
        System.out.println(Employee.getNoOfEmp());
        harmine.assignProject("Collect Bananas");
        harmine.assignProject("Make Chips");
        harmine.displayInfo();

        bryton.assignProject("Throw Bananas");
        harmine.assignManager(sacha);
        bryton.displayInfo();
        System.out.println(harmine.getManager().getEmail());
        


       





















    }
    
}
