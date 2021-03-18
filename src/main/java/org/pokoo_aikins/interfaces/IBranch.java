package org.pokoo_aikins.interfaces;
import org.pokoo_aikins.classes.Customer;

import java.util.ArrayList;

public interface IBranch {
    public String getName();
    public ArrayList<Customer> getCustomers();
    public boolean newCustomer(String customerName, double initialTransaction);
    public boolean addCustomerTransaction(String customerName, double transaction);
}
