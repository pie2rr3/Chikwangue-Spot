package Game.Entities.Enemies.EnemyType;

import java.awt.Image;
import java.io.File;
import java.util.List;
import java.util.Map.Entry;

import Game.Entities.Enemies.Enemy;

public class Heart extends Enemy {

  private static Image sprite = null;

  static {
    File file = new File("src/Resource/Images/Enemies/Heart.png");
    sprite = new javax.swing.ImageIcon(file.getAbsolutePath()).getImage();
  }

  public Heart(List<Entry<Integer, Integer>> route) {
    super(4, 4, false, 1, 4, 4, route, sprite);
  }
}
