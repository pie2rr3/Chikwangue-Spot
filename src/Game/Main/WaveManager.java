package Game.Main;

import Game.Entities.Enemies.Enemy;
import Game.Entities.Enemies.EnemyType.Arrow;
import Game.Entities.Enemies.EnemyType.Chikwangon;
import Game.Entities.Enemies.EnemyType.Chillagon;
import Game.Entities.Enemies.EnemyType.Circle;
import Game.Entities.Enemies.EnemyType.Cross;
import Game.Entities.Enemies.EnemyType.Heart;
import Game.Entities.Enemies.EnemyType.Kite;
import Game.Entities.Enemies.EnemyType.Octagon;
import Game.Entities.Enemies.EnemyType.Pentagon;
import Game.Entities.Enemies.EnemyType.Rhombus;
import Game.Entities.Enemies.EnemyType.Square;
import Game.Entities.Enemies.EnemyType.Star;
import Game.Entities.Enemies.EnemyType.Trapeze;
import Game.Entities.Enemies.EnemyType.Triangle;
import Game.Entities.Player;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class WaveManager {

  private List<Enemy> currentWave = new LinkedList<Enemy>();
  private List<List<Enemy>> waves;
  private List<List<Entry<Integer, Integer>>> routes;
  private int spawnInterval = 500;
  private long lastSpawnTime = System.currentTimeMillis();
  private int enemySpawned = 0;
  private int currentWaveIndex = 0;
  public static int waveIndex = 1;
  private long waveStartTime = System.currentTimeMillis();
  private boolean wavePlaying = true;

  public WaveManager(List<List<Entry<Integer, Integer>>> routes) {
    this.routes = routes;
    init();
  }

  private List<Entry<Integer, Integer>> getRandomRoute() {
    if (routes.isEmpty()) {
      return null;
    }
    return routes.get((int) Math.floor(Math.random() * routes.size()));
  }

  public void init() {
    this.currentWave = new LinkedList<Enemy>();
    this.enemySpawned = 0;
    this.currentWaveIndex = 0;
    waveIndex = 1;

    this.waves =
      Arrays.asList(
        Arrays.asList(
          new Square(getRandomRoute()),
          new Square(getRandomRoute()),
          new Square(getRandomRoute()),
          new Square(getRandomRoute()),
          new Square(getRandomRoute()),
          new Square(getRandomRoute()),
          new Square(getRandomRoute()),
          new Square(getRandomRoute()),
          new Square(getRandomRoute()),
          new Square(getRandomRoute()),
          new Triangle(getRandomRoute()),
          new Triangle(getRandomRoute()),
          new Triangle(getRandomRoute()),
          new Triangle(getRandomRoute()),
          new Triangle(getRandomRoute()),
          new Triangle(getRandomRoute()),
          new Triangle(getRandomRoute()),
          new Triangle(getRandomRoute()),
          new Triangle(getRandomRoute()),
          new Triangle(getRandomRoute()),
          new Circle(getRandomRoute()),
          new Circle(getRandomRoute()),
          new Circle(getRandomRoute()),
          new Circle(getRandomRoute()),
          new Circle(getRandomRoute()),
          new Circle(getRandomRoute()),
          new Circle(getRandomRoute()),
          new Circle(getRandomRoute()),
          new Circle(getRandomRoute()),
          new Circle(getRandomRoute())
        ),
        Arrays.asList(
          new Square(getRandomRoute()),
          new Square(getRandomRoute()),
          new Square(getRandomRoute()),
          new Square(getRandomRoute()),
          new Square(getRandomRoute()),
          new Square(getRandomRoute()),
          new Square(getRandomRoute()),
          new Square(getRandomRoute()),
          new Square(getRandomRoute()),
          new Square(getRandomRoute()),
          new Circle(getRandomRoute()),
          new Circle(getRandomRoute()),
          new Circle(getRandomRoute()),
          new Circle(getRandomRoute()),
          new Circle(getRandomRoute()),
          new Circle(getRandomRoute()),
          new Circle(getRandomRoute()),
          new Circle(getRandomRoute()),
          new Circle(getRandomRoute()),
          new Circle(getRandomRoute()),
          new Pentagon(getRandomRoute()),
          new Pentagon(getRandomRoute()),
          new Pentagon(getRandomRoute()),
          new Pentagon(getRandomRoute()),
          new Pentagon(getRandomRoute()),
          new Pentagon(getRandomRoute()),
          new Pentagon(getRandomRoute()),
          new Pentagon(getRandomRoute()),
          new Pentagon(getRandomRoute()),
          new Pentagon(getRandomRoute())
        ),
        Arrays.asList(
          new Square(getRandomRoute()),
          new Square(getRandomRoute()),
          new Square(getRandomRoute()),
          new Square(getRandomRoute()),
          new Square(getRandomRoute()),
          new Square(getRandomRoute()),
          new Square(getRandomRoute()),
          new Square(getRandomRoute()),
          new Square(getRandomRoute()),
          new Square(getRandomRoute()),
          new Rhombus(getRandomRoute()),
          new Rhombus(getRandomRoute()),
          new Rhombus(getRandomRoute()),
          new Rhombus(getRandomRoute()),
          new Rhombus(getRandomRoute()),
          new Rhombus(getRandomRoute()),
          new Rhombus(getRandomRoute()),
          new Rhombus(getRandomRoute()),
          new Rhombus(getRandomRoute()),
          new Rhombus(getRandomRoute()),
          new Arrow(getRandomRoute()),
          new Arrow(getRandomRoute()),
          new Arrow(getRandomRoute()),
          new Arrow(getRandomRoute()),
          new Arrow(getRandomRoute()),
          new Arrow(getRandomRoute()),
          new Arrow(getRandomRoute()),
          new Arrow(getRandomRoute()),
          new Arrow(getRandomRoute()),
          new Arrow(getRandomRoute())
        ),
        Arrays.asList(
          new Rhombus(getRandomRoute()),
          new Rhombus(getRandomRoute()),
          new Rhombus(getRandomRoute()),
          new Rhombus(getRandomRoute()),
          new Rhombus(getRandomRoute()),
          new Rhombus(getRandomRoute()),
          new Rhombus(getRandomRoute()),
          new Rhombus(getRandomRoute()),
          new Rhombus(getRandomRoute()),
          new Rhombus(getRandomRoute()),
          new Pentagon(getRandomRoute()),
          new Pentagon(getRandomRoute()),
          new Pentagon(getRandomRoute()),
          new Pentagon(getRandomRoute()),
          new Pentagon(getRandomRoute()),
          new Pentagon(getRandomRoute()),
          new Pentagon(getRandomRoute()),
          new Pentagon(getRandomRoute()),
          new Pentagon(getRandomRoute()),
          new Pentagon(getRandomRoute()),
          new Octagon(getRandomRoute()),
          new Octagon(getRandomRoute()),
          new Octagon(getRandomRoute()),
          new Octagon(getRandomRoute()),
          new Octagon(getRandomRoute()),
          new Octagon(getRandomRoute()),
          new Octagon(getRandomRoute()),
          new Octagon(getRandomRoute()),
          new Octagon(getRandomRoute()),
          new Octagon(getRandomRoute())
        ),
        Arrays.asList(
          new Triangle(getRandomRoute()),
          new Triangle(getRandomRoute()),
          new Triangle(getRandomRoute()),
          new Triangle(getRandomRoute()),
          new Triangle(getRandomRoute()),
          new Triangle(getRandomRoute()),
          new Triangle(getRandomRoute()),
          new Triangle(getRandomRoute()),
          new Triangle(getRandomRoute()),
          new Triangle(getRandomRoute()),
          new Octagon(getRandomRoute()),
          new Octagon(getRandomRoute()),
          new Octagon(getRandomRoute()),
          new Octagon(getRandomRoute()),
          new Octagon(getRandomRoute()),
          new Octagon(getRandomRoute()),
          new Octagon(getRandomRoute()),
          new Octagon(getRandomRoute()),
          new Octagon(getRandomRoute()),
          new Octagon(getRandomRoute()),
          new Trapeze(getRandomRoute()),
          new Trapeze(getRandomRoute()),
          new Trapeze(getRandomRoute()),
          new Trapeze(getRandomRoute()),
          new Trapeze(getRandomRoute()),
          new Trapeze(getRandomRoute()),
          new Trapeze(getRandomRoute()),
          new Trapeze(getRandomRoute()),
          new Trapeze(getRandomRoute()),
          new Trapeze(getRandomRoute())
        ),
        Arrays.asList(
          new Pentagon(getRandomRoute()),
          new Pentagon(getRandomRoute()),
          new Pentagon(getRandomRoute()),
          new Pentagon(getRandomRoute()),
          new Pentagon(getRandomRoute()),
          new Pentagon(getRandomRoute()),
          new Pentagon(getRandomRoute()),
          new Pentagon(getRandomRoute()),
          new Pentagon(getRandomRoute()),
          new Pentagon(getRandomRoute()),
          new Heart(getRandomRoute()),
          new Heart(getRandomRoute()),
          new Heart(getRandomRoute()),
          new Heart(getRandomRoute()),
          new Heart(getRandomRoute()),
          new Heart(getRandomRoute()),
          new Heart(getRandomRoute()),
          new Heart(getRandomRoute()),
          new Heart(getRandomRoute()),
          new Heart(getRandomRoute()),
          new Kite(getRandomRoute()),
          new Kite(getRandomRoute()),
          new Kite(getRandomRoute()),
          new Kite(getRandomRoute()),
          new Kite(getRandomRoute()),
          new Kite(getRandomRoute()),
          new Kite(getRandomRoute()),
          new Kite(getRandomRoute()),
          new Kite(getRandomRoute()),
          new Kite(getRandomRoute())
        ),
        Arrays.asList(
          new Chillagon(getRandomRoute()),
          new Chillagon(getRandomRoute()),
          new Chillagon(getRandomRoute()),
          new Chillagon(getRandomRoute()),
          new Chillagon(getRandomRoute()),
          new Chillagon(getRandomRoute()),
          new Chillagon(getRandomRoute()),
          new Chillagon(getRandomRoute()),
          new Chillagon(getRandomRoute()),
          new Chillagon(getRandomRoute()),
          new Star(getRandomRoute()),
          new Star(getRandomRoute()),
          new Star(getRandomRoute()),
          new Star(getRandomRoute()),
          new Star(getRandomRoute()),
          new Star(getRandomRoute()),
          new Star(getRandomRoute()),
          new Star(getRandomRoute()),
          new Star(getRandomRoute()),
          new Star(getRandomRoute()),
          new Trapeze(getRandomRoute()),
          new Trapeze(getRandomRoute()),
          new Trapeze(getRandomRoute()),
          new Trapeze(getRandomRoute()),
          new Trapeze(getRandomRoute()),
          new Trapeze(getRandomRoute()),
          new Trapeze(getRandomRoute()),
          new Trapeze(getRandomRoute()),
          new Trapeze(getRandomRoute()),
          new Trapeze(getRandomRoute())
        ),
        Arrays.asList(
          new Heart(getRandomRoute()),
          new Heart(getRandomRoute()),
          new Heart(getRandomRoute()),
          new Heart(getRandomRoute()),
          new Heart(getRandomRoute()),
          new Heart(getRandomRoute()),
          new Heart(getRandomRoute()),
          new Heart(getRandomRoute()),
          new Heart(getRandomRoute()),
          new Heart(getRandomRoute()),
          new Star(getRandomRoute()),
          new Star(getRandomRoute()),
          new Star(getRandomRoute()),
          new Star(getRandomRoute()),
          new Star(getRandomRoute()),
          new Star(getRandomRoute()),
          new Star(getRandomRoute()),
          new Star(getRandomRoute()),
          new Star(getRandomRoute()),
          new Star(getRandomRoute()),
          new Cross(getRandomRoute()),
          new Cross(getRandomRoute()),
          new Cross(getRandomRoute()),
          new Cross(getRandomRoute()),
          new Cross(getRandomRoute()),
          new Cross(getRandomRoute()),
          new Cross(getRandomRoute()),
          new Cross(getRandomRoute()),
          new Cross(getRandomRoute()),
          new Cross(getRandomRoute())
        ),
        Arrays.asList(
          new Arrow(getRandomRoute()),
          new Arrow(getRandomRoute()),
          new Arrow(getRandomRoute()),
          new Arrow(getRandomRoute()),
          new Arrow(getRandomRoute()),
          new Arrow(getRandomRoute()),
          new Arrow(getRandomRoute()),
          new Arrow(getRandomRoute()),
          new Arrow(getRandomRoute()),
          new Arrow(getRandomRoute()),
          new Kite(getRandomRoute()),
          new Kite(getRandomRoute()),
          new Kite(getRandomRoute()),
          new Kite(getRandomRoute()),
          new Kite(getRandomRoute()),
          new Kite(getRandomRoute()),
          new Kite(getRandomRoute()),
          new Kite(getRandomRoute()),
          new Kite(getRandomRoute()),
          new Kite(getRandomRoute()),
          new Trapeze(getRandomRoute()),
          new Trapeze(getRandomRoute()),
          new Trapeze(getRandomRoute()),
          new Trapeze(getRandomRoute()),
          new Trapeze(getRandomRoute()),
          new Trapeze(getRandomRoute()),
          new Trapeze(getRandomRoute()),
          new Trapeze(getRandomRoute()),
          new Trapeze(getRandomRoute()),
          new Trapeze(getRandomRoute())
        ),
        Arrays.asList(
          new Cross(getRandomRoute()),
          new Cross(getRandomRoute()),
          new Cross(getRandomRoute()),
          new Cross(getRandomRoute()),
          new Cross(getRandomRoute()),
          new Cross(getRandomRoute()),
          new Cross(getRandomRoute()),
          new Cross(getRandomRoute()),
          new Cross(getRandomRoute()),
          new Cross(getRandomRoute()),
          new Chillagon(getRandomRoute()),
          new Chillagon(getRandomRoute()),
          new Chillagon(getRandomRoute()),
          new Chillagon(getRandomRoute()),
          new Chillagon(getRandomRoute()),
          new Chillagon(getRandomRoute()),
          new Chillagon(getRandomRoute()),
          new Chillagon(getRandomRoute()),
          new Chillagon(getRandomRoute()),
          new Chillagon(getRandomRoute()),
          new Chikwangon(getRandomRoute()),
          new Chikwangon(getRandomRoute()),
          new Chikwangon(getRandomRoute()),
          new Chikwangon(getRandomRoute()),
          new Chikwangon(getRandomRoute()),
          new Chikwangon(getRandomRoute()),
          new Chikwangon(getRandomRoute()),
          new Chikwangon(getRandomRoute()),
          new Chikwangon(getRandomRoute()),
          new Chikwangon(getRandomRoute())
        )
      );
  }

  public boolean onUpdate() {
    boolean isGameOver = false;

    if (currentWaveIndex == 0 && enemySpawned == 0) {
      if (System.currentTimeMillis() - waveStartTime >= 7000) {
        waveStartTime = System.currentTimeMillis();
      } else {
        return false;
      }
    }

    if (enemySpawned == waves.get(currentWaveIndex).size()) {
      if (wavePlaying) {
        waveStartTime = System.currentTimeMillis();
        wavePlaying = false;
      }
      if (System.currentTimeMillis() - waveStartTime >= 5000) {
        currentWaveIndex++;
        waveIndex++;
        enemySpawned = 0;
        wavePlaying = true;
      }
    }

    if (wavePlaying) {
      spawnEnemyIfNeeded();
    }

    Iterator<Enemy> iterator = currentWave.iterator();

    while (iterator.hasNext()) {
      Enemy enemy = iterator.next();
      enemy.move();
      if (enemy.hasReachedEnd()) {
        iterator.remove();
        isGameOver = isGameOver || Player.onEnemyExit(enemy.getLife());
      }
    }

    return isGameOver;
  }

  private void spawnEnemyIfNeeded() {
    long currentTime = System.currentTimeMillis();
    if (currentTime - lastSpawnTime >= spawnInterval) {
      if (currentWaveIndex == 10) {
        upgradeEnemies();
        currentWaveIndex = 0;
      }
      Enemy enemy = waves.get(currentWaveIndex).get(enemySpawned);
      currentWave.add(enemy);
      lastSpawnTime = currentTime;
      enemySpawned++;
    }
  }

  private void upgradeEnemies() {
    for (List<Enemy> wave : waves) {
      for (Enemy enemy : wave) {
        enemy.upgradeEnemy();
        enemy.reset(getRandomRoute());
      }
    }
  }

  public List<Enemy> getCurrentWave() {
    return currentWave;
  }

  public void removeEnemy(Enemy enemy) {
    currentWave.remove(enemy);
  }

  public static int getWaveIndex() {
    return waveIndex;
  }
}
