package src;

public class Game {
    private Player player1;
    private Player player2;
    private Die die1;
    private Die die2;
    private Square[] squares = new Square[12];
    
    public Game() {
        Language lan = new Language();
        for (int i = 0; i < 12; i++) {
            this.squares[i] = new Square(i, lan.ENG(i));
        }
    }
}
