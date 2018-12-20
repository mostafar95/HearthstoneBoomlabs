package FriendlyHand;

import FriendlyMinions.ISpell;

public class BloodfuryPotion implements ISpell {
    private int mana = 3;
    @Override
    public int getSpellDamage() {
        return 0;
    }

    @Override
    public int getManaCost() {
        return mana;
    }

    @Override
    public void changeManaCost(int manacost) { mana = mana - manacost; }
}
