package Games.TicTacToe;

public class Piece {
    private String currentPiece = "-";

    public void addPiece(String player) {
        this.currentPiece = player;
    }

    public boolean isEmpty() {
        return this.currentPiece.equals("-");
    }

    public String getPieceLabel() {
        return this.currentPiece;
    }

}
