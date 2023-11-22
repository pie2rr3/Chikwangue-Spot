package Game.Entities.Towers.TowerType;

import Game.Entities.Towers.Tower;
import java.awt.Image;
import java.io.File;

public class Tesla extends Tower {

  private static Image sprite = null;

  static {
    File file = new File("src/Resource/Images/Towers/Tesla.png");
    sprite = new javax.swing.ImageIcon(file.getAbsolutePath()).getImage();
  }

  public Tesla(double x, double y) {
    super(3, 3, 4, 2, true, 3, Effect.FREEZE, 40, sprite, x, y, Type.TESLA);
  }

  public static Image getImage() {
    return sprite;
  }
}
