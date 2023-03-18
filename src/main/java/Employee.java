public class Employee {
    /**
     * Data Fields
     */
    private String employeeName; // employee name
    private String employeePosition; // employee position
    private int employeeSalary; // salary of employee

    /**
     * Constructors
     */
    public Employee(){
        employeeName = "";
        employeePosition = "";
        employeeSalary = 0;
    }
    public Employee(String employeeName, String employeePosition, int employeeSalary){
        this.employeeName = employeeName;
        this.employeePosition = employeePosition;
        this.employeeSalary = employeeSalary;
    }

    /**
     * Mutator Methods
     */
    public void setEmployeeName(String employeeName){
        this.employeeName = employeeName;
    }
    public void setEmployeePosition(String employeePosition){
        this.employeePosition = employeePosition;
    }
    public void setEmployeeSalary(int employeeSalary){
        this.employeeSalary = employeeSalary;
    }

    /**
     * Accessor Methods
     */
    public String getEmployeeName(){
        return employeeName;
    }
    public String getEmployeePosition(){
        return employeePosition;
    }
    public int getEmployeeSalary(){
        return employeeSalary;
    }

    /**
     * Other methods
     */
    public String toString(){
        return String.format("%27s %39s %,19d$", getEmployeeName(),getEmployeePosition(),getEmployeeSalary());
    }
}
