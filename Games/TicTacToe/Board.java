package Games.TicTacToe;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Board {
    
    private Location[][] board = new Location[3][3];

    private String[] rows = { "A", "B", "C" };
    private HashMap<String, Integer> rowMap = new HashMap<String, Integer>();

    public Board() {
        this.fillRowMap();
        this.createBoard();
    }

    public Board(Location[][] builtBoard) {
        this.fillRowMap();
        this.board = builtBoard;
    }

    public void createBoard() {
        int[] columns = {0, 1, 2};

        for(String row : rows) {
            for(int column: columns) {
                Location thisLoc = new Location(row, column);
                board[this.rowMap.get(row)][column] = thisLoc;
            }
        }
    }

    public Location[][] skewBoard(boolean forDiagonalOne) {
        int rowNum = 0;
        Location[][] skewedBoard = new Location[3][3];

        for(int i = rowNum; i < board.length; i++) {
            skewedBoard[i] = skewRow(board[i].clone(), i, forDiagonalOne);
        }

        return skewedBoard;
    }

    public Location[] skewRow(Location[] row, int rowNum, boolean forDiagonalOne) {
        List<Location> rowLocs = Arrays.asList(row);

        Piece[] locPieces = (Piece[]) rowLocs.stream().map(location -> location.getPiece()).toArray();
        List<Piece> pieceList = Arrays.asList(locPieces);

        Collections.rotate(pieceList, forDiagonalOne ? -rowNum : rowNum); 

        for(int i=0; i < rowLocs.size(); i++) {
            rowLocs.get(i).setPiece(pieceList.get(i));
        }

        return rowLocs.toArray(row);
    }

    public Location[][] getData() {
        return board;
    }

    public HashMap<String, Integer> getRowMap() {
        return rowMap;
    }

    public Location[] getLocations() {
        int slot = 0;
        Location[] squares = new Location[9];
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                squares[slot] = board[i][j];
                slot++;
            }
        }
        return squares;
    }

    public void setBoard(Location[][] newBoard) {
        this.board = newBoard;
    }

    public void fillRowMap() {
        this.rowMap.put("A", 0);
        this.rowMap.put("B", 1);
        this.rowMap.put("C", 2);
    }

    public void printBoard() {
        System.out.println("  1 2 3");
        for(int i=0; i<3; i++) {
            System.out.print(rows[i] + " ");
            for(int j=0; j<3; j++) {
                System.out.print(board[i][j].getPiece().getPieceLabel() + " ");
            }
            System.out.println();
        }
    }
}
