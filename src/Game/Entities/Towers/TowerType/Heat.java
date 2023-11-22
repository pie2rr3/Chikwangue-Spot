package Game.Entities.Towers.TowerType;

import java.awt.Image;
import java.io.File;

import Game.Entities.Towers.Tower;

public class Heat extends Tower {

  private static Image sprite = null;

  static {
    File file = new File("src/Resource/Images/Towers/Heat.png");
    sprite = new javax.swing.ImageIcon(file.getAbsolutePath()).getImage();
  }

  public Heat(double x, double y) {
    super(3, 3, 4, 2, false, 3, Effect.BURN, 40, sprite, x, y,Type.HEAT);
  }

  public static Image getImage() {
    return sprite;
  }
}
