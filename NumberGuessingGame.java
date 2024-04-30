import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Random;

public class NumberGuessingGame extends Application {

    private int randomNumber;
    private int attempts;

    @Override
    public void start(Stage primaryStage) {
        Random random = new Random();
        randomNumber = random.nextInt(100) + 1; // Generate a random number between 1 and 100
        attempts = 0;

        Label instructionLabel = new Label("Guess the number between 1 and 100:");
        TextField guessTextField = new TextField();
        Label resultLabel = new Label();
        Button guessButton = new Button("Guess");

        guessButton.setOnAction(event -> {
            try {
                int guess = Integer.parseInt(guessTextField.getText());
                attempts++;
                if (guess == randomNumber) {
                    resultLabel.setText("Congratulations! You've guessed the number in " + attempts + " attempts.");
                } else if (guess < randomNumber) {
                    resultLabel.setText("Too low. Try again.");
                } else {
                    resultLabel.setText("Too high. Try again.");
                }
            } catch (NumberFormatException e) {
                resultLabel.setText("Invalid input. Please enter a valid number.");
            }
        });

        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(instructionLabel, guessTextField, guessButton, resultLabel);

        Scene scene = new Scene(root, 300, 200);

        primaryStage.setTitle("Number Guessing Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}