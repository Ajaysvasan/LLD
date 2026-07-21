package LLD.atm_management_system;

public class User {
    String name;
    short phoneNumber;
    String country;
    BankAccount bankAccount;

    public User(String name, short phoneNumber, String country, String bankName, short accountNumber, short pinNumber,
            long bankBalance) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.country = country;
        bankAccount = new BankAccount(accountNumber, pinNumber, bankBalance, bankName);
    }

    public String getName() {
        return this.name;
    }

    public short phoneNumber() {
        return this.phoneNumber;
    }

    public String country() {
        return this.country();
    }

    public boolean withdraw(long amount) {
        return bankAccount.withdraw(amount);
    }

    public boolean deposit(long amount) {
        return bankAccount.deposit(amount);
    }

    public boolean changePin(short oldPinNumber, short newPinNumber) {
        return bankAccount.changePin(oldPinNumber, newPinNumber);
    }

    public short getAccountNumber() {
        return bankAccount.getAccountNumber();
    }

    public long viewBalance() {
        return bankAccount.getBankBalance();
    }
}
