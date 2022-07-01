package Games.TicTacToe;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Board {
    
    private Square[][] board = new Square[3][3];

    private String[] rows = {"A", "B", "C"};
    private HashMap<String, Integer> rowMap = new HashMap<String, Integer>();

    public Board() {
        this.fillRowMap();
        this.createBoard();
    }

    public Board(Square[][] builtBoard) {
        this.fillRowMap();
        this.board = builtBoard;
    }

    public void createBoard() {
        int[] columns = {0, 1, 2};

        for(String row : rows) {
            for(int column: columns) {
                Square thisSquare = new Square(row, column);
                board[this.rowMap.get(row)][column] = thisSquare;
            }
        }
    }

    public Square[][] skewBoard(boolean forDiagonalOne) {
        int rowNum = 0;
        Square[][] skewedBoard = new Square[3][3];

        for(int i = rowNum; i < board.length; i++) {
            skewedBoard[i] = skewRow(board[i], rowNum, forDiagonalOne);
        }

        return skewedBoard;
    }

    public Square[] skewRow(Square[] row, int rowNum, boolean forDiagonalOne) {
        List<Square> tempRow = Arrays.asList(row);

        Collections.rotate(tempRow, forDiagonalOne ? -rowNum : rowNum);
        
        row = tempRow.toArray(row);
        return row;
        /* 
        if(rowNum == 0) {
            return row; 
        }
        else {
            //skewRow(shiftRow(row), rowNum - 1);
            Collections.rotate(row, rowNum);
        }
        */
    }
    /* 
    public Square[] shiftRow(Square[] row) {

    }*/

    public Square[][] getData() {
        return board;
    }

    public HashMap<String, Integer> getRowMap() {
        return rowMap;
    }

    public Square[] getSquares() {
        int slot = 0;
        Square[] squares = new Square[9];
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                squares[slot] = board[i][j];
                slot++;
            }
        }
        return squares;
    }

    public void setBoard(Square[][] newBoard) {
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
                System.out.print(board[i][j].getPieceLabel() + " ");
            }
            System.out.println();
        }
    }
}
