package Game.Entities.Enemies.EnemyType;

import java.awt.Image;
import java.io.File;
import java.util.List;
import java.util.Map.Entry;

import Game.Entities.Enemies.Enemy;

public class Triangle extends Enemy {

  private static Image sprite = null;

  static {
    File file = new File("src/Resource/Images/Enemies/Triangle.png");
    sprite = new javax.swing.ImageIcon(file.getAbsolutePath()).getImage();
  }

  public Triangle(List<Entry<Integer, Integer>> route) {
    super(2, 3, false, 4, 3, 2, route, sprite);
  }

}
