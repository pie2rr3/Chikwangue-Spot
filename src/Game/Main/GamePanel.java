package Game.Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Game.Entities.Player;
import Game.Entities.Towers.Tower;
import Game.Entities.Towers.TowerType.Basic;
import Game.Entities.Towers.TowerType.Canon;
import Game.Entities.Towers.TowerType.Chikwangue;
import Game.Entities.Towers.TowerType.Frozen;
import Game.Entities.Towers.TowerType.Heat;
import Game.Entities.Towers.TowerType.MiniGun;
import Game.Entities.Towers.TowerType.Missile;
import Game.Entities.Towers.TowerType.Poison;
import Game.Entities.Towers.TowerType.Sniper;
import Game.Entities.Towers.TowerType.Tesla;
import Game.Main.Models.Tiles.Tile;

public class GamePanel extends JPanel implements Runnable {

  private Tile[][] map;
  private WaveManager waveManager;
  private TowerManager towerManager;
  private volatile Thread gameThread;
  private Runnable onGameOver;
  private JLabel hpLabel;
  private JLabel goldLabel;
  private JLabel scoreLabel;
  private JLabel waveLabel;

  private volatile boolean isRunning = true;
  private volatile boolean isPaused = false;

  public GamePanel(
    WaveManager waveManager,
    Tile[][] map,
    Runnable onGameOver,
    TowerManager towerManager
  ) {
    this.map = map;
    this.onGameOver = onGameOver;
    this.waveManager = waveManager;
    this.towerManager = towerManager;

    setBackground(Color.BLACK);
    setPreferredSize(new Dimension(1500, 800));

    gameThread = new Thread(this);
    gameThread.start();

    addMouseListener(towerPlacement);

    hpLabel = new JLabel("HP : " + Player.getLife());
    hpLabel.setFont(new Font("Arial", Font.BOLD, 40));
    hpLabel.setForeground(Color.GREEN);
    hpLabel.setAlignmentX(CENTER_ALIGNMENT);

    goldLabel = new JLabel("Gold : " + Player.getGold());
    goldLabel.setFont(new Font("Arial", Font.BOLD, 40));
    goldLabel.setForeground(Color.YELLOW);
    goldLabel.setAlignmentX(CENTER_ALIGNMENT);

    scoreLabel = new JLabel("Your score : " + Player.getScore());
    scoreLabel.setFont(new Font("Arial", Font.BOLD, 40));
    scoreLabel.setForeground(Color.RED);
    scoreLabel.setAlignmentX(CENTER_ALIGNMENT);

    waveLabel = new JLabel("Wave : " + WaveManager.getWaveIndex());
    waveLabel.setFont(new Font("Arial", Font.BOLD, 40));
    waveLabel.setForeground(Color.BLUE);
    waveLabel.setAlignmentX(CENTER_ALIGNMENT);

    add(hpLabel);
    add(Box.createRigidArea(new Dimension(20, 0)));
    add(goldLabel);
    add(Box.createRigidArea(new Dimension(20, 0)));
    add(scoreLabel);
    add(Box.createRigidArea(new Dimension(20, 0)));
    add(waveLabel);
  }

  private Consumer<MouseEvent> onMouseClick = (MouseEvent e) -> {
    int gridWidth = 30 * 35;
    int xOffset = (1500 - gridWidth) / 2;
    int yOffset = 100;
    int x = (int) Math.floor((-xOffset + e.getX()) / 35);
    int y = (int) Math.floor((-yOffset + e.getY()) / 35);
    if (map[x][y].isBuildable()) {
      var tower = createTower(BottomTowersPanel.selectedType, x, y);
      var existingTower = this.towerManager.getTower(x, y);
      if (tower.getPrice() <= Player.getGold()) {
        if (existingTower == null) {
          Player.addGold(-tower.getPrice());
          this.towerManager.addTower(tower);
        }
      }
      this.towerManager.showTowerStats(existingTower);
    } else {
      this.towerManager.showTowerStats(null);
    }
  };

  private Tower createTower(Tower.Type type, double x, double y) {
    switch (type) {
      case BASIC:
        return new Basic(x, y);
      case CANON:
        return new Canon(x, y);
      case CHIKWANGUE:
        return new Chikwangue(x, y);
      case FROZEN:
        return new Frozen(x, y);
      case HEAT:
        return new Heat(x, y);
      case MINIGUN:
        return new MiniGun(x, y);
      case MISSILE:
        return new Missile(x, y);
      case POISON:
        return new Poison(x, y);
      case SNIPER:
        return new Sniper(x, y);
      case TESLA:
        return new Tesla(x, y);
      default:
        return null;
    }
  }

  private MouseAdapter towerPlacement = new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
      onMouseClick.accept(e);
    }
  };

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    GraphicsRenderer.drawMap(g, map);
    for (var enemy : this.waveManager.getCurrentWave()) {
      GraphicsRenderer.draw(g, enemy);
      GraphicsRenderer.drawLifeBar(g, enemy);
    }
    for (var tower : this.towerManager.getTowers()) {
      GraphicsRenderer.draw(g, tower);
    }
  }

  private void updateLabels() {
    if (
      this.hpLabel != null && this.goldLabel != null && this.scoreLabel != null
    ) {
      this.hpLabel.setText("HP : " + Player.getLife());
      this.hpLabel.repaint();
      this.goldLabel.setText("Gold : " + Player.getGold());
      this.goldLabel.repaint();
      this.scoreLabel.setText("Your score : " + Player.getScore());
      this.scoreLabel.repaint();
      this.waveLabel.setText("Wave : " + WaveManager.getWaveIndex());
      this.waveLabel.repaint();
    }
  }

  public void setPaused(boolean paused) {
    isPaused = paused;
  }

  public void stopGameLoop() {
    isRunning = false;
    gameThread = null;
    Thread.currentThread().interrupt();

    Player.initPlayer();
    this.waveManager.init();
  }

  @Override
  public void run() {
    long lastDrawTime = System.currentTimeMillis();
    long drawInterval = 1000 / 60;
    long lastUpdateTime = System.currentTimeMillis();
    long updateInterval = 1000 / 10;
    long lastTowerTime = System.currentTimeMillis();
    long towerInterval = 1000 / 40;

    while (isRunning) {
      long currentTime = System.currentTimeMillis();

      if (!isPaused) {
        if (currentTime - lastUpdateTime >= updateInterval) {
          if (this.waveManager.onUpdate()) {
            Thread.currentThread().interrupt();
            this.onGameOver.run();
          }
          lastUpdateTime = currentTime;
        }

        if (currentTime - lastTowerTime >= towerInterval) {
          this.towerManager.onUpdate(
              this.waveManager.getCurrentWave(),
              currentTime
            );
          lastTowerTime = currentTime;
        }

        if (currentTime - lastDrawTime >= drawInterval) {
          repaint();
          lastDrawTime = currentTime;
        }

        updateLabels();
      }

      try {
        Thread.sleep(1000 / 60);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
