package Game.Main.Models.Tiles;

import java.awt.Image;
import java.io.File;

public class Start extends Tile {

  private static Image sprite = null;

  static {
    File file = new File("src/Resource/Images/Map/image_4.png");
    sprite = new javax.swing.ImageIcon(file.getAbsolutePath()).getImage();
  }

  public Start(int x, int y) {
    super(x, y, true, false, sprite);
  }
}
