package Game.Entities.Enemies;

import Game.Entities.Towers.Tower;

public class EnemiesManager {

  protected int gold;

  public void dealDamage(Enemy enemy, int damage) {
    int remainingLife = enemy.getLife() - damage;
    enemy.setLife(Math.max(0, remainingLife));
    if (enemy.getLife() == 0) {
      rewardPlayer(enemy);
    }
  }

  public void applyStrength(Tower tower, Enemy enemy) {
    int finalDamage = tower.getDamage();

    if (enemy.getWeakness() == tower.getStrength()) {
      finalDamage *= 2;
    }

    if (enemy.getResistance() == tower.getStrength()) {
      finalDamage /= 2;
    }

    dealDamage(enemy, finalDamage);
  }

  public void rewardPlayer(Enemy enemy) {
    this.gold += (enemy.getIncome());
  }

  public int getGold() {
    return gold;
  }
}
