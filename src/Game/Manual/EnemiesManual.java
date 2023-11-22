package Game.Manual;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Game.Entities.Enemies.Enemy;
import Game.Entities.Enemies.EnemyType.Arrow;
import Game.Entities.Enemies.EnemyType.Chikwangon;
import Game.Entities.Enemies.EnemyType.Chillagon;
import Game.Entities.Enemies.EnemyType.Circle;
import Game.Entities.Enemies.EnemyType.Cross;
import Game.Entities.Enemies.EnemyType.Heart;
import Game.Entities.Enemies.EnemyType.Kite;
import Game.Entities.Enemies.EnemyType.Octagon;
import Game.Entities.Enemies.EnemyType.Pentagon;
import Game.Entities.Enemies.EnemyType.Rhombus;
import Game.Entities.Enemies.EnemyType.Square;
import Game.Entities.Enemies.EnemyType.Star;
import Game.Entities.Enemies.EnemyType.Trapeze;
import Game.Entities.Enemies.EnemyType.Triangle;
import Game.Main.Game;

public class EnemiesManual extends JPanel {

  public EnemiesManual(Game game) {
    setLayout(new GridLayout(4, 3));
    setBackground(Color.GRAY);

    List<Entry<Integer, Integer>> defaultRoute = new ArrayList<>();
    defaultRoute.add(new AbstractMap.SimpleEntry<>(0, 0));

    Arrow arrow = new Arrow(defaultRoute);
    Chikwangon chikwangon = new Chikwangon(defaultRoute);
    Chillagon chillagon = new Chillagon(defaultRoute);
    Circle circle = new Circle(defaultRoute);
    Cross cross = new Cross(defaultRoute);
    Heart heart = new Heart(defaultRoute);
    Kite kite = new Kite(defaultRoute);
    Octagon octagon = new Octagon(defaultRoute);
    Pentagon pentagon = new Pentagon(defaultRoute);
    Rhombus rhombus = new Rhombus(defaultRoute);
    Square square = new Square(defaultRoute);
    Star star = new Star(defaultRoute);
    Trapeze trapeze = new Trapeze(defaultRoute);
    Triangle triangle = new Triangle(defaultRoute);

    add(createEnemyLabel(arrow));
    add(createEnemyLabel(chikwangon));
    add(createEnemyLabel(chillagon));
    add(createEnemyLabel(circle));
    add(createEnemyLabel(cross));
    add(createEnemyLabel(heart));
    add(createEnemyLabel(kite));
    add(createEnemyLabel(octagon));
    add(createEnemyLabel(pentagon));
    add(createEnemyLabel(rhombus));
    add(createEnemyLabel(square));
    add(createEnemyLabel(star));
    add(createEnemyLabel(trapeze));
    add(createEnemyLabel(triangle));

    setBorder(new EmptyBorder(10, 10, 10, 10));

    JButton backButton = new JButton("Manual");
    backButton.addActionListener(e -> {
      ManualPage manualPage = new ManualPage(game);
      game.setContentPane(manualPage);
      game.revalidate();
      game.repaint();
    });

    backButton.setPreferredSize(new Dimension(150, 60));

    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    buttonPanel.add(backButton);
    buttonPanel.setBackground(Color.GRAY);
    add(buttonPanel);

  }

  private JLabel createEnemyLabel(Enemy enemy) {
    ImageIcon imageIcon = new ImageIcon(enemy.getImage());
    JLabel label = new JLabel(enemy.getClass().getSimpleName(), imageIcon, JLabel.CENTER);
    label.setHorizontalTextPosition(JLabel.CENTER);
    label.setVerticalTextPosition(JLabel.BOTTOM);
    label.setForeground(Color.WHITE);
    label.setText(String.format(
        "<html>%s<br>Speed: %.2f<br>Life: %d<br>Flying: %b<br>Income: %d<br>Weakness: %s<br>Resistance: %s</html>",
        enemy.getClass().getSimpleName(),
        enemy.getSpeed(),
        enemy.getLife(),
        enemy.getFly(),
        enemy.getIncome(),
        enemy.getWeakness(),
        enemy.getResistance()
    ));
    return label;
}


}