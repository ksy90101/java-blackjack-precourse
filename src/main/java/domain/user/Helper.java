package domain.user;

import domain.card.Card;
import sun.security.krb5.internal.tools.Klist;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Helper {

    private final List<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }

    public String cardsToString() {
        return cards.stream().map(card -> String.valueOf(card.toString())).collect(Collectors.joining(", "));
    }

    public void cardDraw(List<Card> cardDeck) {
        int cardDeckCount = cardDeck.size() - 1;
        int selectNumber = (int) (Math.random() * cardDeckCount) + 1;
        Card selectedCard = cardDeck.get(selectNumber);

        this.addCard(selectedCard);
        cardDeck.remove(selectedCard);
    }

    public int scoreCalcualtor(){
        Stream<Integer> cardScore = cards.stream().map(card -> card.getScore());
        int scoreResult = cardScore.collect(Collectors.summingInt(score -> score));
        return scoreResult;
    }

}
