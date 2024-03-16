package no.ntnu.idatx2003.oblig3.cardgame.frontend;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import no.ntnu.idatx2003.oblig3.cardgame.DeckOfCards;
import no.ntnu.idatx2003.oblig3.cardgame.PlayingCard;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class CardInitializer {

  public static List<PlayingCard> initializeHand() {
    DeckOfCards deck = new DeckOfCards();
    deck.drawHand();
    return deck.getDrawnCards();
  }

  public static List<PlayingCard> redrawHand() {
    DeckOfCards deck = new DeckOfCards();
    deck.drawHand();
    return deck.getDrawnCards();
  }

  public static ImageView createCardImageView(PlayingCard card) {
    // Specify the path to the image file
    String imagePath = "C:/Users/musta/Downloads/oblig3-cardgame-template/src/main/resources/cardimages/" + card.getName() + ".png";
    Image image = null;
    try {
      image = new Image(new FileInputStream(imagePath));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    // Create ImageView for the card image
    ImageView imageView = new ImageView(image);
    double cardWidth = 80;
    double cardHeight = 120;
    imageView.setFitWidth(cardWidth);
    imageView.setFitHeight(cardHeight);
    return imageView;
  }
}
