package no.ntnu.idatx2003.oblig3.cardgame;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.atomic.AtomicBoolean;

public class CardGameApp extends Application {

  private HBox cardBox;
  private BorderPane root; // Declare root as a class member

  @Override
  public void start(Stage primaryStage) {
    // Load initial hand of cards
    redrawHand();

    // Create buttons
    Button rerollButton = new Button("Re-roll");
    Button changeThemeButton = new Button("Change background theme");

    // Create an HBox to contain the buttons
    HBox buttonBox = new HBox(10);
    buttonBox.getChildren().addAll(rerollButton);
    buttonBox.setAlignment(Pos.CENTER);

    // Create a BorderPane to organize the layout
    root = new BorderPane(); // Initialize root here
    root.setLeft(cardBox);
    root.setCenter(buttonBox);

    // Set initial background color to grey
    root.setStyle("-fx-background-color: grey;");

    // Add event handler for the re-roll button
    rerollButton.setOnAction(event -> {
      // Redraw the hand of cards
      System.out.println("Re-rolling hand of cards");
      redrawHand();
    });

    // Boolean variable to track background theme
    AtomicBoolean isGreyTheme = new AtomicBoolean(false);
    isGreyTheme.set(true);

    // Add event handler for the change theme button
    changeThemeButton.setOnAction(event -> {
      // Toggle background theme
      isGreyTheme.set(!isGreyTheme.get()); // Use get() to retrieve the value
      // Update background color of the root BorderPane
      if (isGreyTheme.get()) {
        root.setStyle("-fx-background-color: grey;");
      } else {
        root.setStyle("-fx-background-color: white;");
      }
    });

    // Set the position of the change theme button
    BorderPane.setAlignment(changeThemeButton, Pos.BOTTOM_LEFT);
    root.setBottom(changeThemeButton);

    Scene scene = new Scene(root, 600, 400);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Card game");

    // Ensure that the window size is fixed
    primaryStage.setResizable(false);

    primaryStage.show();
  }

  private void redrawHand() {
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
  }

  private ImageView createCardImageView(PlayingCard card) {
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

  public static void main(String[] args) {
    launch(args);
  }
}
