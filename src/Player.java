package src;

public class Player {
    private int position = 1;
    private Account account;


    public Player() {
        this.account = new Account(1000);
    }


    public int getPosition() {
        return this.position;
    }


    public void SetPosition(int change) {
        if ((this.position + change) % 12 == 0) {
            this.position = 12;
        } else {
            this.position = (this.position + change) % 12;
        }
    }


    public int getCoins() {
        return account.getBalance();
    }


    public void updateCoins(int change) {
        account.updateCoin(change);
    }
}

