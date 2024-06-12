package runnermod.cards.common;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import runnermod.cards.BaseCard;
import runnermod.character.RunnerCharacter;
import runnermod.powers.Hacked;
import runnermod.util.CardStats;

public class Startle extends BaseCard {
    public static final String ID = makeID(Startle.class.getSimpleName());
    private static final CardStats info = new CardStats(
            RunnerCharacter.Enums.CARD_COLOR,
            CardType.SKILL,
            CardRarity.COMMON,
            CardTarget.ENEMY,
            0
    );

    private static final int MAG = 1;
    private static final int MAG_UPG = 1;
    public Startle()
    {
        super(ID,info);
        setMagic(MAG,MAG_UPG);
        tags.add(RunnerCharacter.Enums.NEON);
    }


    //called when the card is played and performs the actions for the card
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
            addToBot(new ApplyPowerAction(m,p,new VulnerablePower(m,magicNumber,false)));
    }
}