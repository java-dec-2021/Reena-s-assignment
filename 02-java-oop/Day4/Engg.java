public class Engg extends Employee{

    private String project;

    public Engg(String email, double pay, String project) {
        super(email, pay);
        //TODO Auto-generated constructor stub
        this.project=project;
    }
    public String getProject() {
        return project;
    }
    public void setProject(String project) {
        this.project = project;
    }
    public void eggDetails() {
        this.empDetails();
        System.out.println("I am working on : " + this.project);
        
    }


    
}
