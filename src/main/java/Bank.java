import java.util.ArrayList;
public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name){
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String branchName){
        Branch branch = findBranch(branchName);
        if( branch != null){
            this.branches.add(branch);
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialTransaction){
        Branch branch = findBranch(branchName);
        if(branch != null) {
            return branch.newCustomer(customerName, initialTransaction);
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double transaction){
        Branch branch = findBranch(branchName);
        if(branch != null) {
            return branch.addCustomerTransaction(customerName, transaction);
        }
        return false;
    }

    public Branch findBranch(String branchName){
        for(Branch branch: this.branches){
            if(branch.getName().equals(branchName)){
                return branch;
            }
        }
        return null;
    }

    public void listCustomers(String branchName, boolean printTransactions){
        System.out.println("Customer details for branch "+branchName);
        Branch branch =  findBranch(branchName);
        int customerNumber = 1;
        if(printTransactions){
            for(int i = 0; i < branch.getCustomers().size(); i++){
                System.out.println("Customer: "+ branch.getCustomers().get(i).getName()+"["+ customerNumber + "]");
                System.out.println("Transactions");
                int transactionNumber = 1;
                for(int j = 0; j < branch.getCustomers().get(i).getTransactions().size(); j++){
                    System.out.println("["+transactionNumber+"] Amount " + branch.getCustomers().get(i).getTransactions().get(j));
                    transactionNumber++;
                }
                customerNumber++;
            }
        }
        else{
            for(int i = 0; i < branch.getCustomers().size(); i++) {
                System.out.println("Customer: " + branch.getCustomers().get(i).getName() + "[" + customerNumber + "]");
                customerNumber++;
            }
        }
    }

}
