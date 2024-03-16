package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.ArrayList;
import java.util.Random;

public class DeckOfCards {

  private final char[] suits = {'S', 'H', 'D', 'C'};
  private final int[] faces = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
  private ArrayList<PlayingCard> cards = new ArrayList<>();
  private ArrayList<PlayingCard> drawnCards = new ArrayList<>();

  public DeckOfCards() {
    for (char suit : suits) {
      for (int face : faces) {
        cards.add(new PlayingCard(suit, face));
      }
    }
  }
  public void drawCard() {
    Random random = new Random();
    int index = random.nextInt(cards.size());
    PlayingCard card = cards.get(index);
    drawnCards.add(card);
    cards.remove(index);
    System.out.println(card.getAsString());
  }

  public void drawHand() {
    drawnCards.clear();
    for (int i = 0; i < 5; i++) {
      drawCard();

    }
  }

  /**
   * Getter for drawn Cards
   * @return ArrayList of drawn cards
   */
  public ArrayList<PlayingCard> getDrawnCards() {
    return drawnCards;
  }

  public String getDrawnCardsAsString() {
    String result = "";
    for (PlayingCard card : drawnCards) {
      result += card.getAsString() + " ";
    }
    return result;
  }

  public int deckSize() {
    return cards.size();
  }

  public void printAllCards() {
    for (PlayingCard card : cards) {
      System.out.println(card.getAsString());
    }
  }

}
