package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class for a deck of playing cards.
 * <p> The class contains methods for drawing a card, drawing a hand of cards,
 * and forcing a flush.
 */

public class DeckOfCards {

  private final ArrayList<PlayingCard> cards = new ArrayList<>();
  private final ArrayList<PlayingCard> drawnCards = new ArrayList<>();
  Random random = new Random();

  public DeckOfCards() {
    char[] suits = {'S', 'H', 'D', 'C'};
    for (char suit : suits) {
      int[] faces = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
      for (int face : faces) {
        cards.add(new PlayingCard(suit, face));
      }
    }
  }

  /**
   * Draws a card from the deck. The drawn card is stored in the drawnCards list.
   */
  public void drawCard() {

    int index = random.nextInt(cards.size());
    PlayingCard card = cards.get(index);
    drawnCards.add(card);
    cards.remove(index);
  }

  /**
   * Draws a hand of 5 cards from the deck. The drawn cards are stored in the drawnCards list. The
   * drawn cards are removed from the deck when this command is executed again.
   */
  public void drawHand() {
    drawnCards.clear();
    for (int i = 0; i < 5; i++) {
      drawCard();

    }
  }

  /**
   * Getter for drawn Cards
   *
   * @return ArrayList of drawn cards
   */
  public List<PlayingCard> getDrawnCards() {
    return drawnCards;
  }

  /**
   * Getter for deck size Used for testing
   *
   * @return size of deck
   */
  public int deckSize() {
    return cards.size();
  }

  /**
   * Forces a flush by drawing 5 cards of the same suit. This suit is hardcoded. (Spades)
   */
  public void forceFlush() {
    drawnCards.clear();
    for (int i = 1; i <= 5; i++) {
      PlayingCard card = new PlayingCard('S', i);
      drawnCards.add(card);
    }
  }


}
