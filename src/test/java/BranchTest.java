import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class BranchTest {
    private Branch branch;
    private Branch branch1;
    private Branch branch2;

    @Before
    public void setUp() throws Exception {
        branch = new Branch("Adelaide");
        branch2 = new Branch("Accra");
        branch.newCustomer("Eugene",20);
        branch.newCustomer("gene",40);
    }

    @Test
    public void getName() {
        // All fields are valid
        assertEquals("Adelaide", branch.getName());

        // name:"" (Empty Strings are not allowed hence the constructor returns a null); return null
        assertNull((new Branch("")).getName());
    }

    @Test
    public void getCustomers() {
        // (Branch Adelaide has two customers: Eugene and gene); expected: 2, actual: 2
        assertEquals(2, branch.getCustomers().size());

        // (Branch Accra has no customers); expected: 0, actual: 0
        assertEquals(0, (new Branch("Accra")).getCustomers().size());

    }

    @Test
    public void newCustomer() {
        // All fields are valid; return True
        assertTrue(branch.newCustomer("Tedd", 205));

        // customerName="" (Empty Strings are not allowed); return False
        assertFalse(branch.newCustomer("", 10));
    }

    @Test
    public void findCustomer() {
        // customerName="Amos" (Does not exist in the list of customers); return null
        assertNull(branch.findCustomer("Amos"));

        // (customerName= "Eugene" exist in the list of customers); expected: "Eugene", actual: "Eugene"
        assertEquals("Eugene", branch.findCustomer("Eugene").getName());

        // customerName="" (Empty strings are not allowed); return null
        assertNull(branch.findCustomer(""));
    }

    @Test
    public void addCustomerTransaction() {
        // All fields are valid
        assertTrue(branch.addCustomerTransaction("Eugene",10.4));

        // customerName="Amos" (Does not exist in the list of customers); return False
        assertFalse(branch.addCustomerTransaction("Amos",10.4));

        // transaction = -10.4 (negative values are not allowed); return False
        assertFalse(branch.addCustomerTransaction("Eugene",-10.4));

        // customerName="" (Empty strings are not allowed); return False
        assertFalse(branch.addCustomerTransaction("",100.4));
    }
}