package Game.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PausePage extends JPanel {

  public PausePage(
    Game game,
    PlayPage playPage,
    Consumer<Boolean> setPaused,
    Runnable stopGameLoop
  ) {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    JButton resumeButton = new JButton("Resume");
    JButton menuButton = new JButton("Menu");
    JButton levelButton = new JButton("Level");
    JButton exitButton = new JButton("Exit");

    resumeButton.addActionListener(
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          setPaused.accept(false);
          game.setContentPane(playPage);
          game.revalidate();
          game.repaint();
        }
      }
    );

    menuButton.addActionListener(
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          MainMenu mainMenu = new MainMenu(game);
          stopGameLoop.run();
          game.setContentPane(mainMenu);
          game.revalidate();
          game.repaint();
        }
      }
    );

    levelButton.addActionListener(
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          Level levelPanel = new Level(game);
          stopGameLoop.run();
          game.setContentPane(levelPanel);
          game.revalidate();
          game.repaint();
        }
      }
    );

    exitButton.addActionListener(
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          System.exit(0);
        }
      }
    );

    add(resumeButton);
    add(Box.createVerticalStrut(10));
    add(menuButton);
    add(Box.createVerticalStrut(10));
    add(levelButton);
    add(Box.createVerticalStrut(10));
    add(exitButton);
  }
}
