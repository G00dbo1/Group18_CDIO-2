package src;

public class Account {
    int balance;
    
    Account(int coins){
        this.balance = coins;
    }

    Void updateCoin(int change){
        this.balance = this.balance + change; 
        if (this.balance + a < 0){
            this.balance = 0;
        }
    }
}
