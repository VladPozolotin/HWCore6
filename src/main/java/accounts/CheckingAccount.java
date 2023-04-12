package accounts;

public class CheckingAccount extends Account {
    public CheckingAccount(String holder, long balance) {
        super(holder, balance);
    }
    @Override
    public void setBalance(long balance) {
        if (balance < 0) {
            return;
        }
        this.balance = balance;
    }
    @Override
    public boolean pay(long amount) {
        if (amount > 0 && this.balance - amount >= 0) {
            this.balance-=amount;
            return true;
        }
        return false;
    }

    @Override
    public boolean add(long amount) {
        if (amount > 0) {
            this.balance+=amount;
            return true;
        }
        return false;
    }
}
