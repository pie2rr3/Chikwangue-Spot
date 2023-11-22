package Game.Entities.Enemies.EnemyType;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;

import javax.imageio.ImageIO;

import Game.Entities.Enemies.Enemy;

public class Kite extends Enemy {

  private static Image sprite = null;

  static {
    try {
      String imagePath = "src/Resource/Images/Enemies/Kite.png";
      File imageFile = new File(imagePath);
      sprite = ImageIO.read(imageFile);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public Kite(List<Entry<Integer, Integer>> route) {
    super(3, 3, true, 5, 4, 3, route, sprite);
  }
}
