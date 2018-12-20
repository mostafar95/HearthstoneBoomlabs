package EnemyMinions;

import FriendlyMinions.IMinion;

public class Tyrantus implements IMinion {
    private int health = 12;
    private int attack = 12;
    private int mana = 10;
    @Override
    public int getMinionHealth() {
        return health;
    }

    @Override
    public int getMinionAttack() {
        return attack;
    }

    @Override
    public void dealDamage(int dmg) {
        health = health - dmg;
    }

    @Override
    public void removeAtk(int atkdmg) { attack = attack - atkdmg; }

    @Override
    public boolean isAlive() {
        if (health > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public int getManaCost() {
        return mana;
    }

    @Override
    public void changeManaCost(int manacost) { mana = mana - manacost; }
}
