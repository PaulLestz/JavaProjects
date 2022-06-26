package Games.TicTacToe;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {

        Controller controller = new Controller();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your player: \"X\" or \"O\"");
        String player = scanner.nextLine();

        controller.startGame(player);
    }

}