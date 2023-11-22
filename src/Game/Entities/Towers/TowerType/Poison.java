package Game.Entities.Towers.TowerType;

import java.awt.Image;
import java.io.File;

import Game.Entities.Towers.Tower;

public class Poison extends Tower {

  private static Image sprite = null;

  static {
    File file = new File("src/Resource/Images/Towers/Poison.png");
    sprite = new javax.swing.ImageIcon(file.getAbsolutePath()).getImage();
  }

  public Poison(double x, double y) {
    super(2, 3, 4, 3, false, 4, Effect.NONE, 40, sprite, x, y,Type.POISON);
  }

  public static Image getImage() {
    return sprite;
  }
}
