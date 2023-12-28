package runnermod.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.FrailPower;
import com.megacrit.cardcrawl.powers.WeakPower;
import runnermod.cards.tempcards.Interest;

import static runnermod.RunnerMod.makeID;

public class TaxingUpgradesPower extends BasePower implements CloneablePowerInterface {


    public static final String POWER_ID = makeID("TaxingUpgradesPower");
    public static final AbstractPower.PowerType TYPE = PowerType.BUFF;
    private static final boolean TURNBASED = false;
    public TaxingUpgradesPower(AbstractCreature owner, int TaxAmount)
    {
        super(POWER_ID,TYPE,TURNBASED, owner, TaxAmount);
    }

    @Override
    public void atStartOfTurn() {
        super.atStartOfTurn();
        AbstractCreature player = AbstractDungeon.player;
        addToTop(new ApplyPowerAction(player,player,new WeakPower(player,1,false)));
        addToTop(new ApplyPowerAction(player,player,new FrailPower(player,1,false)));
    }

    @Override
    public void atStartOfTurnPostDraw() {
        super.atStartOfTurnPostDraw();
        AbstractCreature player = AbstractDungeon.player;
        addToBot(new DrawCardAction(2));
    }

    @Override
    public AbstractPower makeCopy() {
        return new TaxingUpgradesPower(owner, amount);
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0];
    }
}
