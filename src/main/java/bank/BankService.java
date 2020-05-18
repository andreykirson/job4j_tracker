package bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        List<Account> accounts = new ArrayList<Account>();
        users.putIfAbsent(user, accounts);
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        List<Account> accounts = users.get(user);
        if (accounts.size() == 0) {
            accounts.add(new Account(account.getRequisite(), account.getBalance()));
        } else {
                if (account.getRequisite().contains(account.getRequisite())) {
                    accounts.add(account);
                }
        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()){
            if(user.getPassport().equals(passport)){
                return user;
            }
        }
    return null;
    }


    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if(user == null){
            return null;
        }
        List<Account> accounts = users.get(user);
        for (Account account:accounts) {
                  if(account.getRequisite().equals(requisite)){
                  return account;
              }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String dеstRequisite, double amount) {
        boolean rsl = false;
        User userSrc = findByPassport(srcPassport);
        User userDest = findByPassport(destPassport);
        Account srcAccount = findByRequisite(userSrc.getPassport(), srcRequisite);
        if(srcAccount == null || srcAccount.getBalance() < amount){
            rsl = false;
        }
        else {
                Account destAccount = findByRequisite(userDest.getPassport(), dеstRequisite);
                srcAccount.setBalance(srcAccount.getBalance() - amount);
                destAccount.setBalance(destAccount.getBalance() + amount);
                rsl = true;
            }
        return rsl;
    }


    public void removeUser(String Passport){
        User user = findByPassport(Passport);
        users.remove(user);
    }


    public static void main(String[] args) {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
    }

    }
