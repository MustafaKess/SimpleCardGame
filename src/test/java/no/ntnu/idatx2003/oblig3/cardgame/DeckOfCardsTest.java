package no.ntnu.idatx2003.oblig3.cardgame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DeckOfCardsTest {

  @Test
  void testDeckSize() {
    DeckOfCards deck = new DeckOfCards();
    assertEquals(52, deck.deckSize());
  }

  @Test
  void testDrawCard() {
    DeckOfCards deck = new DeckOfCards();
    deck.drawCard();
    assertEquals(51, deck.deckSize());
  }

  @Test
  void testDrawHand() {
    DeckOfCards deck = new DeckOfCards();
    deck.drawHand();
    assertEquals(47, deck.deckSize());
  }

  @Test
  void testDrawHandSize() {
    DeckOfCards deck = new DeckOfCards();
    deck.drawHand();
    assertEquals(5, deck.getDrawnCards().size());
  }
  
}