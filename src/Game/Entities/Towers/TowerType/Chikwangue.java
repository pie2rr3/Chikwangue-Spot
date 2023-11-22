package Game.Entities.Towers.TowerType;

import java.awt.Image;
import java.io.File;

import Game.Entities.Towers.Tower;

public class Chikwangue extends Tower {

  private static Image sprite = null;

  static {
    File file = new File("src/Resource/Images/Towers/Chikwangue.png");
    sprite = new javax.swing.ImageIcon(file.getAbsolutePath()).getImage();
  }

  public Chikwangue(double x, double y) {
    super(5, 5, 5, 5, true, 6, Effect.BOTH, 50, sprite, x, y,Type.CHIKWANGUE);
  }

  public static Image getImage() {
    return sprite;
  }
}
