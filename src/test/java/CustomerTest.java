import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.pokoo_aikins.classes.Customer;

import static org.junit.Assert.*;

public class CustomerTest {
    private Customer customer;

    @Before
    public void setUp() throws Exception {
        customer = new Customer("Eugene", 20.00);
        customer.addTransaction(20);
        customer.addTransaction(20.06);
    }


    @Test
    public void getName() {
        // All fields are valid
        assertEquals("Eugene", customer.getName());

        // name:"" (Empty Strings are not allowed hence the constructor returns a null); return null
        assertNull((new Customer("", 10)).getName());
    }

    @Test
    public void getTransactions() {
        //  Object customer has 3 transactions: (20.0, 20.0, 20.6); returns True
        assertEquals(Arrays.asList(20.0,20.0,20.06), customer.getTransactions());

        // Object has only one transaction in the list of transactions: expected:[500.0], actual: [500.0]
        assertEquals(Arrays.asList(500.0), (new Customer("Kofi", 500)).getTransactions());

        // initialTransaction = -10 (Negative values are not allowed); return null
        assertNull((new Customer("John", -10)).getTransactions());

        // Object has only one transaction in the list of transactions: expected:[0.0], actual: [0.0]
        assertEquals(Arrays.asList(0.0), (new Customer("Andrew", 0)).getTransactions());

        // Checks the length of the transactions list; expected: 3, actual: 3
        assertEquals(3, customer.getTransactions().size());
    }

    @Test
    public void addTransaction() {
        // Add transaction = 2000 to customer transactions
        customer.addTransaction(2000);

        // Get size of list of transactions
        int size = customer.getTransactions().size();

        // Checks the last element in the list; expected: 2000, actual: 2000
        assertEquals(2000, customer.getTransactions().get(size-1), 0.01);
    }
}