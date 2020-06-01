package bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        List<Account> accounts = new ArrayList<>();
        users.putIfAbsent(user, accounts);
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        List<Account> accounts = users.get(user);
        if (accounts.size() == 0) {
            accounts.add(new Account(account.getRequisite(), account.getBalance()));
        } else {
                if (!accounts.contains(account)) {
                    accounts.add(account);
                }
        }
    }

    // Here can be used stream filter predicate

    public User findByPassport(String passport) {
        Optional<User> u = users.keySet().stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
        return u.orElse(null);
    }

    public Account findByRequisite(String passport, String requisite) {
        List<Account> accountEmpty = new ArrayList<>();
        Optional<Account> accountFound = users.getOrDefault(findByPassport(passport), accountEmpty).stream()
                .filter(account -> account.getRequisite().equals(requisite))
                .findFirst();
        return accountFound.orElse(null);

    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        User userSrc = findByPassport(srcPassport);
        User userDest = findByPassport(destPassport);
        Account srcAccount = findByRequisite(userSrc.getPassport(), srcRequisite);
        if (srcAccount == null || srcAccount.getBalance() < amount) {
            rsl = false;
        } else {
                Account destAccount = findByRequisite(userDest.getPassport(), destRequisite);
                srcAccount.setBalance(srcAccount.getBalance() - amount);
                destAccount.setBalance(destAccount.getBalance() + amount);
                rsl = true;
            }
        return rsl;
    }


    public void removeUser(String passport) {
        User user = findByPassport(passport);
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



