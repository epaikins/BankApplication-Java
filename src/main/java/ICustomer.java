import java.util.ArrayList;

public interface ICustomer {
    public String getName();

    public ArrayList<Double> getTransactions();

    public void addTransaction(double transaction);
}
