package src;
// Player's position
public class Player {
    private int position;
    // Start's player in position 1
    public Player(int position = 1;) {
        this.position = position;
    }
    // Pull's the information about the current position
    public int getPosition() {
        return this.position;
    }
    // Updates the position within 1-12 range
    public void updatePosition(int dice){
        this.position = ((this.position + dice - 1) % 12) + 1;
    }
}

