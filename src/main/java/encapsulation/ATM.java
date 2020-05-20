package encapsulation;

public class ATM {
    public static void main(String[] args) {
        Account account = new Account();
        account.addMoney(100);
        account.balance = 50;
    }
}
