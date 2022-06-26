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
        }
    }

    public void requestMove() {
        
    }

    public static void printIntro() {
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("Enter your player: \"X\" or \"O\"");
    }
}
