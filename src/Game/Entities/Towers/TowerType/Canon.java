package Game.Entities.Towers.TowerType;

import java.awt.Image;
import java.io.File;

import Game.Entities.Towers.Tower;

public class Canon extends Tower {

  private static Image sprite = null;

  static {
    File file = new File("src/Resource/Images/Towers/Canon.png");
    sprite = new javax.swing.ImageIcon(file.getAbsolutePath()).getImage();
  }

  public Canon(double x, double y) {
    super(3, 2, 2, 4, false, 2, Effect.NONE, 20, sprite, x, y,Type.CANON);
  }

  public static Image getImage() {
    return sprite;
  }
}
