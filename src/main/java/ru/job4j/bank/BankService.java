package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {

    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public boolean deleteUser(String passport) {
        if (findByPassport(passport) != null) {
            users.remove(findByPassport(passport));
            return true;
        }
        return false;
    }

    public void addAccount(String passport, Account account) {
        if (!users.get(findByPassport(passport)).contains(account)) {
            users.get(findByPassport(passport)).add(account);
        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        List<Account> list = users.get(findByPassport(passport));
        if (list != null) {
            for (Account account : list) {
                if (requisite.equals(account.getRequisite())) {
                    return account;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite,
                                 double amount) {
        Account dest = findByRequisite(destPassport, destRequisite);
        Account src = findByRequisite(srcPassport, srcRequisite);
        boolean destExist = users.get(findByPassport(destPassport)).contains(dest);
        if (src != null && src.getBalance() >= amount && destExist) {
            src.setBalance(src.getBalance() - amount);
            dest.setBalance(dest.getBalance() + amount);
            return true;
        }
        return false;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
