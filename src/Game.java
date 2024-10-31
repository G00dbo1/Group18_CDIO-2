package src;
import java.util.Scanner;

public class Game {
    private Scanner scanner;
    private Player player1;
    private Player player2;
    private Die die1;
    private Die die2;
    private Square[] squares = new Square[12];
    private Language lan = new Language();
    
    public Game(int die1_faces, int die2_faces, Scanner scanner) {
        this.player1 = new Player();
        this.player2 = new Player();

        this.die1 = new Die(die1_faces);
        this.die2 = new Die(die2_faces);

        for (int i = 0; i < 12; i++) {
            this.squares[i] = new Square(i, this.lan.squares_ENG(i));
        }

        this.scanner = scanner;
    }


    public static void main(String[] args) {
        Scanner initScanner = new Scanner(System.in);
        initScanner.useLocale(java.util.Locale.ENGLISH);

        System.out.println("Please enter the amount of faces you would like your first die to have: ");
        int die1_faces = Integer.parseInt(initScanner.nextLine());

        System.out.println("Please enter the amount of faces you would like your second die to have: ");
        int die2_faces = Integer.parseInt(initScanner.nextLine());

        System.out.println("Please enter your prefered language (format: ENG): ");
        String lan = initScanner.nextLine().toUpperCase();
        
        if (lan.equals("ENG")) {
            Game gameConsoller = new Game(die1_faces, die2_faces, initScanner);
            gameConsoller.playGame();
        } 
        else {
            System.out.println("Not a valid langauge"); 
        }
    }


    public void playGame() {
        while (true) {
            waitEnter();
            // Displays which players turn it is
            System.out.println(print(1));
            takeTurn(this.player1);
            if (hasWon(player1)) {
                // Displays who won
                System.out.println(print(4));
                scanner.close();
                break;
            }

            waitEnter();
            // Displays which players turn it is
            System.out.println(print(2));
            takeTurn(this.player2);
            if (hasWon(player2)) {
                // Displays who won
                System.out.println(print(5));
                scanner.close();
                break;
            }
        }
    }


    private void takeTurn(Player player) {
        die1.roll();
        die2.roll();
        int sum = die1.getFaceValue() + die2.getFaceValue();

        // Displays the roll
        System.out.println("\t" + print(6) + "(" + die1.getFaceValue() + ", " + die2.getFaceValue() + ")" + " = " + sum);
        // Displays the square the player landed on
        System.out.println("\t" + print(7) + player.getPosition());

        player.SetPosition(sum);
        int playerPos = player.getPosition();
        Square tempSqaure = this.squares[playerPos];
        player.updateCoins(tempSqaure.getChange());

        // Displays the square the player landed on
        System.out.println("\t" + print(8) + playerPos);
        // Displays the description
        System.out.println("\t" + tempSqaure.getDescription());
        // Displays the players current coins
        System.out.println("\t" + print(3) + player.getCoins() + "\n");

        if (tempSqaure.getId() == 9) {
            takeTurn(player);
        }
    }


    private void waitEnter() {
        System.out.println(print(0));
        this.scanner.nextLine();
    }


    private String print(int id) {
        return this.lan.gameFlow_ENG(id);
    }


    private boolean hasWon(Player player) {
        if (player.getCoins() >= 3000) {
            return true; 
        }
        return false;
    }

}
