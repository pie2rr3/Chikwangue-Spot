package Game.Main;

import Game.Main.Models.Tiles.Builder;
import Game.Main.Models.Tiles.Empty;
import Game.Main.Models.Tiles.End;
import Game.Main.Models.Tiles.Route;
import Game.Main.Models.Tiles.Start;
import Game.Main.Models.Tiles.Tile;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class PlayPage extends JPanel {

  private Game game;
  private Tile[][] map;
  private JPanel bottomPanel;
  private GamePanel gamePanel;

  private Runnable onGameOver = () -> {
    GameOverPage gameOverPanel = new GameOverPage(game);
    game.setContentPane(gameOverPanel);
    game.revalidate();
    game.repaint();
    this.gamePanel.stopGameLoop();
  };

  public PlayPage(
    Game game,
    String mapFilePath,
    List<List<Entry<Integer, Integer>>> routes
  ) {
    this.game = game;
    loadMap(mapFilePath);
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    setPreferredSize(new Dimension(1500, 950));

    AmbianceMusicPlayer ambianceMusicPlayer = AmbianceMusicPlayer.getInstance();
    ambianceMusicPlayer.stopSound();
    ambianceMusicPlayer.playSound("InGame");

    this.gamePanel =
      new GamePanel(
        new WaveManager(routes),
        map,
        onGameOver,
        new TowerManager()
      );

    bottomPanel =
      new BottomPanel(
        game,
        PlayPage.this,
        gamePanel::setPaused,
        gamePanel::stopGameLoop
      );

    add(gamePanel);
    add(bottomPanel);
    add(Box.createVerticalGlue());
  }

  private void loadMap(String filePath) {
    map = new Tile[GraphicsRenderer.cols][GraphicsRenderer.rows];

    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
      String line;
      int i = 0;
      while ((line = br.readLine()) != null) {
        String[] tokens = line.split(" ");
        for (int j = 0; j < tokens.length; j++) {
          int id = Integer.parseInt(tokens[j]);
          map[j][i] = this.createTileFromId(id, j, i);
        }
        i++;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private Tile createTileFromId(int id, int x, int y) {
    switch (id) {
      case 0:
        return new Empty(x, y);
      case 1:
        return new Builder(x, y);
      case 2:
        return new Route(x, y);
      case 3:
        return new End(x, y);
      case 4:
        return new Start(x, y);
      default:
        return null;
    }
  }
}
