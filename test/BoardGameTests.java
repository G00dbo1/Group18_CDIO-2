package test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.*;
import src.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;


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
    public void playerTest1() {
        Player player = new Player();
        int expected = 1000;
        
        assertEquals(expected, player.getCoins());
    }

    @Test
    public void playerTest2() {
        Player player = new Player();
        player.updateCoins(500);

        int expected = 1500;
        
        assertEquals(expected, player.getCoins());
    }

    @Test 
    public void posistionTest1() {
        Player player = new Player();

        player.SetPosition(5);
        int expected = 5;

        assertEquals(expected, player.getPosition());

    }

    @Test 
    public void posistionTest2() {
        Player player = new Player();

        player.SetPosition(11);
        int expected = 11;

        assertEquals(expected, player.getPosition());

    }

    @Test 
    public void posistionTest3() {
        Player player = new Player();

        player.SetPosition(12);
        int expected = 0;

        assertEquals(expected, player.getPosition());

    }

    @Test 
    public void posistionTest4() {
        Player player = new Player();

        player.SetPosition(20);
        int expected = 8;

        assertEquals(expected, player.getPosition());

    }

    // Tests from CDIO 1, to test the die probability
    @Test
    public void normalDistributionTest() {
        int TOTALROLLS = 100000000;
        Die d1 = new Die(6);
        Die d2 = new Die(6);
        int roll1;
        int roll2;
        var finalArray = new double[11];
        // Using BigDecimal here to round down to two digits
        BigDecimal[] distribution = new BigDecimal[11];
        Arrays.fill(distribution, BigDecimal.ZERO);
        BigDecimal divisor = new BigDecimal(TOTALROLLS);
        BigDecimal increment = new BigDecimal(1);

        // Theoretical distrution of the sum of two die from https://www.omnicalculator.com/statistics/dice
        var theoreticalDistribution = new double[] {0.027, 0.055, 0.083, 0.111, 0.138, 0.166, 0.138, 0.111, 0.083, 0.055, 0.027};

        for (var i = 0; i < TOTALROLLS; i++) {
            d1.roll();
            roll1 = d1.getFaceValue();
            d2.roll();
            roll2 = d2.getFaceValue();
            switch (roll1+roll2) {
                case 2 -> distribution[0] = distribution[0].add(increment);
                case 3 -> distribution[1] = distribution[1].add(increment);
                case 4 -> distribution[2] = distribution[2].add(increment);
                case 5 -> distribution[3] = distribution[3].add(increment);
                case 6 -> distribution[4] = distribution[4].add(increment);
                case 7 -> distribution[5] = distribution[5].add(increment);
                case 8 -> distribution[6] = distribution[6].add(increment);
                case 9 -> distribution[7] = distribution[7].add(increment);
                case 10 -> distribution[8] = distribution[8].add(increment);
                case 11 -> distribution[9] = distribution[9].add(increment);
                case 12 -> distribution[10] = distribution[10].add(increment);
            }
        }
        // Copying over to finalArray because assertArrayEquals doesn't accept BigDecimal
        for (var i = 0; i < finalArray.length; i++) {
            distribution[i] = distribution[i].divide(divisor).setScale(3, RoundingMode.DOWN);
            finalArray[i] = distribution[i].doubleValue();
        }
        assertArrayEquals(theoreticalDistribution, finalArray, 0);
    }

    @Test
    public void equalsTest() {
        int TOTALROLLS = 100000000;
        Die d1 = new Die(6);
        Die d2 = new Die(6);
        int roll1;
        int roll2;
        // Same as above
        BigDecimal amountEquals = new BigDecimal(0);
        BigDecimal divisor = new BigDecimal(TOTALROLLS);
        BigDecimal increment = new BigDecimal(1);
        double theoreticalAmount = 0.167;

        for (var i = 0; i < TOTALROLLS; i++) {
            d1.roll();
            roll1 = d1.getFaceValue();
            d2.roll();
            roll2 = d2.getFaceValue();
            if (roll1 == roll2) {
                amountEquals = amountEquals.add(increment);
            }
        }
        
        amountEquals = amountEquals.divide(divisor).setScale(3, RoundingMode.CEILING);

        assertEquals(theoreticalAmount, amountEquals.doubleValue(), 0);
    }

    @Test
    public void dieTest1() {
        Die die1 = new Die(6);
        Die die2 = new Die(6);
        
        die1.roll();
        die2.roll();

        assertFalse(die1.getFaceValue() + die2.getFaceValue() == 1);
        
    }

    @Test
    public void squareTest1() {
        Language lan = new Language();
        Square square = new Square(5, lan.ENG(5));

        int expected = 5;

        assertEquals(expected, square.getId());
    }

    @Test
    public void squareTest2() {
        Language lan = new Language();
        Square square = new Square(6, lan.ENG(6));

        String expected = "You found a Monastery, they're broke you get nothing";

        assertEquals(expected, square.getDescription());
    }

    @Test
    public void squareTest3() {
        Language lan = new Language();
        Square square = new Square(7, lan.ENG(7));

        int expected = -70;

        assertEquals(expected, square.getChange());
    }

}