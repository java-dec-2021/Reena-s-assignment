import java.util.ArrayList;

public class Employee {

    // Access modifiers
    // Attributes
    private String email;
    private float pay;
    private ArrayList<String> projects=new ArrayList<>();
    private Employee manager;

    // Static member 
    private static int noOfEmp=0;
    // Constructor
    public Employee(){
        noOfEmp++;
        
    }
    public Employee(String email, float pay){
        noOfEmp++;
        this.email=email;
        this.pay=pay;
    }
    public Employee(String email, float pay, Employee manager){
        noOfEmp++;
        this.email=email;
        this.pay=pay;
        this.manager=manager;
    }

    // Accessors/getters & Mutators/setters
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    public void setPay(float pay) {
        this.pay = pay;
    }
    public float getPay() {
        return pay;
    }

    // Class methods
    public void displayInfo() {
        System.out.printf("Email: %s, Pay: %f\n", this.email,this.pay);

        System.out.println("These are my projects" + this.projects);
        
    }
    // Method Overloading - polymorphism
    public void bonus(){
        this.pay+=1000;
    }
    public void bonus(float amount){
        this.pay+=amount;
    }
    // Static methods
    public static int getNoOfEmp() {
        return noOfEmp;
    }

    public void assignProject(String project) {
        
        this.projects.add(project);
        
        
    }
    // How objects talk to each other 
    public void assignManager(Employee manager) {
        this.manager=manager;
    }
    public Employee getManager() {
        return manager;
    }


}
