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
        while(!complete) {
            this.requestMove();
            board.printBoard();
            if(this.winOccurred()) {
                break;
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

        Square selectedSquare = board.getData()[board.getRowMap().get(rowRequest)][columnRequest];

        if(selectedSquare.isEmpty()) {
            selectedSquare.addPiece(this.player);
            this.swapPlayer();
        }
        else {
            requestMove();
        }
    }

    public boolean winOccurred() {
        return false;
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
