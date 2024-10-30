package src;

public class Square {
    private int id;
    private String description;
    private int change;
    private int[] squareChange = new int[] {250, -100, 100, -20, 180, 0, -70, 60, -80, -50, 650};
    

    public Square(int id, String description) {
        this.id = id;
        this.description = description;
        this.change = squareChange[this.id];
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
