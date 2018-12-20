package FriendlyMinions;

public interface IMinion extends ICard{

    int getMinionHealth();

    int getMinionAttack();

    void dealDamage(int dmg);

    void removeAtk(int atkdmg);

    boolean isAlive();
}
