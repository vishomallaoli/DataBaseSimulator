import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusinessTest {

    /**
     * Constructors
     */
    @Test
    void testEmptyBusinessConstructor(){
        Business business = new Business();
        assertNotNull(business);
    }
    @Test
    void testNonEmptyBusinessContructor(){
        Business business = new Business("Stark Industries");
        assertEquals("Stark Industries", business.getBusinessName());
    }

    /**
     * Special Methods
     */
    @Test
    void testSetBusinessName() {
        Business business = new Business();
        business.setBusinessName("Titan Communication");
        assertEquals("Titan Communictaion", business.getBusinessName());
    }

    @Test
    void testAddBranch() {
        Business business = new Business();
        business.addBranch("New York", 2000); // setting

        assertEquals("New York", business.getBusinessOfBranch().get(0).getBranchLocation()); // testing
        assertEquals(2000,business.getBusinessOfBranch().get(0).getBranchYearOpening()); // testing
    }

    @Test
    void removeCurrentBranch() {
        Business business = new Business();
        business.addBranch("New York", 2000); // true from previous test
        business.addBranch("Washington D.C.", 1997); // true from previous test


        business.removeCurrentBranch(0); // removing branch at 0.
        assertNotEquals("New York", business.getBusinessOfBranch().get(0).getBranchLocation()); // testing
        assertNotEquals(2000, business.getBusinessOfBranch().get(0).getBranchYearOpening()); // testing

    }


}