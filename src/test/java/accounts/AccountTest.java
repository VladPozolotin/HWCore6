package accounts;

import clients.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    Account Account1;
    Account Account2;
    Account Account3;
    Account Account4;
    @BeforeEach
    void beforeEach(){
        Account1 = new SavingsAccount("client1.getName()", 100, 50);
        Account2 = new CheckingAccount("client1.getName()", 100);
        Account3 = new CheckingAccount("client1.getName()", 200);
        Account4 = new CreditAccount("client1.getName()", -100);
    }
    @Test
    void test_transfer_amount200_check200_to_check100() {
        Assertions.assertTrue(Account3.transfer(Account2,200));
        Assertions.assertEquals(0,Account3.getBalance());
        Assertions.assertEquals(300,Account2.getBalance());
    }
    @Test
    void test_transfer_amount200_check100_to_check200() {
        Assertions.assertFalse(Account2.transfer(Account3,200));
        Assertions.assertEquals(100,Account2.getBalance());
        Assertions.assertEquals(200,Account3.getBalance());
    }
    @Test
    void test_transfer_amount75_save_to_credit() {
        Assertions.assertFalse(Account1.transfer(Account4,75));
        Assertions.assertEquals(100,Account1.getBalance());
        Assertions.assertEquals(-100,Account4.getBalance());
    }
    @Test
    void test_transfer_amount50_save_to_credit() {
        Assertions.assertTrue(Account1.transfer(Account4,50));
        Assertions.assertEquals(50,Account1.getBalance());
        Assertions.assertEquals(-50,Account4.getBalance());
    }
    @Test
    void test_transfer_amount100_check200_to_creditminus100() {
        Assertions.assertTrue(Account3.transfer(Account4,100));
        Assertions.assertEquals(100,Account3.getBalance());
        Assertions.assertEquals(0,Account4.getBalance());
    }
    @Test
    void test_transfer_amount200_check200_to_creditminus100() {
        Assertions.assertFalse(Account3.transfer(Account4,200));
        Assertions.assertEquals(200,Account3.getBalance());
        Assertions.assertEquals(-100,Account4.getBalance());
    }
    @Test
    void test_transfer_amount200_creditminus100_to_check200() {
        Assertions.assertTrue(Account4.transfer(Account3,200));
        Assertions.assertEquals(-300,Account4.getBalance());
        Assertions.assertEquals(400,Account3.getBalance());
    }
}