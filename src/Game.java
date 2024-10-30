package src;
import java.util.Scanner;

public class Game {
    private Scanner scanner = new Scanner(System.in);
    private Player player1;
    private Player player2;
    private Die die1;
    private Die die2;
    private Square[] squares = new Square[12];
    private Language lan = new Language();
    
    public Game(int die1_faces, int die2_faces) {
        this.player1 = new Player();
        this.player2 = new Player();

        this.die1 = new Die(die1_faces);
        this.die2 = new Die(die2_faces);

        for (int i = 0; i < 12; i++) {
            this.squares[i] = new Square(i, this.lan.ENG(i));
        }
    }


    public static void main(String[] args) {
        Game gameConsoller = new Game(6, 6);
        gameConsoller.playGame();
    }


    public void playGame() {
        while (true) {
            waitEnter();
            // Displays which players turn it is
            System.out.println(this.lan.gameFlow_ENG(1));
            takeTurn(this.player1);
            if (hasWon(player1)) {
                // Displays who won
                System.out.println(this.lan.gameFlow_ENG(4));
                break;
            }

            waitEnter();
            // Displays which players turn it is
            System.out.println(this.lan.gameFlow_ENG(2));
            takeTurn(this.player2);
            if (hasWon(player2)) {
                // Displays who won
                System.out.println(this.lan.gameFlow_ENG(5));
                break;
            }
        }
    }


    private void takeTurn(Player player) {
        die1.roll();
        die2.roll();

        player.SetPosition(die1.getFaceValue() + die2.getFaceValue());
        int playerPos = player.getPosition();
        Square tempSqaure = this.squares[playerPos];
        player.updateCoins(tempSqaure.getChange());

        // Displays the description
        System.out.println("\t" + tempSqaure.getDescription());
        // Displays the players current coins
        System.out.println("\t" + this.lan.gameFlow_ENG(3) + player.getCoins() + "\n");

        if (tempSqaure.getId() == 9) {
            takeTurn(player);
        }
    }


    private boolean hasWon(Player player) {
        if (player.getCoins() >= 3000) {
            return true; 
        }
        return false;
    }


    private void waitEnter() {
        System.out.println(this.lan.gameFlow_ENG(0));
        this.scanner.nextLine();
    }
}
