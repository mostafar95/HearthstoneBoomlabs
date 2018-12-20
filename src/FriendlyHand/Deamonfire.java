package FriendlyHand;

import FriendlyMinions.ISpell;

public class Deamonfire implements ISpell {
    private int spellDamage = 2;
    private int mana = 2;
    @Override
    public int getSpellDamage() {
        return spellDamage;
    }

    @Override
    public int getManaCost() {
        return mana;
    }

    @Override
    public void changeManaCost(int manacost) { mana = mana - manacost; }
}
