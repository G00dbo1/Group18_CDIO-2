package src;

public class Square {
    private int id;
    private String description;
    private int change;

    public Square(int id, String description, int change) {
        this.id = id;
        this.description = description;
        this.change = change;
    }

    public int getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public int getChange() {
        return this.change;
    }


}
