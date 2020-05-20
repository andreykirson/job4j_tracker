package encapsulation;

public class Account {

    public int balance;
    public void addMoney(int money) {
        if (money > 0) {
            balance += money;
        }
    }
}
