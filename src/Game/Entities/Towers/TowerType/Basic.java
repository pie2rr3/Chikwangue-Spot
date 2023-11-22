package Game.Entities.Towers.TowerType;

import java.awt.Image;
import java.io.File;

import Game.Entities.Towers.Tower;

public class Basic extends Tower {

  private static Image sprite = null;

  static {
    File file = new File("src/Resource/Images/Towers/Basic.png");
    sprite = new javax.swing.ImageIcon(file.getAbsolutePath()).getImage();
  }

  public Basic(double x, double y) {
    super(2, 3, 3, 1, true, 1, Effect.NONE, 10, sprite, x, y,Type.BASIC);
  }

  public static Image getImage() {
    return sprite;
  }
}
