import no.ntnu.idatx2003.oblig3.cardgame.DeckOfCards;
import java.util.Random;

public class main {
  public static void main(String[] args) {
    /*
    DeckOfCards deck = new DeckOfCards();
    Random random = new Random();
    int randomNumber = random.nextInt(52);
    System.out.println(randomNumber);
    deck.dealCard(randomNumber);
     */
    DeckOfCards deck = new DeckOfCards();
    deck.dealHand();
  }

}
