package no.ntnu.idatx2003.oblig3.cardgame.frontend;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import no.ntnu.idatx2003.oblig3.cardgame.DeckOfCards;
import no.ntnu.idatx2003.oblig3.cardgame.PlayingCard;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * Class for initializing the cards and creating the card images.
 * <p> The class contains methods for drawing a hand of cards,
 * creating an ImageView for the card images,
 */

public class CardInitializer {

  private CardInitializer() {

  }

  /**
   * Draws a hand of cards from the deck.
   *
   * @return a list of 5 playing cards.
   */
  public static List<PlayingCard> drawHand() {
    DeckOfCards deck = new DeckOfCards();
    deck.drawHand();
    return deck.getDrawnCards();
  }

  /**
   * Creates an ImageView for the card image. The card image is retrieved from the "cardimages"
   * folder in the "resources" folder.
   *
   * @param card a playing card
   * @return an ImageView of the card image
   */

  public static ImageView createCardImageView(PlayingCard card) {
    String imagePath =
        "C:/Users/musta/Downloads/oblig3-cardgame-template/src/main/resources/cardimages/"
            + card.getName() + ".png";
    Image image = null;
    try {
      image = new Image(new FileInputStream(imagePath));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    ImageView imageView = new ImageView(image);
    double cardWidth = 80;
    double cardHeight = 120;
    imageView.setFitWidth(cardWidth);
    imageView.setFitHeight(cardHeight);
    return imageView;
  }

  /**
   * Forces a flush by drawing 5 cards of the same suit. This suit is hardcoded.
   *
   * @return a list of 5 playing cards of the same suit.
   */

  public static List<PlayingCard> forceFlush() {
    DeckOfCards deck = new DeckOfCards();
    deck.forceFlush();
    return deck.getDrawnCards();
  }
}
