package src;
import java.util.Scanner;

public class Game {
    private Scanner scanner = new Scanner(System.in);
    private Player player1;
    private Player player2;
    private Die die1;
    private Die die2;
    private Square[] squares = new Square[12];
    
    public Game(int die1_faces, int die2_faces) {
        this.player1 = new Player();
        this.player2 = new Player();

        this.die1 = new Die(die1_faces);
        this.die2 = new Die(die2_faces);

        Language lan = new Language();
        for (int i = 0; i < 12; i++) {
            this.squares[i] = new Square(i, lan.ENG(i));
        }
    }


    public static void main(String[] args) {
        Game gameConsoller = new Game(6, 6);
        gameConsoller.playGame();
    }


    public void playGame() {
        while (true) {
            takeTurn(this.player1);
            if (hasWon()) {
                break;
            }

            this.scanner.hasNext();

            takeTurn(this.player2);
            if (hasWon()) {
                break;
            }
        }
    }


    private void takeTurn(Player player) {
        
    }


    private boolean hasWon() {
        if (this.player1.getCoins() >= 3000) {
            return true; 
        }
        return false;
    }
}
