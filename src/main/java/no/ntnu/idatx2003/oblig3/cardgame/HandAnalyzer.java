package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class for analyzing a hand of playing cards. The class contains methods for calculating the sum
 * of the face values of the cards in the hand, extracting the hearts from the hand, checking if the
 * hand contains the Queen of Spades, and checking if the hand is a 5-flush.
 */

public class HandAnalyzer {

  private HandAnalyzer() {
  }

  /**
   * Calculates the sum of the face values of the cards in the hand.
   *
   * @param hand a list of playing cards
   * @return the sum of the face values of the cards in the hand
   */
  public static int calculateSum(List<PlayingCard> hand) {
    return hand.stream()
        .mapToInt(PlayingCard::getFace)
        .sum();
  }

  /**
   * Extracts the hearts from the hand. If the hand does not contain any hearts, the method returns
   * "No Hearts".
   *
   * @param hand a list of playing cards
   * @return a string containing the hearts in the hand, or "No Hearts" if the hand does not contain
   * any hearts
   */

  public static String extractHearts(List<PlayingCard> hand) {
    List<PlayingCard> hearts = hand.stream()
        .filter(card -> card.getSuit() == 'H')
        .toList();

    if (hearts.isEmpty()) {
      return "No Hearts";
    } else {
      return hearts.stream()
          .map(PlayingCard::getAsString)
          .collect(Collectors.joining(" "));
    }
  }

  /**
   * Checks if the hand contains the Queen of Spades.
   *
   * @param hand a list of playing cards
   * @return true if the hand contains the Queen of Spades, false otherwise
   */

  public static boolean containsQueenOfSpades(List<PlayingCard> hand) {
    return hand.stream()
        .anyMatch(card -> card.getName().equals("S12"));
  }

  /**
   * Checks if the hand is a 5-flush, i.e., if the hand contains 5 or more cards of the same suit.
   *
   * @param hand a list of playing cards
   * @return true if the hand is a 5-flush, false otherwise
   */
  public static boolean isFiveFlush(List<PlayingCard> hand) {
    return hand.stream()
        .collect(Collectors.groupingBy(PlayingCard::getSuit, Collectors.counting()))
        .values().stream()
        .anyMatch(count -> count >= 5);
  }

  /**
   * Analyzes a hand of playing cards and returns a string containing the sum of the face values of
   * the cards,
   *
   * @param hand a list of playing cards
   * @return a string containing the analysis of the hand
   */

  public static String analyzeHand(List<PlayingCard> hand) {
    int sum = calculateSum(hand);
    String hearts = extractHearts(hand);
    boolean hasQueenOfSpades = containsQueenOfSpades(hand);
    boolean isFiveFlush = isFiveFlush(hand);

    return "Sum of card values: " + sum + "\n" +
        "Hearts on hand: " + hearts + "\n" +
        "Contains Queen of Spades: " + hasQueenOfSpades + "\n" +
        "Is 5-flush: " + isFiveFlush;
  }
}
