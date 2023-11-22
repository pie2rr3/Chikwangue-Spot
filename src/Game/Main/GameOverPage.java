package Game.Main;

import Game.Entities.Player;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameOverPage extends JPanel {

  public GameOverPage(Game game) {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    JButton menuButton = new JButton("Menu");
    JButton levelButton = new JButton("Level");
    JButton exitButton = new JButton("Exit");

    JLabel messageLabel = new JLabel("Game Over");
    messageLabel.setFont(new Font("Arial", Font.BOLD, 50));
    messageLabel.setAlignmentX(CENTER_ALIGNMENT);

    JLabel scoreLabel = new JLabel("Your score : " + Player.getScore());
    scoreLabel.setFont(new Font("Arial", Font.BOLD, 50));
    scoreLabel.setForeground(Color.RED);
    scoreLabel.setAlignmentX(CENTER_ALIGNMENT);

    JLabel bestScoreLabel = new JLabel("Best score : " + Player.getBestScore());
    bestScoreLabel.setFont(new Font("Arial", Font.BOLD, 50));
    bestScoreLabel.setForeground(Color.YELLOW);
    bestScoreLabel.setAlignmentX(CENTER_ALIGNMENT);

    JLabel waveLabel = new JLabel("Wave : " + WaveManager.getWaveIndex());
    waveLabel.setFont(new Font("Arial", Font.BOLD, 50));
    waveLabel.setForeground(Color.BLUE);
    waveLabel.setAlignmentX(CENTER_ALIGNMENT);

    Player.initPlayer();
    WaveManager.waveIndex = 1;

    menuButton.addActionListener(
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          MainMenu mainMenu = new MainMenu(game);
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

    add(Box.createVerticalStrut(20));
    add(menuButton);
    add(Box.createVerticalStrut(10));
    add(levelButton);
    add(Box.createVerticalStrut(10));
    add(exitButton);
    add(Box.createVerticalStrut(20));
    add(messageLabel);
    add(Box.createVerticalStrut(20));
    add(waveLabel);
    add(Box.createVerticalStrut(20));
    add(scoreLabel);
    add(Box.createVerticalStrut(20));
    add(bestScoreLabel);
  }
}
