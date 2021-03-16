package org.pokoo_aikins.classes;

import org.pokoo_aikins.interfaces.ICustomer;

import java.util.ArrayList;

public class Customer implements ICustomer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name, double initialTransaction){
        if(name.length() > 0 && initialTransaction >= 0) {
            this.name = name;
            this.transactions = new ArrayList<Double>();
            transactions.add(initialTransaction);
        }
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Double> getTransactions() {
        return this.transactions;
    }

    public void addTransaction(double transaction){
        if(transaction > 0) {
            this.transactions.add(transaction);
        }
    }
}
