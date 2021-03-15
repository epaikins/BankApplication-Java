import java.util.ArrayList;

public interface IBranch {
    public String getName();
    public ArrayList<Customer> getCustomers();
    public boolean newCustomer(String customerName, double initialTransaction);
    public Customer findCustomer(String customerName);
    public boolean addCustomerTransaction(String customerName, double transaction);
}
