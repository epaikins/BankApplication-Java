import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankTest {
    private Bank bank;

    @Before
    public void setUp() throws Exception {
        bank = new Bank("GCB");
        bank.addBranch("Cape Coast");
        bank.addCustomer("Cape Coast", "Eugene", 20);
        bank.addCustomer("Cape Coast", "Vee", 200);
        bank.addCustomer("Cape Coast", "Gemini", 0);
        bank.addCustomerTransaction("Cape Coast","Eugene",10);
        bank.addCustomerTransaction("Cape Coast","Eugene",100);
        bank.addCustomerTransaction("Cape Coast","Eugene",130);
        bank.addCustomerTransaction("Cape Coast","Eugene",170);
    }

    @Test
    public void addBranch() {
        // All fields are valid; return True
        assertTrue(bank.addBranch("Accra"));

        // branchName:"" (Empty strings are not allowed); return False
        assertFalse(bank.addBranch(""));
    }

    @Test
    public void addCustomer() {
        // All fields are valid; return True
        assertTrue(bank.addCustomer("Cape Coast","Kweku",20));

        // branchName: Bolgatanga (Name of branch not in the list of branches); return False
        assertFalse(bank.addCustomer("Bolgatanga", "Yaw", 30));

        // customerName: "" (Empty strings are not allowed); return False
        assertFalse(bank.addCustomer("Cape Coast", "", 30));

        // initialTransaction: -10 (negative values are not allowed); return False
        assertFalse(bank.addCustomer("Cape Coast", "Kofi", -10));
    }

    @Test
    public void addCustomerTransaction() {
        // All fields are valid
        assertTrue(bank.addCustomerTransaction("Cape Coast","Eugene",100));

        // branchName:"Kumasi" (Name of branch not in the list of branches); return False
        assertFalse(bank.addCustomerTransaction("Kumasi","Eugene",100));

        // customerName:"Dave" (Customer not in the list of customers for Cape Coast branch); return False
        assertFalse(bank.addCustomerTransaction("Cape Coast","Dave",100));

        // transaction:-100 (negative values are not allowed); return False
        assertFalse(bank.addCustomerTransaction("Cape Coast","Eugene",-100));
    }

    @Test
    public void findBranch() {
        // branchName:"Kumasi" (Name of branch does not exist in list of branches); return null
        assertNull(bank.findBranch("Kumasi"));

        // branchName:"Cape Coast" (Branch exists in the list of branches); return true
        assertEquals("Cape Coast", bank.findBranch("Cape Coast").getName());

        // branchName: "" (Empty strings are not allowed); return null
        assertNull(bank.findBranch(""));
    }

    @Test
    public void listCustomers() {
        bank.listCustomers("Cape Coast",true);
    }
}