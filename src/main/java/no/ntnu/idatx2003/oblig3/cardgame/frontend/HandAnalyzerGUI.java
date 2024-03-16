package no.ntnu.idatx2003.oblig3.cardgame.frontend;

import javafx.geometry.Pos;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import no.ntnu.idatx2003.oblig3.cardgame.HandAnalyzer;
import no.ntnu.idatx2003.oblig3.cardgame.PlayingCard;

import java.util.List;

public class HandAnalyzerGUI extends VBox {

  private TextArea resultTextArea;

  public HandAnalyzerGUI(List<PlayingCard> hand, TextArea resultTextArea) {
    this.resultTextArea = resultTextArea;
    this.resultTextArea.setEditable(false);
    this.resultTextArea.setWrapText(true);
    this.getChildren().add(this.resultTextArea);
    this.setAlignment(Pos.CENTER);
    updateHand(hand);
  }

  public void updateHand(List<PlayingCard> hand) {
    int sum = HandAnalyzer.calculateSum(hand);
    String hearts = HandAnalyzer.extractHearts(hand);
    boolean hasQueenOfSpades = HandAnalyzer.containsQueenOfSpades(hand);
    boolean isFiveFlush = HandAnalyzer.isFiveFlush(hand);

    // Display results in the text area
    resultTextArea.setText("Sum of card values: " + sum + "\n" +
        "Hearts on hand: " + hearts + "\n" +
        "Contains Queen of Spades: " + hasQueenOfSpades + "\n" +
        "Is 5-flush: " + isFiveFlush);
  }
}
