package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.Random;

public class DeckOfCards {

  private final char[] suits = {'S', 'H', 'D', 'C'};
  private final int[] faces = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};


  public DeckOfCards dealCard(int n){
    if (n < 1 || n > 52){
      throw new IllegalArgumentException("Parameter n must be a number between 1 to 52");
    }
    char suitForCard = assignSuits(n);
    int faceForCard = assignFaces(n);
    PlayingCard card = new PlayingCard(suitForCard, faceForCard);
    System.out.println(card.getAsString());
    return null;
  }
  private char assignSuits(int n){
    char currentSuit = '?';
    if (n >1 && n <= 13){
      currentSuit = 'S';
    }
    else if (n > 13 && n <= 26){
      currentSuit = 'H';
    }
    else if (n > 26 && n <= 39){
      currentSuit = 'D';
    }
    else if (n > 39 && n <= 52){
      currentSuit = 'C';
    }
    return currentSuit;
  }

  private int assignFaces(int n){
    int currentFace = 0;
    if (n % 13 == 0){
      currentFace = 13;
    }
    else{
      currentFace = n % 13;
    }
    return currentFace;
  }

  public void dealHand(){
    Random random = new Random();
    DeckOfCards card = dealCard(random.nextInt(52));
    DeckOfCards card2 = dealCard(random.nextInt(52));
    DeckOfCards card3 = dealCard(random.nextInt(52));
    DeckOfCards card4 = dealCard(random.nextInt(52));
    DeckOfCards card5 = dealCard(random.nextInt(52));

    StringBuilder hand = new StringBuilder();
    hand.append(card);
    hand.append(card2);
    hand.append(card3);
    hand.append(card4);
    hand.append(card5);

    }


}




