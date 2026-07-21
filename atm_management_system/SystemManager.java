package LLD.atm_management_system;

import java.util.HashMap;

public class SystemManager {
    HashMap<Integer, User> userMapp;
    ATM atm;

    public SystemManager(String atmName, long initialAmount) {
        userMapp = new HashMap<>();
        atm = new ATM(atmName, initialAmount);
    }

    private boolean insertUser(String name, short phoneNumber, String country, String bankName, short accountNumber,
            short pinNumber,
            long bankBalance) {
        User user = new User(name, phoneNumber, country, bankName, accountNumber, pinNumber, bankBalance);
        int key = Short.hashCode(accountNumber);
        if (!userMapp.containsKey(key)) {
            userMapp.put(key, user);
            return true;
        }
        return false;
    }

    private User createUser(String name, short phoneNumber, String country, String bankName, short accountNumber,
            short pinNumber,
            long bankBalance) {
        return new User(name, phoneNumber, country, bankName, accountNumber, pinNumber, bankBalance);
    }

    public boolean insert(String name, short phoneNumber, String country, String bankName, short accountNumber,
            short pinNumber,
            long bankBalance) {
        return insertUser(name, phoneNumber, country, bankName, accountNumber, pinNumber, bankBalance);
    }

    private User getUser(short accountNumber) {
        int key = Short.hashCode(accountNumber);
        if (userMapp.containsKey(key)) {
            return userMapp.get(key);
        }
        return null;
    }

    public void viewBalance(User user) {
        atm.viewBalance(user);
    }

    public User authenticate(short accountNumber) {
        return getUser(accountNumber);
    }

    public void withdraw(long amount, User user) {
        atm.withdraw(amount, user);
    }

    public void deposit(long amount, User user) {
        atm.deposit(amount, user);
    }

    public void updateCash(boolean isAdmin, long amount) {
        atm.updateAvaliableCash(amount, isAdmin);
    }

}
