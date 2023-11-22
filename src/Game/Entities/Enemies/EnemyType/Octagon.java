package Game.Entities.Enemies.EnemyType;

import java.awt.Image;
import java.io.File;
import java.util.List;
import java.util.Map.Entry;

import Game.Entities.Enemies.Enemy;

public class Octagon extends Enemy {

  private static Image sprite = null;

  static {
    File file = new File("src/Resource/Images/Enemies/Octagon.png");
    sprite = new javax.swing.ImageIcon(file.getAbsolutePath()).getImage();
  }

  public Octagon(List<Entry<Integer, Integer>> route) {
    super(5, 1, false, 2, 4, 3, route, sprite);
  }
}
