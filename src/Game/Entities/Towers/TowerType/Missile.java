package Game.Entities.Towers.TowerType;

import java.awt.Image;
import java.io.File;

import Game.Entities.Towers.Tower;

public class Missile extends Tower {

  private static Image sprite = null;

  static {
    File file = new File("src/Resource/Images/Towers/Missile.png");
    sprite = new javax.swing.ImageIcon(file.getAbsolutePath()).getImage();
  }

  public Missile(double x, double y) {
    super(5, 1, 5, 2, true, 5, Effect.NONE, 30, sprite, x, y,Type.MISSILE);
  }

  public static Image getImage() {
    return sprite;
  }
}
