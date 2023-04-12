package accounts;

public class SavingsAccount extends Account {
    protected long minBalance;

    public SavingsAccount(String holder, long balance, long minBalance) {
        super(holder, balance);
        this.minBalance = minBalance;
    }

    @Override
    public void setBalance(long balance) {
        if (balance <= this.minBalance) {
            return;
        }
        this.balance = balance;
    }
    @Override
    public boolean pay(long amount) {
        if (amount > 0 && this.balance - amount >= this.minBalance) {
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
