package ma.enset.tpjdbc.presentation;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ApplicationJavaFx extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        TabPane root= FXMLLoader.load(getClass().getResource("view/main.fxml"));
        Scene scene=new Scene(root,600,400);
        scene.getStylesheets().add(getClass().getResource("css/style.css").toString());
        primaryStage.setTitle("Gestion Client/Commande");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
