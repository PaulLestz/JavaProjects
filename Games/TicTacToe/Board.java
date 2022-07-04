package Games.TicTacToe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

// mark things as private
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

    public static void main(String args[]) {
        Location location1 = new Location("A", 0);
        Location location2 = new Location("A", 1);
        Location location3 = new Location("A", 2);
        Location location4 = new Location("B", 0);
        Location location5 = new Location("B", 1);
        Location location6 = new Location("B", 2);
        Location location7 = new Location("C", 0);
        Location location8 = new Location("C", 1);
        Location location9 = new Location("C", 2);

        location1.getPiece().addPiece("X");
        location5.getPiece().addPiece("X");
        location9.getPiece().addPiece("X");

        Location[] row1 = { location1, location2, location3 };
        Location[] row2 = { location4, location5, location6 };
        Location[] row3 = { location7, location8, location9 };

        Location[][] locs = { row1, row2, row3 };

        Board board = new Board(locs);

        board.printBoard();

        Board skewedBoardLeft = new Board(board.skewBoard(true));

        Board skewedBoardRight = new Board(board.skewBoard(false));

        skewedBoardLeft.printBoard();
        skewedBoardRight.printBoard();

        Location[][] sk = board.skewBoard(true);

        for(int i=0; i<sk.length; i++) {
            for(int j=0; j<sk.length; j++) {
                System.out.print(skewedBoardLeft.getData()[i][j].getPiece().getPieceLabel() + " ");
            }
            System.out.println();
        }

        

        /* 
        Location[] skewedRow = board.skewRow(row3.clone(), 2, true);

        for(int i=0; i<3; i++) {
            System.out.print(skewedRow[i].getPiece().getPieceLabel() + " ");
        }
        System.out.println();
        */
    }

    public Location[][] skewBoard(boolean forDiagonalOne) {
        int rowNum = 0;
        Location[][] skewedBoard = new Location[3][3];

        for(int i = rowNum; i < board.length; i++) {
            skewedBoard[i] = skewRow(board[i].clone(), i, forDiagonalOne);
        }

        return skewedBoard;
    }

    private Location[] skewRow(Location[] row, int rowNum, boolean forDiagonalOne) {
        List<Location> rowLocs = Arrays.asList(row);

        Object[] locPieces = rowLocs.stream().map(location -> location.getPiece()).toArray();
        //List<Piece> pieceList = Arrays.asList(locPieces);
        List<Piece> pieceList = new ArrayList<Piece>();

        for(Object piece : locPieces) {
            pieceList.add((Piece) piece);
        }

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

    public void setBoard(Location[][] board) {
        this.board = board;
    }

    public void fillRowMap() {
        this.rowMap.put("A", 0);
        this.rowMap.put("B", 1);
        this.rowMap.put("C", 2);
    }

    public void printBoard() {
        System.out.println("  1 2 3");
        for(int i=0; i<3; i++) {
            System.out.print(this.rows[i] + " ");
            for(int j=0; j<3; j++) {
                System.out.print(this.board[i][j].getPiece().getPieceLabel() + " ");
            }
            System.out.println();
        }
    }


    public void printLabels() {
        System.out.println("  1  2  3");
        for(int i=0; i<3; i++) {
            System.out.print(rows[i] + " ");
            for(int j=0; j<3; j++) {
                System.out.print(board[i][j].getLabel() + " ");
            }
            System.out.println();
        }
    }
}
