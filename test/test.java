package test;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import junit.*;
import src.Account;

public class test {
    @Test
    public void negativeBalanceTest1() {
        int expected = 0;

        Account account = new Account(0);
        account.updateCoin(-500);
        assertEquals(expected, account.getBalance());
    }
}