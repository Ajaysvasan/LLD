package LLD.atm_management_system;

public class ATM {
    String atmName;
    long cashAvaliable;

    public ATM(String atmName, long cashAvaliable) {
        this.atmName = atmName;
        this.cashAvaliable = cashAvaliable;
    }

    private void updateCash(long amount) {
        this.cashAvaliable += amount;
    }

    public void viewBalance(User user) {
        System.out.println("Your bank balance is: " + user.viewBalance());
    }

    private boolean withdrawAmount(long amount, User user) {
        if (this.cashAvaliable < amount) {
            System.out.println("ATM doesn't have enough cash in it");
            return false;
        }
        if (user.withdraw(amount)) {
            this.cashAvaliable -= amount;
            return true;
        }
        System.out.println("Your account doesn't have sufficient balance");
        return false;
    }

    public boolean withdraw(long amount, User user) {
        return withdrawAmount(amount, user);
    }

    private boolean depositAmount(long amount, User user) {
        this.cashAvaliable += amount;
        user.deposit(amount);
        return true;
    }

    public boolean deposit(long amount, User user) {
        return depositAmount(amount, user);
    }

    public boolean changePin(User user, short oldPinNumber, short newPinNumber) {
        return user.changePin(oldPinNumber, newPinNumber);
    }

    public boolean updateAvaliableCash(long amount, boolean isAdmin) {
        if (isAdmin) {
            updateCash(amount);
            return true;
        }
        return false;
    }

}
