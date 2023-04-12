package main.java;

import accounts.Account;
import accounts.CheckingAccount;
import accounts.CreditAccount;
import accounts.SavingsAccount;
import clients.Client;
public class Main {
    public static void main(String[] args) {
        Client client1 = new Client("Alexey Petrov", 4);
        Account Account1 = new SavingsAccount(client1.getName(), 100, 50);
        Account Account2 = new CheckingAccount(client1.getName(), 100);
        Account Account3 = new CheckingAccount(client1.getName(), 200);
        Account Account4 = new CreditAccount(client1.getName(), -100);
        client1.add(Account1);
        client1.add(Account2);
        client1.add(Account3);
        client1.add(Account4);
        System.out.println(Account1.getBalance());
        System.out.println(Account2.getBalance());
        System.out.println(Account3.getBalance());
        System.out.println(Account4.getBalance());
        System.out.println("Savings to Credit: " + Boolean.TRUE.equals(Account1.transfer(Account4, 60)));
        System.out.println("Check100 to Check200: " + Boolean.TRUE.equals(Account2.transfer(Account3, 200)));
        System.out.println("Check200 to Credit: " + Boolean.TRUE.equals(Account3.transfer(Account4, 100)));
        System.out.println(Account1.getBalance());
        System.out.println(Account2.getBalance());
        System.out.println(Account3.getBalance());
        System.out.println(Account4.getBalance());
        Client client2 = new Client("Elon Musk", 4);
        Account Account6 = new CreditAccount(client2.getName(), -1000);
        Account Account7 = new SavingsAccount(client2.getName(), 700, 500);
        Account Account8 = new CheckingAccount(client2.getName(), 2000);
        client2.add(Account6);
        client2.add(Account7);
        client2.add(Account8);
        System.out.println(Account6.getBalance());
        System.out.println(Account7.getBalance());
        System.out.println(Account8.getBalance());
        System.out.println("Accept 2000: " + Boolean.TRUE.equals(client2.accept(2000)));
        System.out.println("Accept 700: " + Boolean.TRUE.equals(client2.accept(700)));
        System.out.println(Account6.getBalance());
        System.out.println(Account7.getBalance());
        System.out.println(Account8.getBalance());
        Client client3 = new Client("Vasya Pupkin", 4);
        Account Account9 = new CreditAccount(client2.getName(), -1000);
        Account Account10 = new CreditAccount(client2.getName(), -700);
        client3.add(Account9);
        client3.add(Account10);
        System.out.println(Account9.getBalance());
        System.out.println(Account10.getBalance());
        System.out.println("Accept 2000: " + Boolean.TRUE.equals(client3.accept(2000)));
        System.out.println("Accept 700: " + Boolean.TRUE.equals(client3.accept(700)));
        System.out.println(Account9.getBalance());
        System.out.println(Account10.getBalance());
    }
}