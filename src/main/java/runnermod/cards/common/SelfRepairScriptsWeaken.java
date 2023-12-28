package runnermod.cards.common;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import runnermod.cards.BaseCard;
import runnermod.character.RunnerCharacter;
import runnermod.powers.InvestmentsPower;
import runnermod.powers.SelfRepairScriptsWeakenedPower;
import runnermod.util.CardStats;

public class SelfRepairScriptsWeaken extends BaseCard {
    public static final String ID = makeID(SelfRepairScriptsWeaken.class.getSimpleName());
    private static final CardStats info = new CardStats(
            RunnerCharacter.Enums.CARD_COLOR,
            CardType.POWER,
            CardRarity.COMMON,
            CardTarget.NONE,
            1

    );

    //Card Stats
    private static final int MAGIC = 1;
    private static final int UPG_MAGIC =1;

    public SelfRepairScriptsWeaken()
    {
        super(ID,info);
        setMagic(MAGIC,UPG_MAGIC);
    }



    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p,p,new SelfRepairScriptsWeakenedPower(p, magicNumber)));
    }
}
