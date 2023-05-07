import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;

public class ClientJavaFx extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root=new BorderPane();
        Label labelNb=new Label("Entrez un nombre :");
        TextField txtNb=new TextField();
        Button buttonTenter=new Button("Envoyer");
        ObservableList<String> listeItems= FXCollections.observableArrayList();
        ListView<String> listView=new ListView<>();
        listView.setItems(listeItems);
        HBox hBox=new HBox();
        hBox.getChildren().addAll(labelNb,txtNb,buttonTenter);
        root.setBottom(hBox);
        root.setCenter(listView);
        Scene scene=new Scene(root,400,500);

        primaryStage.setScene(scene);
        primaryStage.show();
        Socket s=new Socket("localhost",83);
        InputStream is=s.getInputStream();
        OutputStream os=s.getOutputStream();
        BufferedReader br=new BufferedReader(new InputStreamReader(is));
        PrintWriter pr=new PrintWriter(os,true);
        listeItems.addAll(br.readLine());
        /*buttonTenter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pr.println(txtNb.getText());
                try {
                    listeItems.add(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });*/
        //l'expression lambda
        buttonTenter.setOnAction((event)->{
            pr.println(txtNb.getText());
            try {
                listeItems.add(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}
