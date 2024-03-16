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
import java.util.ArrayList;
import java.util.List;

public class CardGameApp extends Application {

  @Override
  public void start(Stage primaryStage) {
    DeckOfCards deck = new DeckOfCards();
    deck.drawHand();
    String card1Name = deck.getDrawnCards().get(0).getName();
    String card2Name = deck.getDrawnCards().get(1).getName();
    String card3Name = deck.getDrawnCards().get(2).getName();
    String card4Name = deck.getDrawnCards().get(3).getName();
    String card5Name = deck.getDrawnCards().get(4).getName();

    // Specify the path to the image files
    String imagePathPrefix = "C:/Users/musta/Downloads/oblig3-cardgame-template/src/main/resources/cardimages/";
    //List<String> imagePaths = List.of("C1.png", "C2.png", "C3.png", "C4.png", "C5.png"); // Example card names
    List<String> imagePaths = List.of(card1Name + ".png", card2Name + ".png", card3Name + ".png", card4Name + ".png", card5Name + ".png"); // Example card names

    // Load card images
    List<Image> cardImages = new ArrayList<>();
    for (String imagePath : imagePaths) {
      try {
        cardImages.add(new Image(new FileInputStream(imagePathPrefix + imagePath)));
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    }

    // Create ImageViews for each card image
    List<ImageView> cardImageViews = new ArrayList<>();
    for (Image cardImage : cardImages) {
      ImageView imageView = new ImageView(cardImage);
      double cardWidth = 80;
      double cardHeight = 120;
      imageView.setFitWidth(cardWidth);
      imageView.setFitHeight(cardHeight);
      cardImageViews.add(imageView);
    }

    // Create an HBox to contain the card ImageViews
    HBox cardBox = new HBox(10);
    cardBox.getChildren().addAll(cardImageViews);
    cardBox.setAlignment(Pos.CENTER);

    // Create buttons
    Button rerollButton = new Button("Re-roll");
    Button hiButton = new Button("Hi");
    Button testButton = new Button("Test");

    // Create an HBox to contain the buttons
    HBox buttonBox = new HBox(10);
    buttonBox.getChildren().addAll(rerollButton, hiButton, testButton);
    buttonBox.setAlignment(Pos.CENTER);

    // Create a BorderPane to organize the layout
    BorderPane root = new BorderPane();
    root.setLeft(cardBox);
    root.setCenter(buttonBox);

    Scene scene = new Scene(root, 600, 400);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Card game");

    // Ensure that the window size is fixed
    primaryStage.setResizable(false);

    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
