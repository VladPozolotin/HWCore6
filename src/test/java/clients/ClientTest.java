package clients;

import accounts.CheckingAccount;
import accounts.CreditAccount;
import accounts.SavingsAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {
    Client client;

    @BeforeEach
    void beforeEach() {
        client = new Client("Alexey Petrov", 3);
    }

    @Test
    void test_add_account_to_client() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        client.add(new CheckingAccount(client.getName(), 1000));
        client.add(new SavingsAccount(client.getName(), 1000, 50));
        client.add(new CreditAccount(client.getName(), -1000));
        client.add(new CheckingAccount(client.getName(), 2000));
        Assertions.assertEquals("Недостаточно места для добавления нового счёта.\r\n", out.toString());
    }

    @Test
    void test_pay_from_accounts_successful() {
        client.add(new CheckingAccount(client.getName(), 1000));
        client.add(new SavingsAccount(client.getName(), 1000, 50));
        client.add(new CreditAccount(client.getName(), -1000));
        Assertions.assertTrue(client.pay(500));
    }

    @Test
    void test_pay_from_accounts_failed() {
        client.add(new SavingsAccount(client.getName(), 1000, 50));
        Assertions.assertFalse(client.pay(970));
    }

    @Test
    void test_pay_from_accounts_empty() {
        Assertions.assertFalse(client.pay(970));
    }

    @Test
    void test_accept_money_to_accounts_successful() {
        client.add(new CheckingAccount(client.getName(), 1000));
        client.add(new SavingsAccount(client.getName(), 1000, 50));
        client.add(new CreditAccount(client.getName(), -1000));
        Assertions.assertTrue(client.accept(500));
    }

    @Test
    void test_accept_money_to_accounts_failed() {
        client.add(new CreditAccount(client.getName(), -1000));
        Assertions.assertFalse(client.accept(1500));
    }

    @Test
    void test_accept_money_to_accounts_empty() {
        Assertions.assertFalse(client.accept(1500));
    }
}