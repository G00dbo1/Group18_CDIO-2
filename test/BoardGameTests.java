package test;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import src.*;

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

    @Test 
    public void posistionTest1() {
        Player player = new Player();

        player.SetPosition(5);
        int expected = 6;

        assertEquals(expected, player.getPosition());

    }

    @Test 
    public void posistionTest2() {
        Player player = new Player();

        player.SetPosition(11);
        int expected = 0;

        assertEquals(expected, player.getPosition());

    }

    @Test 
    public void posistionTest3() {
        Player player = new Player();

        player.SetPosition(12);
        int expected = 1;

        assertEquals(expected, player.getPosition());

    }


}