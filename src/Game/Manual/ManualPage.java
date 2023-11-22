package Game.Manual;

import Game.Main.Game;
import Game.Main.MainMenu;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ManualPage extends JPanel {

  public ManualPage(Game game) {
    this.setBackground(Color.BLACK);
    setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

    JButton enemiesButton = new JButton("Enemies");
    JButton towerButton = new JButton("Towers");
    JButton backButton = new JButton("Menu");
    JButton mapButton = new JButton("Map");

    Font buttonFont = new Font("Arial", Font.PLAIN, 18);
    enemiesButton.setFont(buttonFont);
    towerButton.setFont(buttonFont);
    backButton.setFont(buttonFont);
    mapButton.setFont(buttonFont);

    enemiesButton.addActionListener(
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          EnemiesManual EnemyPage = new EnemiesManual(game);
          game.setContentPane(EnemyPage);
          game.revalidate();
          game.repaint();
        }
      }
    );

    towerButton.addActionListener(e -> {
      TowerManual towerPage = new TowerManual(game);
      game.setContentPane(towerPage);
      game.revalidate();
      game.repaint();
    });

    backButton.addActionListener(
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

    mapButton.addActionListener(
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          MapManual mapPage = new MapManual(game);
          game.setContentPane(mapPage);
          game.revalidate();
          game.repaint();
        }
      }
    );

    JPanel buttonPanel = new JPanel(new GridBagLayout());
    buttonPanel.setBackground(Color.BLACK);

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.insets = new Insets(0, 0, 10, 0);
    gbc.anchor = GridBagConstraints.CENTER;

    buttonPanel.add(enemiesButton, gbc);

    gbc.gridy++;
    buttonPanel.add(towerButton, gbc);

    gbc.gridy++;
    buttonPanel.add(mapButton, gbc);

    gbc.gridy++;
    buttonPanel.add(backButton, gbc);

    add(Box.createVerticalStrut(20));
    add(buttonPanel);

    game.setContentPane(this);
  }
}
