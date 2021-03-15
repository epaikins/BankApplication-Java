import java.util.ArrayList;

public class Branch {
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

    public boolean newCustomer(String name, double transaction){
            if(findCustomer(name) == null){
                this.customers.add(new Customer(name,transaction));
                return true;
            }
            return false;
    }

    public Customer findCustomer(String name){
            for(Customer customer: this.customers){
                if(customer.getName().equals(name)){
                    return customer;
                }
            }
            return null;
    }
    
    public boolean addCustomerTransaction(String name, double transaction){
            Customer customer = findCustomer(name);
            if(customer != null ) {
                customer.addTransaction(transaction);
                return true;
            }
            return false;
    }
}
