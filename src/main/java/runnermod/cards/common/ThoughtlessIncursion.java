package runnermod.cards.common;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import runnermod.cards.BaseCard;
import runnermod.cards.RandomDebuffAction;
import runnermod.character.RunnerCharacter;
import runnermod.util.CardStats;

public class ThoughtlessIncursion extends BaseCard {
    public static final String ID = makeID(ThoughtlessIncursion.class.getSimpleName());
    private static final CardStats info = new CardStats(
            RunnerCharacter.Enums.CARD_COLOR,
            CardType.SKILL,
            CardRarity.COMMON,
            CardTarget.SELF_AND_ENEMY,
            0
    );

//    //Card Stats
    private static final int MAGIC =3;
    private static final int UPG_MAGIC =2;

    public ThoughtlessIncursion()
    {
        super(ID,info);
        this.setMagic(MAGIC, UPG_MAGIC);
    }

    //called when the card is played
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        //add gain gold action to the stack
        for (int i = 0; i < magicNumber; i++) {
            addToBot(new RandomDebuffAction(p, m));
        }
        for (int i = 0; i < 2; i++) {
            addToBot(new RandomDebuffAction(p, p));
        }

    }
}
