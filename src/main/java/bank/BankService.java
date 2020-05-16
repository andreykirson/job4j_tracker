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
        accounts.add(new Account(account.getRequisite(), account.getBalance()));
        users.put(user, accounts);
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
        if(user.equals(null)){
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
            return rsl;
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

    }
