package Games.TicTacToe;

public class Location {
    private String row;
    private int column;

    public Location(String row, int column) {
        this.row = row;
        this.column = column;
    }

    public String getRowLabel() {
        return this.row;
    }

    public int getColumnLabel() {
        return this.column;
    }
}
