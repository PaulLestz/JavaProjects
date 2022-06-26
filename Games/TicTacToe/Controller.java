package Games.TicTacToe;
import java.util.Scanner;

public class Controller {

    Scanner scan = new Scanner(System.in);
    private Game game;

    public void startGame() {
        Game.printIntro();

        String startingPlayer = scan.nextLine();
        game = new Game(startingPlayer);

        this.game.run();
    }
}
