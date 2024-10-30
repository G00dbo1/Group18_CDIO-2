package src;

public class Language {
    public String ENG(int _id) {
        String desc = "";
        
        switch (_id) {
            case 0 -> desc += "You found nothing";
            case 1 -> desc += "You found a Tower and you loot it for 250 coins";
            case 2 -> desc += "You fall into a Crater, you lose 100 coins";
            case 3 -> desc += "You found the Palace gates and gets payed 100 coins to work inside";
            case 4 -> desc += "You found a Cold Desert, that shit cold you lose 20 coins";
            case 5 -> desc += "You found the Walled City and find a wallet with 180 coins";
            case 6 -> desc += "You found a Monastery, they're broke you get nothing";
            case 7 -> desc += "You found a Black cave, that shit dark as fuck you walk into the walls and lose 70 coins";
            case 8 -> desc += "You found the Huts in the moutain, they're happy to see people that are not ugly, you get 60 coins";
            case 9 -> desc += "You walk into the Werewall (werewolf-wall) you get robbed and lose 80 coins but you get another turn because the opponent is sad for you";
            case 10 -> desc += "You do a sick trick on your house but fall off into the pit, you lose 50 coins";
            case 11 -> desc += "You found a Goldmine, which weridly doesn't have any gold but 650 coins";
        }

        return desc;
    }


    public String gameFlow_ENG(int _id) {
        String text = "";
        
        switch (_id) {
            case 0 -> text += "\n__________________________\nPress enter to continue.....\n__________________________\n";
            case 1 -> text += "Player 1' turn:";
            case 2 -> text += "Player 2' turn:";
            case 3 -> text += "Amount coins: ";
            case 4 -> text += "The Game has ended\nPlayer 1 was the first to get ahold of 3000 or more coins\nPlayer 1 won\n";
            case 5 -> text += "The Game has ended\nPlayer 2 was the first to get ahold of 3000 or more coins\nPlayer 2 won\n";
        }

        return text;
    }


    public String DK(int _id) {
        // Insert description values for the diffent cases in the correct langauage.
        String desc = "";
        switch (_id) {
            case 1 -> desc += "";
            case 2 -> desc += "";
            case 3 -> desc += "";
            case 4 -> desc += "";
            case 5 -> desc += "";
            case 6 -> desc += "";
            case 7 -> desc += "";
            case 8 -> desc += "";
            case 9 -> desc += "";
            case 10 -> desc += "";
            case 11 -> desc += "";
            case 12 -> desc += "";
        }

        return desc;
    }
}
