package Games.TicTacToe;

public class Location {
    private String row;
    private int column;
    private Piece piece;

    public Location(String row, int column) {
        this.row = row;
        this.column = column;
        this.piece = new Piece();
    }

    public <S> boolean hasLoc(S location) {
        if(location instanceof String) {
            return row.equals(location);
        }
        else if(location instanceof Integer) {
            return new Integer(column).equals(location);
        }
        else {
            //throw error instead
            return false;
        }
    }
    
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return this.piece;
    }

}
