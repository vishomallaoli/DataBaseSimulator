import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Business {
    /**
     * Data Fields
     */
    private String businessName; // business name
    private ArrayList<Branch> businessOfBranch; // array list of branches

    /**
     * Objects
     */
    Branch currentBranch = new Branch();

    /**
     * Constructors
     */
    public Business() {
        businessName = "";
        businessOfBranch = new ArrayList<>();
    }

    public Business(String businessName) {
        this.businessName = businessName;
        businessOfBranch = new ArrayList<>();
    }

    /**
     * Mutator Methods
     */
    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    /**
     * Accessor Methods
     */
    public String getBusinessName() {
        return businessName;
    }

    public ArrayList<Branch> getBusinessOfBranch() {
        return businessOfBranch;
    }

    public int getNumberOfBranches() {
        return businessOfBranch.size();
    }

    public Branch getCurrentBranch(int index) {
        return businessOfBranch.get(index);
    }

    public void removeCurrentBranch(int index) {
        businessOfBranch.remove(index);
    }

    /**
     * Branch adding method
     */
    public void addBranch(String branchName, int branchYearOpening){
        businessOfBranch.add(new Branch(branchName, branchYearOpening));
    }

    /**
     * File Reader
     */
    public void filesReader(String filepath) throws FileNotFoundException {
        Scanner lineScanner = new Scanner(new File(filepath)); // scanner and file objects
        int index = -1;
        while (lineScanner.hasNextLine()) {
            String line = lineScanner.nextLine();
            String[] tokenArray = line.trim().split(",");

            if (tokenArray.length == 2) {
                index++;
                businessOfBranch.add(new Branch(tokenArray[0], Integer.parseInt(tokenArray[1])));
            }
            if (tokenArray.length == 3) {
                businessOfBranch.get(index).addEmployees(tokenArray[0], tokenArray[1], Integer.parseInt(tokenArray[2]));
            }
        }
        lineScanner.close();
    }

    /**
     * Display Method
     */
    public void businessInformation() {
        System.out.print("Current Company Name: ");
        System.out.println(getBusinessName());
        for (int outer = 0; outer < getNumberOfBranches(); outer++) {
            System.out.printf("--------------------------------Branch %d-------------------------------------------------", outer + 1);
            System.out.println();
            System.out.println(businessOfBranch.get(outer).toString());

            System.out.println("\t\t\t(EMPLOYEE NAME)\t\t\t\t\t\t(EMPLOYEE POSITION)\t\t(EMPLOYEE SALARY)");
            for (int inner = 0; inner < getBusinessOfBranch().get(outer).getNumberOfEmployees(); inner++) {
                System.out.println(inner + 1 + businessOfBranch.get(outer).getBranchOfEmployees().get(inner).toString());
            }
        }
    }
    /**
     * GoodBye Method
     */
    public void goodBye(){
        System.out.println("█████████████████████████████████████\n" +
                "███████▀█████████████████████████████\n" +
                "██████░░█████████████████████████████\n" +
                "█████▀░▄█████████████████████████████\n" +
                "█████░░▀▀▀▀▀███▀▀█████▀▀███▀▀▀▀▀█████\n" +
                "█████░░▄██▄░░███░░███░░███░░███░░████\n" +
                "████░░█████░░███░▄███░░██░░▀▀▀░▄█████\n" +
                "████░░████▀░███░░███▀░███░░██████████\n" +
                "████░░█▀▀░▄████▄░▀▀▀░▄███▄░▀▀▀░▄█████\n" +
                "█████▄▄▄███████████░░██████▄▄████████\n" +
                "██████████████░▀█▀░▄█████████████████\n" +
                "███████████████▄▄▄███████████████████\n" +
                "█████████████████████████████████████");
        System.exit(0);
    }

    /**
     * Modification Method
     */
    public void changesInBusiness(){
        System.out.println(); // line change

        System.out.println("Do you want to make changes to the employee list?:\n"
                + "1: To 'change' the business, any branch, or any employee\n"
                + "2: To 'display' any recent changes made\n"
                + "0: To 'exit' the program");

        Scanner userInput = new Scanner(System.in);
        System.out.print("\nEnter you choice: ");
        int userChoice = userInput.nextInt(); // input regarding decision structure.

        if (userChoice == 1){
            System.out.println("Choose the option that best fits the change you want to make.\n"
                    + "1 : Make changes to the business\n"
                    + "2 : Make changes to a branch\n"
                    + "3 : Make changes to an employee\n"
                    + "0 : Exit the program");
            /**
             * Decision structures for each type of change.
             */
            System.out.print("\nChoose your choice: ");
            int decisionCoin = userInput.nextInt();
            if (decisionCoin == 1){
                /**
                 * Changes to the business
                 */
                System.out.println("Choose the option that best fits the change you want to make.\n"
                        + "1 : Change the name of the business\n"
                        + "0 : Exit the program");
                System.out.print("\nChoose you choice: ");
                int innerChoice = userInput.nextInt();
                String newBusinessName = userInput.nextLine();
                setBusinessName(newBusinessName); System.out.println(); // new line
                // choices
                if (innerChoice == 1){
                    System.out.print("Enter a new business name: ");
                    businessName = userInput.nextLine();
                    System.out.printf("The {business name} has been changed to %s.", getBusinessName());
                }
                else if (innerChoice == 0){
                    goodBye();
                }
            }
            else if (decisionCoin == 2){
                Scanner userInnerInput = new Scanner(System.in); // scanner for this decision structure.
                /**
                 * Changes to a branch
                 */
                System.out.println("Choose the option that best fits the change you want to make.\n"
                        + "1 : Change a current {branch} location\n"
                        + "2 : Change a current {branch} year opening\n"
                        + "3 : Open a new {branch}\n"
                        + "4 : Close a current {branch}\n"
                        + "0 : Exit the program");

                System.out.print("\nChoose your choice: ");
                int innerChoice = userInput.nextInt();
                // choices
                if (innerChoice == 1){
                    System.out.print("Enter the branch number you want to change: ");
                    int index = userInput.nextInt();
                    System.out.printf("Enter the new branch location you want instead of {%s} branch: ", getBusinessOfBranch().get(index - 1).getBranchLocation());
                    String choice = userInnerInput.nextLine();
                    getBusinessOfBranch().get(index - 1).setBranchLocation(choice);
                    System.out.println(); // change line
                }
                else if (innerChoice == 2){
                    System.out.print("Enter the branch number you want to change: ");
                    int index = userInput.nextInt();
                    System.out.printf("Enter the branch year opening correction instead for {%s} branch: ", getBusinessOfBranch().get(index - 1).getBranchLocation());
                    int choice = userInnerInput.nextInt();
                    getBusinessOfBranch().get(index - 1).setBranchYearOpening(choice);
                    System.out.println(); // new line
                }
                else if (innerChoice == 3){
                    /**
                     * Opening a new branch.
                     */
                    // branch attributes
                    System.out.print("Enter the location for the {branch}: ");
                    String newBranchName = userInnerInput.nextLine();

                    System.out.print("Enter the opening year of {" + newBranchName + "}: ");
                    int newBranchYearOpening = userInnerInput.nextInt();

                    // opening a new branch methods
                    addBranch(newBranchName,newBranchYearOpening);
                }
                else if (innerChoice == 4){
                    /**
                     * Close a current branch.
                     */
                    /**
                     * Removing the employee from a branch.
                     */
                    // stores the branch index
                    System.out.print("Enter the branch number that you want to close: ");
                    int branchIndex = userInnerInput.nextInt() - 1;
                    String branchName = businessOfBranch.get(branchIndex).getBranchLocation();

                    // removes the branch
                    getBusinessOfBranch().remove(branchIndex - 1);

                    // notifies about the removal
                    System.out.printf("Attention: {%s} branch has been closed.", branchName);
                    System.out.println(); // line changes
                    System.out.println();; // line change
                }
                else if (innerChoice == 0){
                    goodBye();
                }
            }
            else if (decisionCoin == 3){
                /**
                 * Changes to an employee
                 */
                // locating the branch
                System.out.print("Locate the branch number for the change in an employee: ");
                int branchIndex = userInput.nextInt();
                System.out.println("Making changes to {"+getBusinessOfBranch().get(branchIndex - 1).getBranchLocation()+"} branch employees."); System.out.println(); // new line
                String branchName = businessOfBranch.get(branchIndex - 1).getBranchLocation();

                System.out.println("Choose the option that best fits the change you want to make.\n"
                        + "1 : Change the employee {name}\n"
                        + "2 : Changes the employee {position}\n"
                        + "3 : Changes the employee {salary}\n"
                        + "4 : Recruiting a new employee\n"
                        + "5 : Firing a current employee\n"
                        + "0 : Exit the program");
                System.out.print("\nChoose your choice:");
                Scanner userInnerInput = new Scanner(System.in);
                int innerChoice = userInnerInput.nextInt();

                // choices
                if (innerChoice == 1){
                    // locating the employee
                    System.out.print("Locate the employee number for the change in {"+getBusinessOfBranch().get(branchIndex-1).getBranchLocation()+"} branch: ");
                    int employeeIndex = userInput.nextInt(); System.out.println(); // new line

                    String currentEmployeeName = getBusinessOfBranch().get(branchIndex-1).getBranchOfEmployees().get(employeeIndex-1).getEmployeeName();
                    System.out.println("Making changes to {"+currentEmployeeName+"}.");

                    // changes to an employee name
                    System.out.printf("Enter the new employee name: ");
                    Scanner userSuperInnerInput = new Scanner(System.in);
                    String newEmployeeName = userSuperInnerInput.nextLine();
                    getBusinessOfBranch().get(branchIndex - 1).getBranchOfEmployees().get(employeeIndex - 1).setEmployeeName(newEmployeeName); // changes name
                    System.out.println("The new name of the employee is {"+newEmployeeName+"}.");
                }
                else if (innerChoice == 2){
                    // locating the employee
                    System.out.print("Locate the employee number for the change in {"+getBusinessOfBranch().get(branchIndex-1).getBranchLocation()+"} branch: ");
                    int employeeIndex = userInput.nextInt(); System.out.println(); // new line

                    String currentEmployeeName = getBusinessOfBranch().get(branchIndex-1).getBranchOfEmployees().get(employeeIndex-1).getEmployeeName();
                    System.out.println("Making changes to {"+currentEmployeeName+"}.");

                    // changes to an employee position
                    System.out.printf("Enter the {%s}'s new position: ",currentEmployeeName);
                    Scanner userSuperInnerInput = new Scanner(System.in);
                    String newEmployeePosition = userSuperInnerInput.nextLine();
                    getBusinessOfBranch().get(branchIndex - 1).getBranchOfEmployees().get(employeeIndex - 1).setEmployeePosition(newEmployeePosition); // changes name
                    System.out.printf("The position of {%s} is {%s}.", currentEmployeeName, newEmployeePosition);
                }
                else if (innerChoice == 3){
                    // locating the employee
                    System.out.print("Locate the employee number for the change in {"+getBusinessOfBranch().get(branchIndex-1).getBranchLocation()+"} branch: ");
                    int employeeIndex = userInput.nextInt(); System.out.println(); // new line

                    String currentEmployeeName = getBusinessOfBranch().get(branchIndex-1).getBranchOfEmployees().get(employeeIndex-1).getEmployeeName();
                    System.out.println("Making changes to {"+currentEmployeeName+"}.");

                    // changes to an employee salary
                    System.out.printf("Enter the {%s}'s new salary: ",currentEmployeeName);
                    Scanner userSuperInnerInput = new Scanner(System.in);
                    int newEmployeeSalary = userSuperInnerInput.nextInt();
                    getBusinessOfBranch().get(branchIndex - 1).getBranchOfEmployees().get(employeeIndex - 1).setEmployeeSalary(newEmployeeSalary); // changes name
                    System.out.printf("The salary of {%s} is {%d}.", currentEmployeeName, newEmployeeSalary);
                }
                else if (innerChoice == 4){
                    Scanner userSuperInnerScanner = new Scanner(System.in);
                    /**
                     * Adding an employee to a branch.
                     */

                    // employee attributes
                    System.out.print("Enter the name of the new employee: ");
//                    Scanner userInnerInput = new Scanner(System.in);
                    String newEmployeeName = userSuperInnerScanner.nextLine();

                    System.out.print("Enter the position assigned to {" + newEmployeeName + "}: ");
                    String newEmployeePosition = userSuperInnerScanner.nextLine();

                    System.out.print("Enter the salary offered to {" + newEmployeeName + "}: ");
                    int newEmployeeSalary = userSuperInnerScanner.nextInt();

                    // adds an employee
                    getBusinessOfBranch().get(branchIndex - 1).addEmployees(newEmployeeName,newEmployeePosition,newEmployeeSalary);

                    // notifies about the recruit
                    System.out.printf("Attention: Employee {%s} has been recruited to {%s} branch.", newEmployeeName, branchName); System.out.println(); // new line
                }
                else if (innerChoice == 5){
                    /**
                     * Removing the employee from a branch.
                     */

                    // stores the employee index
                    System.out.print("Enter the employee number of the {" + branchName + "} branch: ");
                    int currentEmployeeIndex = userInput.nextInt() - 1;
                    String employeeName = businessOfBranch.get(branchIndex - 1).getBranchOfEmployees().get(currentEmployeeIndex).getEmployeeName();

                    // removes the employee
                    getBusinessOfBranch().get(branchIndex - 1).removeCurrentEmployee(currentEmployeeIndex);

                    // notifies about the removal
                    System.out.printf("Attention: Employee {%s} of {%s} branch has been removed.", employeeName, branchName); System.out.println(); // line changes
                    System.out.println();; // line change
                }
                else if (innerChoice == 0){
                    goodBye();
                }
                System.out.println(); // new line
            }
            else if (decisionCoin == 0){
                /**
                 * Goodbye Message
                 */
                goodBye();
            }

        }
        else if (userChoice == 2){
            // displays the changed information
            businessInformation(); // displays all information
        }
        else if (userChoice == 0){
            /**
             * Goodbye Message
             */
            goodBye();
        }
        else {
            // exceptional case
            System.out.println("You've used option out of context. Please choose the correct option again!");
        }
        // recursion
        changesInBusiness();
    }
}


