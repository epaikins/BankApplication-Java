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
        branch1 = new Branch("");
        branch2 = new Branch("Accra");
        branch.newCustomer("Eugene",20);
        branch.newCustomer("gene",40);

    }

    @Test
    public void getName() {
        assertEquals("Adelaide", branch.getName());
        assertNull(branch1.getName());
    }

    @Test
    public void getCustomers() {
        assertEquals(2, branch.getCustomers().size());
        assertEquals(0, branch2.getCustomers().size());

    }

    @Test
    public void newCustomer() { ;
        assertTrue(branch.newCustomer("Tedd", 205));
        assertFalse(branch.newCustomer("", 10));
    }

    @Test
    public void findCustomer() {
        assertNull(branch.findCustomer("Amos"));
        assertEquals("Eugene", branch.findCustomer("Eugene").getName());
        assertNull(branch.findCustomer(""));
    }

    @Test
    public void addCustomerTransaction() {
        assertTrue(branch.addCustomerTransaction("Eugene",10.4));
        assertFalse(branch.addCustomerTransaction("Amos",10.4));
        assertFalse(branch.addCustomerTransaction("Eugene",-10.4));
        assertFalse(branch.addCustomerTransaction("",100.4));
    }
}