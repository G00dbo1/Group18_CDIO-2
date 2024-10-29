package src;

public class Account {
    private int balance;
    
    public Account(int coins){
        this.balance = coins;
        if(this.balance < 0){
            this.balance = 0;
        }
    }

    public int getBalance() {
        return this.balance;
    }

    public void updateCoin(int change){
        this.balance = this.balance + change; 
        if (this.balance + change < 0){
            this.balance = 0;
        }
    }
}
