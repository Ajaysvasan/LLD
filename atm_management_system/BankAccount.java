package LLD.atm_management_system;

public class BankAccount {
    short accountNumber;
    short pinNumber;
    long bankBalance;
    String bankName;

    public BankAccount(short accountNumber, short pinNumber, long bankBalance, String bankName) {
        this.accountNumber = accountNumber;
        this.pinNumber = pinNumber;
        this.bankBalance = bankBalance;
        this.bankName = bankName;
    }

    public short getAccountNumber() {
        return this.accountNumber;
    }

    private short getPinNumber() {
        return this.pinNumber;
    }

    public long getBankBalance() {
        return this.bankBalance;
    }

    public String getBankName() {
        return this.bankName;
    }

    private void updatePin(short newPin) {
        this.pinNumber = newPin;
    }

    private boolean withdrawAmount(long amount) {
        long amountAvaliable = getBankBalance();
        if (amountAvaliable < amount) {
            return false;
        }
        amountAvaliable -= amount;
        return true;
    }

    private boolean depositAmount(long amount) {
        long amountAvaliable = getBankBalance();
        amountAvaliable += amount;
        return true;
    }

    public boolean withdraw(long amount) {
        return withdrawAmount(amount);
    }

    public boolean deposit(long amount) {
        return depositAmount(amount);
    }

    public boolean changePin(short oldPinNumber, short newPinNumber) {
        short currentPinNumber = getPinNumber();
        if (currentPinNumber == oldPinNumber) {
            updatePin(newPinNumber);
            return true;
        }
        return false;
    }
}
