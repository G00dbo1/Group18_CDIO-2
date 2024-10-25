package src;

public class Square {
    int id;
    String description;
    int change;

    Square(int id, String description, int change) {
        this.id = id;
        this.description = description;
        this.change = change;
    }

    int getId() {
        return this.id;
    }

    String getDescription() {
        return this.description;
    }

    int getChange() {
        return this.change;
    }


}
