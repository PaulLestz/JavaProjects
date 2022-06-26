package Games.TicTacToe;

import java.util.HashMap;

public class Board {
    
    private Square[][] board;
    private HashMap<String, Integer> rowMap;

    public Board() {
        this.fillRowMap();
        this.createBoard();
    }

    public void createBoard() {
        String[] rows = {"A", "B", "C"};
        int[] columns = {0, 1, 2};


        for(String row : rows) {
            for(int column: columns) {
                Square thisSquare = new Square(row, column);
                board[this.rowMap.get(row)][column] = thisSquare;
            }
        }
    }

    public Square[][] getData() {
        return board;
    }

    public HashMap<String, Integer> getRowMap() {
        return rowMap;
    }

    public void fillRowMap() {
        this.rowMap.put("A", 0);
        this.rowMap.put("B", 1);
        this.rowMap.put("C", 2);
    }

    public void printBoard() {
        System.out.println("  1 2 3");
        for(int i=0; i<3; i++) {
            System.out.print(i + " ");
            for(int j=0; j<3; j++) {
                System.out.print(board[i][j].getPieceLabel() + " ");
            }
            System.out.println();
        }
    }
}
