package no.ntnu.idatx2003.oblig3.cardgame.frontend;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import no.ntnu.idatx2003.oblig3.cardgame.DeckOfCards;
import no.ntnu.idatx2003.oblig3.cardgame.PlayingCard;

public class CardInitializer {

  public static HBox initializeHand() {
    DeckOfCards deck = new DeckOfCards();
    deck.drawHand();

    HBox cardBox = new HBox(10);

    // Load card images
    for (PlayingCard card : deck.getDrawnCards()) {
      ImageView imageView = createCardImageView(card);
      cardBox.getChildren().add(imageView); // Add the new card image to the HBox
    }
    cardBox.setAlignment(Pos.CENTER);

    return cardBox;
  }

  public static HBox redrawHand(HBox cardBox) {
    DeckOfCards deck = new DeckOfCards();
    deck.drawHand();

    // Clear existing cards
    if (cardBox != null) {
      cardBox.getChildren().clear();
    } else {
      cardBox = new HBox(10); // Create a new HBox if it doesn't exist
    }

    // Load card images
    for (PlayingCard card : deck.getDrawnCards()) {
      ImageView imageView = createCardImageView(card);
      cardBox.getChildren().add(imageView); // Add the new card image to the HBox
    }
    cardBox.setAlignment(Pos.CENTER);

    return cardBox;
  }

  private static ImageView createCardImageView(PlayingCard card) {
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
