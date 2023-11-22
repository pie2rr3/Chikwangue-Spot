package Game.Entities.Enemies.EnemyType;

import java.awt.Image;
import java.io.File;
import java.util.List;
import java.util.Map.Entry;

import Game.Entities.Enemies.Enemy;

public class Chillagon extends Enemy {

  private static Image sprite = null;

  static {
    File file = new File("src/Resource/Images/Enemies/Chillagon.png");
    sprite = new javax.swing.ImageIcon(file.getAbsolutePath()).getImage();
  }

  public Chillagon(List<Entry<Integer, Integer>> route) {
    super(5, 5, false, 0, 0, 5, route, sprite);
  }
}
