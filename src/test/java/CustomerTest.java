import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {
    private Customer customer;
    private Customer customer1;
    private Customer customer2;
    private Customer customer3;
    private Customer customer4;

    @Before
    public void setUp() throws Exception {
        customer = new Customer("Eugene", 20.00);
        customer1 = new Customer("", 10);
        customer2 = new Customer("John", -10);
        customer3 = new Customer("Andrew", 0);
        customer4 = new Customer("Kofi", 500);
        customer.addTransaction(20);
        customer.addTransaction(20.06);
    }


    @Test
    public void getName() {
        assertEquals("Eugene", customer.getName());
        assertEquals(null, customer1.getName());
    }

    @Test
    public void getTransactions() {
        assertEquals(Arrays.asList(20.0,20.0,20.06), customer.getTransactions());
        assertEquals(Arrays.asList(500.0), customer4.getTransactions());
        assertEquals(null, customer2.getTransactions());
        assertEquals(Arrays.asList(0.0), customer3.getTransactions());
    }

    @Test
    public void addTransaction() {
        assertEquals(3, customer.getTransactions().size());
        assertEquals(1, customer3.getTransactions().size());
    }

}