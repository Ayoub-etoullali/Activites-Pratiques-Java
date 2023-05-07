package ma.enset.tpjdbc.presentation.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.enset.tpjdbc.dao.CommandeDaoImpl;
import ma.enset.tpjdbc.dao.ClientDaoImpl;
import ma.enset.tpjdbc.dao.entities.Commande;
import ma.enset.tpjdbc.dao.entities.Client;
import ma.enset.tpjdbc.services.GestionService;
import ma.enset.tpjdbc.services.GestionServiceImpl;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientsController implements Initializable {
 @FXML
 private TextField textNom;
 @FXML
 private TextArea textPrenom;
 @FXML
 private TextField textAge;
 @FXML
 private ComboBox<Commande> commandeComboBox;
 @FXML
 private TextField textSearch;
 @FXML
 private TableView<Client> clientTableView;
 @FXML
 private TableColumn<Client,Integer> colID;
 @FXML
 private TableColumn<Client,String > colNom;
 @FXML
 private TableColumn<Client,String > colPrenom;
 @FXML
 private TableColumn<Client,Integer > colAge;
 @FXML
 private TableColumn<Client, Commande> colCommande;

 private ObservableList<Client> observableList= FXCollections.observableArrayList();
 private GestionService gestionService;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gestionService =new GestionServiceImpl(new ClientDaoImpl(),new CommandeDaoImpl() );

        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        colCommande.setCellValueFactory(new PropertyValueFactory<>("commande"));

        commandeComboBox.getItems().addAll(gestionService.getAllCommandes());

        textSearch.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                observableList.clear();
                observableList.addAll(gestionService.getClientsParNom(newValue));
            }
        });

        clientTableView.setItems(observableList);
        loadClients();
    }
    @FXML
    private void addClient(){
        String nom=textNom.getText();
        String prenom= textPrenom.getText();
        int age=Integer.parseInt(textAge.getText());
        Commande commande= commandeComboBox.getSelectionModel().getSelectedItem();

        if(nom.isEmpty()){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Veuillez saisir un nom !!!");
            alert.show();
        }else{
            Client c=new Client();
            c.setNom(nom);
            c.setPrenom(prenom);
            c.setAge(age);
            c.setCommande(commande);
            gestionService.addCLient(c);
        }
        loadClients();
    }
    @FXML
    private void deleteClient(){
        Client c= clientTableView.getSelectionModel().getSelectedItem();
        if(c!=null){
            gestionService.deleteClient(c);
            observableList.remove(c);
        }else{
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Veuillez sélectionner un élément !!");
            alert.show();
        }
        loadClients();

    }
    public  void updateClient(){
        loadClients();
    }
    public  void clearClients(){
        observableList.clear();
    }
    private void loadClients(){
        observableList.clear();
        observableList.addAll(gestionService.getAllClients());
    }
}
