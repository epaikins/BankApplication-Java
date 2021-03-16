package org.pokoo_aikins.interfaces;

import org.pokoo_aikins.classes.Branch;

public interface IBank {
    public boolean addBranch(String branchName);
    public boolean addCustomer(String branchName, String customerName, double initialTransaction);
    public boolean addCustomerTransaction(String branchName, String customerName, double transaction);
    private Branch findBranch(String branchName){
        return null;
    };
    public void listCustomers(String branchName, boolean printTransactions);
}
