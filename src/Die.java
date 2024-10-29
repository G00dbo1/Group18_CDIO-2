package src;

import java.util.Random;

public class Die {
    private int faces;
    private Random random;
    
     // Constructor
    public Dice(int facesDie1, int facesDie2) {
        this.facesDie1 = facesDie1;
        this.facesDie2 = facesDie2;
        this.random = new Random();
    }

    public int getFaceValue() {
        int rollDie1 = random.nextInt(facesDie1) + 1;
        int rollDie2 = random.nextInt(facesDie2) + 1;
        return rollDie1 + rollDie2;
    }
}
