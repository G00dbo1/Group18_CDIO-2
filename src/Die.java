package src;

import java.util.Random;

public class Die {
    private int faceValue;
    private int amountFaces;
    private Random random;
    
     // Constructor
    public Die(int amountFaces) {
        this.random = new Random();
        this.amountFaces = amountFaces;
        this.faceValue = random.nextInt(amountFaces) + 1;
    }

    public int getFaceValue() {
        return this.faceValue;
    }

    public void roll() {
        this.faceValue = random.nextInt(amountFaces) + 1;
    }

}
