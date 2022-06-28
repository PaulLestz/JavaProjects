package Games.TicTacToe;
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
                complete = true;
            }
        }
    }

    // Implement incorrect move entry format
    public void requestMove() {
        System.out.print("Player " + player + ", select your move: ");
        String move = scan.nextLine();

        String rowRequest = move.substring(0,1);
        // Implement parseInt errors
        int columnRequest = Integer.parseInt(move.substring(1,2));

        Square selectedSquare = board.getData()[board.getRowMap().get(rowRequest)][columnRequest - 1];

        if(selectedSquare.isEmpty()) {
            selectedSquare.addPiece(this.player);
            this.swapPlayer();
        }
        else {
            System.out.println("Location occupied. Please try another.");
            requestMove();
        }
    }

    public boolean winOccurred() {

        // combine into one using generics?
        String[] winRows = { "A", "B", "C" };
        int[] winColumns = { 1, 2, 3 };

        for(String row: winRows) {
            if(this.winOccurredAt(row)) {
                return true;
            }
        }

        for(int column: winColumns) {
            if(this.winOccurredAt(column)) {
                return true;
            }
        }

        return false;
    }

    public <T> boolean winOccurredAt(T location) {

        Square[] squares = board.getSquares();

        Square[] locSquares = new Square[3];

        int slot = 0;

        System.out.println("made it to: " + location);
        for(int i=0; i<squares.length; i++) {
            System.out.println(i + "complete");
            if(squares[i].getLocation().hasLoc(location)) {
                locSquares[slot] = squares[i];
                slot++;
            }
            System.out.println(i + "complete after");
        }

        for(Square square: locSquares) {
            System.out.print(square.getPieceLabel());
        }
        System.out.println("reached" + location);

        // try to simplify with HOF (map, fold)
        return locSquares[0].getPieceLabel().equals(locSquares[1].getPieceLabel()) &&
               locSquares[1].getPieceLabel().equals(locSquares[2].getPieceLabel()) &&
               !locSquares[0].getPieceLabel().equals("-");
    }

    public void swapPlayer() {
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
