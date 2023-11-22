package Game.Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Game.Entities.Towers.Tower;

public class TowerPanel extends JPanel {

  private Tower tower = null;
  private JLabel label = new JLabel();

  public TowerPanel() {
    setBackground(Color.BLUE);
    setPreferredSize(new Dimension(500, 140));
    setLayout(new FlowLayout());
    add(label);
    label.setBounds(0, 0, getWidth(), getHeight());
  }

  private void updateLabel() {
    if (this.tower == null) {
      label.setIcon(null);
      label.setText(null);
    } else {
      label.setIcon(getImageIcon());
      label.setText(getText());
      label.setForeground(Color.WHITE);
    }
    label.repaint();
  }

  private ImageIcon getImageIcon() {
    return new ImageIcon(tower.getSprite());
  }

  private String getText() {
    
    return "<html>" + tower.getType() + " / " + "Damage: " + tower.getDamage() +
        "<br>Fire Rate: " + tower.getFireRate() + " / " + "Range: " + tower.getRange() +
        "<br>Area: " + tower.getArea() +" / "+ "Anti-Aircraft: " + tower.getAntiAircraft() +
        "<br>Strength: " + tower.getStrength() + " / " + "Effect: " + tower.getEffect() +
        "<br>Tower Level: " + tower.getTowerLevel() + " / " + "Price: " + tower.getPrice() +
        "</html>";
  }

  public void setTower(Tower towerToSet) {
    tower = towerToSet;
    updateLabel();
  }
}
