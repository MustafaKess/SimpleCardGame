package no.ntnu.idatx2003.oblig3.cardgame;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class CardCreation extends StackPane {

  public CardCreation(PlayingCard card, String imagePath) {
    ImageView imageView = createCardImageView(card, imagePath);
    getChildren().add(imageView);
  }

  private ImageView createCardImageView(PlayingCard card, String imagePath) {
    // Construct the file path for the image based on the card name
    String fileName = card.getName() + ".png";
    String filePath = imagePath + "/" + fileName;

    // Load the image from the specified file path
    Image image = new Image("file:///" + filePath);

    // Create an ImageView for the image
    ImageView imageView = new ImageView(image);
    imageView.setFitWidth(80); // Set the width of the ImageView
    imageView.setFitHeight(120); // Set the height of the ImageView

    return imageView;
  }
}
