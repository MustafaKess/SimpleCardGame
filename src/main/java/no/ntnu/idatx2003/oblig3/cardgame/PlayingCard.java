package no.ntnu.idatx2003.oblig3.cardgame;

/**
 * Represents a playing card. A playing card has a number (face) between 1 and 13, where 1 is called
 * an Ace, 11 = Knight, 12 = Queen and 13 = King. The card can also be one of 4 suits: Spade, Heart,
 * Diamonds and Clubs.
 *
 * @author Mustafa
 * @version 2020-01-10
 * @see DeckOfCards for the implementation of a deck of cards. (5 cards)
 * @see no.ntnu.idatx2003.oblig3.cardgame.frontend.CardInitializer for the GUI representation of the
 * cards.
 */
public class PlayingCard {

  private final char suit; // 'S'=spade, 'H'=heart, 'D'=diamonds, 'C'=clubs
  private final int face; // a number between 1 and 13

  /**
   * Creates an instance of a PlayingCard with a given suit and face.
   *
   * @param suit The suit of the card, as a single character. 'S' for Spades, 'H' for Heart, 'D' for
   *             Diamonds and 'C' for clubs
   * @param face The face value of the card, an integer between 1 and 13
   */
  public PlayingCard(char suit, int face) {
    this.suit = suit;
    this.face = face;
  }

  /**
   * Returns the suit and face of the card as a string. A 4 of hearts is returned as the string
   * "H4".
   *
   * @return the suit and face of the card as a string
   */
  public String getAsString() {
    return String.format("%s%s", suit, face);
  }

  /**
   * Returns the suit of the card, 'S' for Spades, 'H' for Heart, 'D' for Diamonds and 'C' for
   * Clubs
   *
   * @return the suit of the card
   */
  public char getSuit() {
    return suit;
  }

  /**
   * Returns the face of the card (value between 1 and 13).
   *
   * @return the face of the card
   */
  public int getFace() {
    return face;
  }

  /**
   * Returns the name of the card. Used for image path in CardInitializer and for HandAnalyzer.
   *
   * @return the name of the card
   */
  public String getName() {
    return String.format("%s%s", suit, face);
  }

}