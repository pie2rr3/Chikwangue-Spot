package Game.Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BottomPanel extends JPanel {

  private BottomTowersPanel bottomTowersPanel;
  public static TowerPanel towerPanel;

  public BottomPanel(
    Game game,
    PlayPage playPage,
    Consumer<Boolean> setPaused,
    Runnable stopGameLoop
  ) {
    setBackground(Color.GRAY);
    setPreferredSize(new Dimension(1500, 150));
    JButton pauseButton = new JButton("Pause");
    pauseButton.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          PausePage pausePanel = new PausePage(
            game,
            playPage,
            setPaused,
            stopGameLoop
          );
          game.setContentPane(pausePanel);
          game.revalidate();
          game.repaint();
          setPaused.accept(true);
        }
      }
    );
    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new FlowLayout());

    bottomTowersPanel = new BottomTowersPanel(game, playPage);
    towerPanel = new TowerPanel();

    mainPanel.add(towerPanel);
    mainPanel.add(pauseButton);
    mainPanel.add(bottomTowersPanel);

    add(mainPanel);
  }
}
