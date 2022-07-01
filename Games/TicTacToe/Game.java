package Games.TicTacToe;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {

    Scanner scan = new Scanner(System.in);

    private String player;
    private Board board;

    private boolean complete = false;

    public Game(String player) {
        this.player = player;
        this.board = new Board();
    }

    public void run() {
        board.printBoard();
        while(!complete) {
            this.requestMove();
            board.printBoard();
            if(this.winOccurred()) {
                System.out.println("Player " + player + " wins!");
                complete = true;
            }
            this.swapPlayer();
        }
    }

    // Implement incorrect move entry format
    private void requestMove() {
        System.out.print("Player " + player + ", select your move: ");
        String move = scan.nextLine();

        String rowRequest = move.substring(0,1);
        // Implement parseInt errors
        int columnRequest = Integer.parseInt(move.substring(1,2));

        Square selectedSquare = board.getData()[board.getRowMap().get(rowRequest)][columnRequest - 1];

        if(selectedSquare.isEmpty()) {
            selectedSquare.addPiece(this.player);
        }
        else {
            System.out.println("Location occupied. Please try another.");
            requestMove();
        }
    }

    private boolean winOccurred() {

        Object[] winLocations = { "A", "B", "C", new Integer(0) , new Integer(1) , new Integer(2) };

        for(Object loc: winLocations) {
            if(this.winOccurredAt(loc)) {
                return true;
            }
        }

        if(this.diagonalWin()) {
            return true;
        }

        return false;
    }

    private <T> boolean winOccurredAt(T location) {

        Square[] squares = board.getSquares();

        Square[] locSquares = new Square[3];

        int slot = 0;

        for(int i=0; i<squares.length; i++) {
            if(squares[i].getLocation().hasLoc(location)) {
                locSquares[slot] = squares[i];
                slot++;
            }
        }

        List<Square> list = Arrays.asList(locSquares);

        Object[] locSquaresLabels = list.stream()
                                         .map(square -> square.getPieceLabel())
                                         .distinct()
                                         .toArray();

        return locSquaresLabels.length == 1 && !locSquaresLabels[0].equals("-");
    }

    private boolean diagonalWin() {
        Board skewedBoardLeft = new Board(board.skewBoard(true));

        Board skewedBoardRight = new Board(board.skewBoard(false));
    
        Square[] diagonalOneSquares = skewedBoardLeft.getSquares();
        Square[] diagonalTwoSquares = skewedBoardRight.getSquares();

        return this.winOcc
        
        /* 
        if() {
            return true;
        }

        if() {
            return true;
        }
        */
        return false;
    }

    private void swapPlayer() {
        if(player.equals("X")) {
            player = "O";
        }
        else {
            player = "X";
        }
    }

    public static void printIntro() {
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("Enter Moves in a Similar Format to: A1");
        System.out.print("Enter your player: \"X\" or \"O\": ");
    }
}
