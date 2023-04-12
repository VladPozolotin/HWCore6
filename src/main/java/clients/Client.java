package clients;
import accounts.Account;
import accounts.MoneyTarget;

public class Client implements MoneyTarget {
    protected String name;
    protected Account[] accounts;
    public Client(String name, int accounts){
        this.name = name;
        if (accounts > 0) {
            this.accounts = new Account[accounts];
        }
    }
    public String getName() {
        return this.name;
    }
    public void add(Account account){
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                accounts[i] = account;
                return;
            }
        }
        System.out.println("Недостаточно места для добавления нового счёта.");
    }
    public boolean pay (long amount){
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null) {
                Account account = accounts[i];
                if (Boolean.TRUE.equals(account.pay(amount))){
                    return true;
                };
            }
        }
        return false;
    }
    @Override
    public boolean accept(long money) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null) {
                Account account = accounts[i];
                if (Boolean.TRUE.equals(account.add(money))){
                    return true;
                };
            }
        }
        return false;
    }
}
