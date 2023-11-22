package Game.Entities.Towers.TowerType;

import java.awt.Image;
import java.io.File;

import Game.Entities.Towers.Tower;

public class Frozen extends Tower {

  private static Image sprite = null;

  static {
    File file = new File("src/Resource/Images/Towers/Frozen.png");
    sprite = new javax.swing.ImageIcon(file.getAbsolutePath()).getImage();
  }

  public Frozen(double x, double y) {
    super(2, 3, 4, 3, true, 4, Effect.FREEZE, 40, sprite, x, y,Type.FROZEN);
  }

  public static Image getImage() {
    return sprite;
  }
}
