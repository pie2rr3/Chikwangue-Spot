package Game.Main;

import Game.Manual.ManualPage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenu extends JPanel {

  private JButton playButton;
  private JButton manualButton;
  private JButton exitButton;
  private JLabel copyrightLabel;

  public MainMenu(Game game) {
    this.setBackground(Color.BLACK);
    setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

    playButton = new JButton("Play");
    manualButton = new JButton("Manual");
    exitButton = new JButton("Exit");

    AmbianceMusicPlayer ambianceMusicPlayer = AmbianceMusicPlayer.getInstance();
    ambianceMusicPlayer.stopSound();
    ambianceMusicPlayer.playSound("Menu");

    playButton.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          Level level = new Level(game);
          game.setContentPane(level);
          game.revalidate();
          game.repaint();
        }
      }
    );

    manualButton.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          ManualPage manualPage = new ManualPage(game);
          game.setContentPane(manualPage);
          game.revalidate();
          game.repaint();
        }
      }
    );

    exitButton.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          System.exit(0);
        }
      }
    );

    playButton.setMaximumSize(new Dimension(200, 50));
    manualButton.setMaximumSize(new Dimension(200, 50));
    exitButton.setMaximumSize(new Dimension(200, 50));

    add(Box.createVerticalGlue());
    add(playButton);
    add(Box.createVerticalStrut(10));
    add(manualButton);
    add(Box.createVerticalStrut(10));
    add(exitButton);
    add(Box.createVerticalGlue());

    copyrightLabel = new JLabel("© Chikwangue Games");
    copyrightLabel.setAlignmentX(CENTER_ALIGNMENT);
    copyrightLabel.setForeground(Color.WHITE);

    Dimension labelSize = new Dimension(Integer.MAX_VALUE, 30);
    copyrightLabel.setMaximumSize(labelSize);

    add(Box.createVerticalStrut(20));
    add(copyrightLabel);

    game.setContentPane(this);
  }
}
