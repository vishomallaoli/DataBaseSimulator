import java.util.ArrayList;
public class Branch {
    /**
     * Data Fields
     */
    private String branchLocation; // branch location
    private int branchYearOpening; // year the branch opened
    private ArrayList<Employee> branchOfEmployees; // array list of employees

    /**
     * Objects
     */
    Employee currentEmployee = new Employee();

    /**
     * Constructors
     */
    public Branch(){
        branchLocation = "";
        branchYearOpening = 0;
        branchOfEmployees = new ArrayList<>();
    }
    public Branch(String branchLocation, int branchYearOpening){
        this.branchLocation = branchLocation;
        this.branchYearOpening = branchYearOpening;
        branchOfEmployees = new ArrayList<>();
    }

    /**
     * Mutator Methods
     */
    public void setBranchLocation(String branchLocation){
        this.branchLocation = branchLocation;
    }
    public void setBranchYearOpening(int branchYearOpening){
        this.branchYearOpening = branchYearOpening;
    }

    /**
     * Accessor Methods
     */
    public String getBranchLocation(){
        return branchLocation;
    }
    public int getBranchYearOpening(){
        return branchYearOpening;
    }
    public ArrayList<Employee> getBranchOfEmployees(){
        return branchOfEmployees;
    }
    public int getNumberOfEmployees(){
        return branchOfEmployees.size();
    }
    public Employee getCurrentEmployee(int index){
        return branchOfEmployees.get(index);
    }
    public void removeCurrentEmployee(int index){
        branchOfEmployees.remove(index);
    }


    /**
     * toString method
     */
    public String toString(){
        return String.format("BRANCH\t\t: %10s\nOPENING YEAR: %10d", getBranchLocation(),getBranchYearOpening());
    }

    /**
     * Add employees method
     */
    public void addEmployees(String employeeName, String employeePosition, int employeeSalary){
        branchOfEmployees.add(new Employee(employeeName, employeePosition, employeeSalary));
    }
}
