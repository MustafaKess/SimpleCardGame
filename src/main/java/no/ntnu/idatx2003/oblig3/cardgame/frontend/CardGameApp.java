package no.ntnu.idatx2003.oblig3.cardgame.frontend;

import java.util.concurrent.atomic.AtomicBoolean;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CardGameApp extends Application {

  private HBox cardBox;
  private BorderPane root = new BorderPane(); // Initialize root here

  @Override
  public void start(Stage primaryStage) {
    // Load initial hand of cards
    cardBox = CardInitializer.initializeHand();

    // Create buttons
    Button rerollButton = new Button("Re-roll");
    Button changeThemeButton = new Button("Change background theme");

    // Create an HBox to contain the buttons
    HBox buttonBox = new HBox(10);
    buttonBox.getChildren().addAll(rerollButton);
    buttonBox.setAlignment(Pos.CENTER);

    // Add event handler for the re-roll button
    rerollButton.setOnAction(event -> {
      // Redraw the hand of cards
      System.out.println("Re-rolling hand of cards");
      cardBox = CardInitializer.redrawHand(cardBox);
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

    // Set initial background color to grey
    root.setStyle("-fx-background-color: grey;");

    // Create a BorderPane to organize the layout
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
