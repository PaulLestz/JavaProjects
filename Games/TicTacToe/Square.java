package Games.TicTacToe;

public class Square {
    private String currentPiece = "-";
    private Location location;

    public Square(String row, int column) {
        this.location = new Location(row, column);
    }

    public boolean addPiece(String player) {
        if(this.isEmpty()) {
            this.currentPiece = player;
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return this.currentPiece == "-";
    }
}
