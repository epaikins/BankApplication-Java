import org.junit.Before;
import org.junit.Test;
import org.pokoo_aikins.classes.Bank;

import static org.junit.Assert.*;

public class BankTest {
    private Bank bank;

    @Before
    public void setUp() throws Exception {
        bank = new Bank("National Australia org.pokoo_aikins.classes.Bank");
        bank.addBranch("Adelaide");

        bank.addCustomer("Adelaide", "Tim", 50.05);
        bank.addCustomer("Adelaide", "Mike", 1745.34);
        bank.addCustomer("Adelaide", "Percy", 220.12);

        bank.addCustomerTransaction("Adelaide","Tim",44.22);
        bank.addCustomerTransaction("Adelaide","Tim",12.44);
        bank.addCustomerTransaction("Adelaide","Tim",1.65);

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
        bank.addBranch("Cape Coast");
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
        bank.addBranch("Kumasi");
        bank.addCustomer("Kumasi", "Kofi", 2500.05);

        // All fields are valid
        assertTrue(bank.addCustomerTransaction("Kumasi","Kofi",100));

        // branchName:"Tema" (Name of branch not in the list of branches); return False
        assertFalse(bank.addCustomerTransaction("Tema","Kofi",100));

        // customerName:"Dave" (org.pokoo_aikins.classes.Customer not in the list of customers for Cape Coast branch); return False
        assertFalse(bank.addCustomerTransaction("Kumasi","Dave",100));

        // transaction:-100 (negative values are not allowed); return False
        assertFalse(bank.addCustomerTransaction("Kumasi","Kofi",-100));
    }

//
//    @Test
//    public void findBranch() {
//        bank.addBranch("Cape Coast");
//
//        // branchName:"Kumasi" (Name of branch does not exist in list of branches); return null
//        assertNull(bank.findBranch("Kumasi"));
//
//        // branchName:"Cape Coast" (org.pokoo_aikins.classes.Branch exists in the list of branches); return true
//        assertEquals("Cape Coast", bank.findBranch("Cape Coast").getName());
//
//        // branchName: "" (Empty strings are not allowed); return null
//        assertNull(bank.findBranch(""));
//    }

    @Test
    public void listCustomers() {
        bank.listCustomers("Adelaide",true);

        bank.listCustomers("Adelaide",false);
    }
}