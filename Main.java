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
        primaryStage.setTitle("Hello World");
        primaryStage.setMinHeight(650.0);
        primaryStage.setMinWidth(650.0);
        primaryStage.setMaxHeight(650.0);
        primaryStage.setMaxWidth(650.0);
        primaryStage.setX(500);
        primaryStage.setY(100);
        primaryStage.setScene(new Scene(root, 500, 550));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
