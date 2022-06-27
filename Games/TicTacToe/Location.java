package Games.TicTacToe;

public class Location {
    private String row;
    private int column;

    public Location(String row, int column) {
        this.row = row;
        this.column = column;
    }

    public <T> boolean isAt(T specification) {
        
    }

    public String toString() {
        return row + Integer.toString(column);
    }
}
