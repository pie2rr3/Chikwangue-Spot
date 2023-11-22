package Game.Main;

import javax.swing.JFrame;

public class Game extends JFrame {

  private MainMenu mainMenu;

  public Game() {
    setSize(1500, 950);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    mainMenu = new MainMenu(this);
    setMainMenu();
  }

  public void setMainMenu() {
    setContentPane(mainMenu);
    mainMenu.setVisible(true);
  }

  public static void main(String[] args) {
    Game game = new Game();
    game.setVisible(true);
  }
}
