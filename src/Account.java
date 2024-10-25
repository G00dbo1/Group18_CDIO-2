package src;

public class Account {
    int balance;
    
    Account(int coins){
        this.balance = coins;
    }

    void updateCoin(int change){
        this.balance = this.balance + change; 
        if (this.balance + change < 0){
            this.balance = 0;
        }
    }
}
