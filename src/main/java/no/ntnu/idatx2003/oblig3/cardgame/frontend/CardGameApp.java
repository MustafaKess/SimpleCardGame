package no.ntnu.idatx2003.oblig3.cardgame.frontend;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import no.ntnu.idatx2003.oblig3.cardgame.PlayingCard;
import no.ntnu.idatx2003.oblig3.cardgame.HandAnalyzer;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class CardGameApp extends Application {

  private HBox cardBox;
  private BorderPane root = new BorderPane();
  private Text analysisText = new Text();

  @Override
  public void start(Stage primaryStage) {
    List<PlayingCard> hand = CardInitializer.initializeHand();
    cardBox = new HBox(10);
    for (PlayingCard card : hand) {
      Node cardNode = CardInitializer.createCardImageView(card);
      cardBox.getChildren().add(cardNode);
    }

    Button rerollButton = new Button("Re-roll");
    Button changeThemeButton = new Button("Change background theme");

    HBox buttonBox = new HBox(10);
    buttonBox.getChildren().addAll(rerollButton, changeThemeButton);
    buttonBox.setAlignment(Pos.CENTER);

    AtomicBoolean isGreyTheme = new AtomicBoolean(false);
    isGreyTheme.set(true);

    changeThemeButton.setOnAction(event -> {
      isGreyTheme.set(!isGreyTheme.get());
      if (isGreyTheme.get()) {
        root.setStyle("-fx-background-color: grey;");
      } else {
        root.setStyle("-fx-background-color: white;");
      }
    });

    rerollButton.setOnAction(event -> {
      List<PlayingCard> newHand = CardInitializer.redrawHand();
      cardBox.getChildren().clear();
      for (PlayingCard card : newHand) {
        Node cardNode = CardInitializer.createCardImageView(card);
        cardBox.getChildren().add(cardNode);
      }
      updateAnalysisText(newHand);
    });

    BorderPane.setAlignment(buttonBox, Pos.BOTTOM_LEFT);
    root.setBottom(buttonBox);

    root.setStyle("-fx-background-color: grey;");

    root.setCenter(cardBox);

    Scene scene = new Scene(root, 600, 400);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Card game");
    primaryStage.setResizable(false);
    primaryStage.show();

    updateAnalysisText(hand);
  }

  private void updateAnalysisText(List<PlayingCard> hand) {
    String analysis = HandAnalyzer.analyzeHand(hand); // Using HandAnalyzer to analyze the hand
    analysisText.setText(analysis);
  }

  public static void main(String[] args) {
    launch(args);
  }
}
