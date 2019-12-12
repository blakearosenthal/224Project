/**
 * Dungeon Game is an RPG style dungeon crawling game that features
 * a turn-based combat system. The goal of the game is to clear as
 * many dungeons as possible.
 * Course: CPSC 224, Fall 2019
 * Group Programming Project
 * No sources to cite.
 *
 * @author Blake Rosenthal and Dennis Hu
 * @version v1.0 11/9/19
 */

public class GameTester {
    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);
    }
}
