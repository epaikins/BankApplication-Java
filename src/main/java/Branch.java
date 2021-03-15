import java.util.ArrayList;

public class Branch implements IBranch {
        private String name;
        private ArrayList<Customer> customers;

        public Branch(String name){
            this.name = name;
            this.customers = new ArrayList<Customer>();
        }

    public String getName() {
        return this.name;
    }

    public ArrayList<Customer> getCustomers() {
        return this.customers;
    }

    public boolean newCustomer(String customerName, double initialTransaction){
            if(findCustomer(customerName) == null){
                this.customers.add(new Customer(customerName,initialTransaction));
                return true;
            }
            return false;
    }

    public Customer findCustomer(String customerName){
            for(Customer customer: this.customers){
                if(customer.getName().equals(customerName)){
                    return customer;
                }
            }
            return null;
    }

    public boolean addCustomerTransaction(String customerName, double transaction){
            Customer customer = findCustomer(customerName);
            if(customer != null ) {
                customer.addTransaction(transaction);
                return true;
            }
            return false;
    }
}
