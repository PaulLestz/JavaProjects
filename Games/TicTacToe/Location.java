package Games.TicTacToe;

public class Location {
    private String row;
    private int column;

    public Location(String row, int column) {
        this.row = row;
        this.column = column;
    }

    public <S> boolean hasLoc(S location) {
        if(location instanceof String) {
            return row.equals(location);
        }
        else if(location instanceof Integer) {
            return new Integer(column) == location;
        }
        else {
            //throw error instead
            return false;
        }
    }

    public String toString() {
        return row + Integer.toString(column);
    }
}
