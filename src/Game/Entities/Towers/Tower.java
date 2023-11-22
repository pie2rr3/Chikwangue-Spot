package Game.Entities.Towers;

import Game.Entities.Enemies.Enemy;
import Game.Main.Models.AUnit;
import java.awt.Image;

public abstract class Tower extends AUnit {

  public enum Type {
    BASIC,
    CANON,
    SNIPER,
    MINIGUN,
    MISSILE,
    FROZEN,
    HEAT,
    POISON,
    TESLA,
    CHIKWANGUE,
    OPINEL,
  }

  public enum Effect {
    NONE,
    BURN,
    FREEZE,
    BOTH,
  }

  protected int damage;
  protected int fireRate;
  protected int range;
  protected int area;
  protected boolean antiAircraft;
  protected int strength;
  protected Effect effect;
  protected int towerLevel;
  protected int price;
  protected long lastShotTime = 0;
  protected Type type;

  public Tower(
    int damage,
    int fireRate,
    int range,
    int area,
    boolean antiAircraft,
    int strength,
    Effect effect,
    int price,
    Image sprite,
    double x,
    double y,
    Type type
  ) {
    super(x, y, sprite);
    this.damage = damage;
    this.fireRate = fireRate;
    this.range = range;
    this.area = area;
    this.antiAircraft = antiAircraft;
    this.effect = effect;
    towerLevel = 1;
    this.price = price;
    this.type = type;
  }

  public void upgradeTower() {
    this.towerLevel++;
    this.damage *= 2;
    this.fireRate *= 2;
    this.range += 1;
  }

  public boolean isEnemyInRange(Enemy enemy) {
    int range = GetDistance(getX(), getY(), enemy.getX(), enemy.getY());
    return range < getRange();
  }

  private int GetDistance(double x1, double y1, double x2, double y2) {
    double xDiff = Math.abs(x1 - x2);
    double yDiff = Math.abs(y1 - y2);
    return (int) Math.hypot(xDiff, yDiff);
  }

  public int getDamage() {
    return damage;
  }

  public int getFireRate() {
    return fireRate;
  }

  public int getRange() {
    return range;
  }

  public int getArea() {
    return area;
  }

  public boolean getAntiAircraft() {
    return antiAircraft;
  }

  public int getStrength() {
    return strength;
  }

  public Effect getEffect() {
    return effect;
  }

  public int getTowerLevel() {
    return towerLevel;
  }

  public int getPrice() {
    return price;
  }

  public Tower.Type getType() {
    return type;
  }

  public long getLastShotTime() {
    return lastShotTime;
  }

  public void setLastShotTime(long lastShotTime) {
    this.lastShotTime = lastShotTime;
  }
}
