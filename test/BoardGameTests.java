package test;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import src.Account;

public class BoardGameTests {
    @Test
    public void negativeBalanceTest1() {
        int expected = 0;

        Account account = new Account(0);
        account.updateCoin(-500);
        assertEquals(expected, account.getBalance());
    }

    @Test
    public void negativeBalanceTest2() {
        int expected = 0;

        Account account = new Account(-500);
        assertEquals(expected, account.getBalance());
    }

    
}