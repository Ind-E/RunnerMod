package runnermod.cards.rare;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import runnermod.cards.BaseCard;
import runnermod.cards.tempcards.Bankroll;
import runnermod.character.RunnerCharacter;
import runnermod.util.CardStats;

public class LostInTheCrowd extends BaseCard {
    public static final String ID = makeID(LostInTheCrowd.class.getSimpleName());
    private static final CardStats info = new CardStats(
            RunnerCharacter.Enums.CARD_COLOR,
            CardType.SKILL,
            CardRarity.RARE,
            CardTarget.NONE,
            1

    );

    public LostInTheCrowd() {
        super(ID, info);
        setEthereal(true,false);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        addToBot(new LostInTheCrowdAction(this.upgraded));
    }
}