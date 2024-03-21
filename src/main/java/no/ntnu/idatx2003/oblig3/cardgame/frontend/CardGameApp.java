package no.ntnu.idatx2003.oblig3.cardgame.frontend;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import no.ntnu.idatx2003.oblig3.cardgame.PlayingCard;
import no.ntnu.idatx2003.oblig3.cardgame.HandAnalyzer;


import java.util.List;

public class CardGameApp extends Application {

  
  private final BorderPane root = new BorderPane();
  private final Label analysisLabel = new Label("");
  private final Label analysisText = new Label();
  private Button showAnalysisButton; // Declare showAnalysisButton as a class member

  @Override
  public void start(Stage primaryStage) {
    HBox cardBox;
    List<PlayingCard> hand = CardInitializer.drawHand(); 
    cardBox = new HBox(10);
    for (PlayingCard card : hand) {
      Node cardNode = CardInitializer.createCardImageView(
          card); 
      cardBox.getChildren().add(cardNode);
    }

    Button forceFlushButton = new Button("Force Flush");
    forceFlushButton.setOnAction(event -> {
      List<PlayingCard> newHand = CardInitializer.forceFlush(); 
      cardBox.getChildren().clear();
      for (PlayingCard card : newHand) {
        Node cardNode = CardInitializer.createCardImageView(
            card); 
        cardBox.getChildren().add(cardNode);
      }
      updateAnalysisText(newHand);
    });
    showAnalysisButton = new Button("Show Analysis");
    showAnalysisButton.setOnAction(event -> toggleAnalysis());

    Button rerollButton = new Button("Re-roll");
    rerollButton.setOnAction(event -> {
      List<PlayingCard> newHand = CardInitializer.drawHand(); // Use CardInitializer to redraw the hand
      cardBox.getChildren().clear();
      for (PlayingCard card : newHand) {
        Node cardNode = CardInitializer.createCardImageView(
            card); // Use CardInitializer to create card images
        cardBox.getChildren().add(cardNode);
      }
      updateAnalysisText(newHand);
    });

    HBox buttonBox = new HBox(10);
    buttonBox.getChildren().addAll(showAnalysisButton, rerollButton, forceFlushButton);
    buttonBox.setAlignment(Pos.CENTER);

    VBox analysisBox = new VBox(10);
    analysisBox.getChildren().addAll(analysisLabel, analysisText);
    analysisBox.setAlignment(Pos.CENTER);

    VBox bottomBox = new VBox(analysisBox, buttonBox);
    BorderPane.setAlignment(bottomBox, Pos.CENTER);

    BorderPane.setMargin(bottomBox, new Insets(-50, 0, 0, 0));

    root.setStyle("-fx-background-color: #356135;");
    root.setCenter(cardBox);
    root.setBottom(bottomBox);

    analysisText.setStyle("-fx-text-fill: white;");
    analysisText.setVisible(false);

    Scene scene = new Scene(root, 450, 250); //450 250
    primaryStage.setScene(scene);
    primaryStage.setTitle("Card game");
    primaryStage.setResizable(true);
    primaryStage.show();
    updateAnalysisText(hand);
  }

  private void updateAnalysisText(List<PlayingCard> hand) {
    String analysis = HandAnalyzer.analyzeHand(hand);
    analysisText.setText(analysis);
  }

  private void toggleAnalysis() {
    if (analysisText.isVisible()) {
      // If analysis is visible, hide it and change button text to "Show Analysis"
      analysisText.setVisible(false);
      showAnalysisButton.setText("Show Analysis");
    } else {
      // If analysis is hidden, show it and change button text to "Hide Analysis"
      analysisText.setVisible(true);
      showAnalysisButton.setText("Hide Analysis");
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}
