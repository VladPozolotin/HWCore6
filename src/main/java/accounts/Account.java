package accounts;

public abstract class Account implements MoneyTarget{
    protected String holder;
    protected long balance;

    public Account(String holder, long balance) {
        this.holder = holder;
        this.balance = balance;
    }

    public String getHolder() {
        return this.holder;
    }

    public long getBalance() {
        return this.balance;
    }

    public abstract void setBalance(long balance);

    public abstract boolean pay(long amount);

    public abstract boolean add(long amount);
    public boolean transfer(Account accountTo, long amount){
        if (Boolean.TRUE.equals(pay(amount))){
            if (Boolean.TRUE.equals(accountTo.add(amount))){
                return true;
            }
            add(amount);
            return false;
        }
        return false;
    }
    @Override
    public boolean accept(long money){
        if (Boolean.TRUE.equals(add(money))){
            return true;
        }
        return false;
    }
}
