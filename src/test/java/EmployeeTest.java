import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    /**
     * Constructors
     */
    @org.junit.jupiter.api.Test
    void testEmptyConstructorEmployee(){
        Employee currentEmployee = new Employee();
        assertNotNull(currentEmployee);
    }
    @org.junit.jupiter.api.Test
    void testNonEmptyConstructorEmployee(){
        Employee currentEmployee = new Employee("Visho Malla Oli", "L7 Software Engineer", 314000);
        assertEquals("Visho Malla Oli", currentEmployee.getEmployeeName());
        assertEquals("L7 Software Engineer", currentEmployee.getEmployeePosition());
        assertEquals(314000, currentEmployee.getEmployeeSalary());
    }

    /**
     * Setter Methods
     */
    @org.junit.jupiter.api.Test
    void testSetEmployeeName() {
        Employee currentEmployee = new Employee();
        currentEmployee.setEmployeeName("Visho Malla Oli");
        assertEquals("Visho Malla Oli", currentEmployee.getEmployeeName());
    }

    @org.junit.jupiter.api.Test
    void testSetEmployeePosition() {
        Employee currentEmployee = new Employee();
        currentEmployee.setEmployeePosition("L5 Software Engineer");
        assertEquals("L5 Software Engineer", currentEmployee.getEmployeePosition());
    }

    @org.junit.jupiter.api.Test
    void setEmployeeSalary() {
        Employee currentEmployee = new Employee();
        currentEmployee.setEmployeeSalary(1223000);
        assertEquals(1223000, currentEmployee.getEmployeeSalary());
    }

    /**
     * Special Methods
     */
    @org.junit.jupiter.api.Test
    void testToString() {
        Employee currentEmployee = new Employee();
        currentEmployee.setEmployeeName("Odell Nolan");
        currentEmployee.setEmployeePosition("Internal Assurance Strategist");
        currentEmployee.setEmployeeSalary(80000);
        assertEquals("                Odell Nolan           Internal Assurance Strategist              80,000$", currentEmployee.toString());
    }
}