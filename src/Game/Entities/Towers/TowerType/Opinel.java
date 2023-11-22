package Game.Entities.Towers.TowerType;

import java.awt.Image;
import java.io.File;

import Game.Entities.Towers.Tower;

public class Opinel extends Tower {

  private static Image sprite = null;

  static {
    File file = new File("src/Resource/Images/Towers/Opinel.png");
    sprite = new javax.swing.ImageIcon(file.getAbsolutePath()).getImage();
  }

  public Opinel(double x, double y) {
    super(5, 5, 5, 5, false, 6, Effect.NONE, 50, sprite, x, y,Type.OPINEL);
  }

  public static Image getImage() {
    return sprite;
  }
}
