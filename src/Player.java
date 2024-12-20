package src;

public class Player {
    private int position;
    private Account account;

    public Player() {
        this.position = 0;
        this.account = new Account(1000);
    }


    public int getPosition() {
        return this.position;
    }


    public void SetPosition(int change) {
        this.position = (this.position + change) % 12; 
    }


    public int getCoins() {
        return account.getBalance();
    }


    public void updateCoins(int change) {
        account.updateCoin(change);
    }
}

