package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("15 Game Puzzle");
        primaryStage.setMinHeight(680.0);
        primaryStage.setMinWidth(460.0);
        primaryStage.setMaxHeight(680.0);
        primaryStage.setMaxWidth(460.0);
        primaryStage.setX(500);
        primaryStage.setY(100);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
