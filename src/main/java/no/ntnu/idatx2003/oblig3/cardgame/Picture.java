package no.ntnu.idatx2003.oblig3.cardgame;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class Picture extends StackPane {

  public Picture(Image image, double maxWidth, double maxHeight) {
    ImageView imageView = new ImageView(image);

    // Set the maximum width and height of the image view
    imageView.setFitWidth(maxWidth);
    imageView.setFitHeight(maxHeight);

    getChildren().add(imageView);
  }
}
