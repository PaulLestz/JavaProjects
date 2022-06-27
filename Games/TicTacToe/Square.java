package Games.TicTacToe;

public class Square {
    private String currentPiece = "-";
    private Location location;

    public Square(String row, int column) {
        this.location = new Location(row, column);
    }

    public void addPiece(String player) {
        this.currentPiece = player;
    }

    public boolean isEmpty() {
        return this.currentPiece.equals("-");
    }

    public String getPieceLabel() {
        return this.currentPiece;
    }

    public Location getLocation() {
        return this.location;
    }
}
