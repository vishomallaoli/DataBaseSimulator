import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BranchTest {
    /**
     * Constructors
     */
    @Test
    void testEmptyConstructorBranch(){
        Branch branch = new Branch();
        assertNotNull(branch);
    }
    void testNonEmptyConstructorBranch(){
        Branch branch = new Branch("Atlanta", 2023);
        assertEquals("Atlanta", branch.getBranchLocation());
        assertEquals(2023, branch.getBranchYearOpening());
    }

    /**
     * Setter Methods
     */
    @Test
    void testSetBranchLocation() {
        Branch branch = new Branch();
        branch.setBranchLocation("Las Vegas");
        assertEquals("Las Vegas", branch.getBranchLocation());
    }

    @Test
    void testSetBranchYearOpening() {
        Branch branch = new Branch();
        branch.setBranchYearOpening(1997);
        assertEquals(1997, branch.getBranchYearOpening());
    }

    /**
     * Special Methods
     */

    @Test
    void testToString() {
        Branch branch = new Branch();
        branch.setBranchLocation("New York");
        branch.setBranchYearOpening(1994);
        assertEquals("BRANCH\t\t:   New York\nOPENING YEAR:       1994", branch.toString());
    }

    @Test
    void testAddEmployees() {
        Branch branch = new Branch();
        branch.addEmployees("Visho Malla Oli", "L5 Software Engineer", 1223000);
        assertEquals("Visho Malla Oli", branch.getBranchOfEmployees().get(0).getEmployeeName());
        assertEquals("L5 Software Engineer", branch.getBranchOfEmployees().get(0).getEmployeePosition());
        assertEquals(1223000, branch.getBranchOfEmployees().get(0).getEmployeeSalary());

    }
    @Test
    void testRemoveCurrentEmployee() {
        Branch branch = new Branch();
        branch.addEmployees("Visho Malla Oli", "L5 Software Engineer", 1223000); // true from previous test
        branch.addEmployees("Ishan Pathak", "Data Engineer", 200000); // true from previous test

        branch.removeCurrentEmployee(0); // should remove "Visho Malla Oli"
        assertNotEquals("Visho Malla Oli", branch.getBranchOfEmployees().get(0).getEmployeeName()); // testing
        assertNotEquals("L5 Software Engineer", branch.getBranchOfEmployees().get(0).getEmployeePosition()); // testing
        assertNotEquals(1223000, branch.getBranchOfEmployees().get(0).getEmployeeSalary()); // testing
    }
}