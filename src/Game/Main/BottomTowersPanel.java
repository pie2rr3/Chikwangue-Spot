package Game.Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Game.Entities.Towers.Tower;
import Game.Entities.Towers.TowerType.Basic;
import Game.Entities.Towers.TowerType.Canon;
import Game.Entities.Towers.TowerType.Chikwangue;
import Game.Entities.Towers.TowerType.Frozen;
import Game.Entities.Towers.TowerType.Heat;
import Game.Entities.Towers.TowerType.MiniGun;
import Game.Entities.Towers.TowerType.Missile;
import Game.Entities.Towers.TowerType.Poison;
import Game.Entities.Towers.TowerType.Sniper;
import Game.Entities.Towers.TowerType.Tesla;

public class BottomTowersPanel extends JPanel {

  public static Tower.Type selectedType;

  public BottomTowersPanel(Game game, PlayPage playPage) {
    setBackground(Color.RED);
    setPreferredSize(new Dimension(500, 140));
    setLayout(new FlowLayout());

    ImageIcon basicImage = new ImageIcon(Basic.getImage());
    JButton basic = new JButton(basicImage);
    basic.addActionListener(e -> selectedType = Tower.Type.BASIC);
    ImageIcon canonImage = new ImageIcon(Canon.getImage());
    JButton canon = new JButton(canonImage);
    canon.addActionListener(e -> selectedType = Tower.Type.CANON);
    ImageIcon chikwangueImage = new ImageIcon(Chikwangue.getImage());
    JButton chikwangue = new JButton(chikwangueImage);
    chikwangue.addActionListener(e -> selectedType = Tower.Type.CHIKWANGUE);
    ImageIcon frozenImage = new ImageIcon(Frozen.getImage());
    JButton frozen = new JButton(frozenImage);
    frozen.addActionListener(e -> selectedType = Tower.Type.FROZEN);
    ImageIcon heatImage = new ImageIcon(Heat.getImage());
    JButton heat = new JButton(heatImage);
    heat.addActionListener(e -> selectedType = Tower.Type.HEAT);
    ImageIcon miniGunImage = new ImageIcon(MiniGun.getImage());
    JButton miniGun = new JButton(miniGunImage);
    miniGun.addActionListener(e -> selectedType = Tower.Type.MINIGUN);
    ImageIcon missileImage = new ImageIcon(Missile.getImage());
    JButton missile = new JButton(missileImage);
    missile.addActionListener(e -> selectedType = Tower.Type.MISSILE);
    ImageIcon poisonImage = new ImageIcon(Poison.getImage());
    JButton poison = new JButton(poisonImage);
    poison.addActionListener(e -> selectedType = Tower.Type.POISON);
    ImageIcon sniperImage = new ImageIcon(Sniper.getImage());
    JButton sniper = new JButton(sniperImage);
    sniper.addActionListener(e -> selectedType = Tower.Type.SNIPER);
    ImageIcon teslaImage = new ImageIcon(Tesla.getImage());
    JButton tesla = new JButton(teslaImage);
    tesla.addActionListener(e -> selectedType = Tower.Type.TESLA);
    add(basic);
    add(canon);
    add(sniper);
    add(miniGun);
    add(missile);
    add(frozen);
    add(heat);
    add(poison);
    add(tesla);
    add(chikwangue);
  }
}
