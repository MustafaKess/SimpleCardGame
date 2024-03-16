package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.List;
import java.util.stream.Collectors;

public class HandAnalyzer {

  // Task 1: Calculate the sum of all card values
  public static int calculateSum(List<PlayingCard> hand) {
    return hand.stream()
        .mapToInt(PlayingCard::getFace)
        .sum();
  }

  // Task 2: Extract hearts from the hand and return as a string
  public static String extractHearts(List<PlayingCard> hand) {
    List<PlayingCard> hearts = hand.stream()
        .filter(card -> card.getSuit() == 'H')
        .collect(Collectors.toList());

    if (hearts.isEmpty()) {
      return "No Hearts";
    } else {
      return hearts.stream()
          .map(PlayingCard::getAsString)
          .collect(Collectors.joining(" "));
    }
  }

  // Task 3: Check if the hand contains the Queen of Spades
  public static boolean containsQueenOfSpades(List<PlayingCard> hand) {
    return hand.stream()
        .anyMatch(card -> card.getName().equals("S12"));
  }

  // Task 4: Check if the hand forms a 5-flush
  public static boolean isFiveFlush(List<PlayingCard> hand) {
    return hand.stream()
        .collect(Collectors.groupingBy(PlayingCard::getSuit, Collectors.counting()))
        .values().stream()
        .anyMatch(count -> count >= 5);
  }

  // Analyze the hand and return the result as a String
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
