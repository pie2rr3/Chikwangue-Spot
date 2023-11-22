package Game.Entities.Towers.TowerType;

import java.awt.Image;
import java.io.File;

import Game.Entities.Towers.Tower;

public class Sniper extends Tower {

  private static Image sprite = null;

  static {
    File file = new File("src/Resource/Images/Towers/Sniper.png");
    sprite = new javax.swing.ImageIcon(file.getAbsolutePath()).getImage();
  }

  public Sniper(double x, double y) {
    super(5, 1, 5, 1, false, 1, Effect.NONE, 20, sprite, x, y,Type.SNIPER);
  }

  public static Image getImage() {
    return sprite;
  }
}
