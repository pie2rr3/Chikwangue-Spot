package Game.Entities.Towers.TowerType;

import java.awt.Image;
import java.io.File;

import Game.Entities.Towers.Tower;

public class MiniGun extends Tower {

  private static Image sprite = null;

  static {
    File file = new File("src/Resource/Images/Towers/MiniGun.png");
    sprite = new javax.swing.ImageIcon(file.getAbsolutePath()).getImage();
  }

  public MiniGun(double x, double y) {
    super(1, 5, 3, 1, false, 1, Effect.NONE, 30, sprite, x, y,Type.MINIGUN);
  }

  public static Image getImage() {
    return sprite;
  }
}
