package Games.TicTacToe;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Board {
    
    private Square[][] board = new Square[3][3];

    private String[] rows = { "A", "B", "C" };
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

    public static void main(String args[]) {
        Square square1 = new Square("A", 0);
        Square square2 = new Square("A", 1);
        Square square3 = new Square("A", 2);
        Square square4 = new Square("B", 0);
        Square square5 = new Square("B", 1);
        Square square6 = new Square("B", 2);
        Square square7 = new Square("C", 0);
        Square square8 = new Square("C", 1);
        Square square9 = new Square("C", 2);

        Square[] squares1 = { square1, square2, square3 };
        Square[] squares2 = { square4, square5, square6 };
        Square[] squares3 = { square7, square8, square9 };

        squares1[0].addPiece("X");
        squares1[1].addPiece("-");
        squares1[2].addPiece("-");
        squares2[0].addPiece("-");
        squares2[1].addPiece("X");
        squares2[2].addPiece("-");
        squares3[0].addPiece("-");
        squares3[1].addPiece("-");
        squares3[2].addPiece("X");

        Square[][] squares = { squares1, squares2, squares3 };

        Board testBoard = new Board(squares);

        Square[][] skewed = testBoard.skewBoard(true);

        testBoard.setBoard(skewed);

        testBoard.printBoard();
    }

    public Square[][] skewBoard(boolean forDiagonalOne) {
        int rowNum = 0;
        Square[][] skewedBoard = new Square[3][3];

        for(int i = rowNum; i < board.length; i++) {
            skewedBoard[i] = skewRow(board[i].clone(), i, forDiagonalOne);
        }

        return skewedBoard;
    }

    public Square[] skewRow(Square[] row, int rowNum, boolean forDiagonalOne) {
        List<Square> tempRow = Arrays.asList(row);

        Collections.rotate(tempRow, forDiagonalOne ? -rowNum : rowNum);
        
        Square[] skewedRow = new Square[3];

        return tempRow.toArray(skewedRow);
        //row = tempRow.toArray(row);
        //return row;
    }

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
