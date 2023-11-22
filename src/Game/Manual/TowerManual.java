package Game.Manual;

import Game.Entities.Towers.Tower;
import Game.Entities.Towers.TowerType.*;
import Game.Main.Game;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TowerManual extends JPanel {

  public TowerManual(Game game) {
    setLayout(new GridLayout(3, 4));
    setBackground(Color.BLACK);

    setLayout(new GridLayout(3, 4));

    Basic basicTower = new Basic(0, 0);
    Canon canonTower = new Canon(0, 0);
    Chikwangue chikwangueTower = new Chikwangue(0, 0);
    Frozen frozen = new Frozen(0, 0);
    Heat heat = new Heat(0, 0);
    MiniGun minigun = new MiniGun(0, 0);
    Missile missile = new Missile(0, 0);
    Opinel opinel = new Opinel(0, 0);
    Poison poison = new Poison(0, 0);
    Sniper sniper = new Sniper(0, 0);
    Tesla tesla = new Tesla(0, 0);

    add(
      createTowerLabel(
        "BasicTower : ",
        basicTower,
        "src/Resource/Images/Towers/Basic.png"
      )
    );
    add(
      createTowerLabel(
        "CanonTower : ",
        canonTower,
        "src/Resource/Images/Towers/Canon.png"
      )
    );
    add(
      createTowerLabel(
        "ChikwangueTower : ",
        chikwangueTower,
        "src/Resource/Images/Towers/Chikwangue.png"
      )
    );
    add(
      createTowerLabel(
        "FrozenTower : ",
        frozen,
        "src/Resource/Images/Towers/Frozen.png"
      )
    );
    add(
      createTowerLabel(
        "HeatTower : ",
        heat,
        "src/Resource/Images/Towers/Heat.png"
      )
    );
    add(
      createTowerLabel(
        "MinigunTower : ",
        minigun,
        "src/Resource/Images/Towers/MiniGun.png"
      )
    );
    add(
      createTowerLabel(
        "MissileTower : ",
        missile,
        "src/Resource/Images/Towers/Missile.png"
      )
    );
    add(
      createTowerLabel(
        "OpinelTower : ",
        opinel,
        "src/Resource/Images/Towers/Opinel.png"
      )
    );
    add(
      createTowerLabel(
        "PoisonTower : ",
        poison,
        "src/Resource/Images/Towers/Poison.png"
      )
    );
    add(
      createTowerLabel(
        "SniperTower : ",
        sniper,
        "src/Resource/Images/Towers/Sniper.png"
      )
    );
    add(
      createTowerLabel(
        "TeslaTower : ",
        tesla,
        "src/Resource/Images/Towers/Tesla.png"
      )
    );

    JButton backButton = new JButton("Manual");

    backButton.addActionListener(e -> {
      ManualPage manualPage = new ManualPage(game);
      game.setContentPane(manualPage);
      game.revalidate();
      game.repaint();
    });

    Dimension buttonSize = new Dimension(150, 60);
    backButton.setPreferredSize(buttonSize);

    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    buttonPanel.add(backButton);

    buttonPanel.setBorder(new EmptyBorder(125, 0, 0, 0));

    buttonPanel.setBackground(Color.BLACK);

    add(buttonPanel, BorderLayout.SOUTH);
  }

  private JLabel createTowerLabel(String title, Tower tower, String path) {
    try {
      ImageIcon imageIcon = new ImageIcon(path);
      JLabel label = new JLabel(imageIcon);
      label.setText(
        "<html><h1>"+title+"<h1><p><br>Damage: " +
        tower.getDamage() +
        "<br>Fire Rate: " +
        tower.getFireRate() +
        "<br>Range: " +
        tower.getRange() +
        "<br>Area: " +
        tower.getArea() +
        "<br>Anti-Aircraft: " +
        tower.getAntiAircraft() +
        "<br>Strength: " +
        tower.getStrength() +
        "<br>Effect: " +
        tower.getEffect() +
        "<br>Tower Level: " +
        tower.getTowerLevel() +
        "<br>Price: " +
        tower.getPrice() +
        "<p></html>"
      );
      label.setForeground(Color.WHITE);
      return label;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}
