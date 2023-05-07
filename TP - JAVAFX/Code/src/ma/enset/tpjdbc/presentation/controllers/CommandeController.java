package ma.enset.tpjdbc.presentation.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.enset.tpjdbc.dao.CommandeDaoImpl;
import ma.enset.tpjdbc.dao.ClientDaoImpl;
import ma.enset.tpjdbc.dao.entities.Commande;
import ma.enset.tpjdbc.services.GestionService;
import ma.enset.tpjdbc.services.GestionServiceImpl;

import java.net.URL;
import java.util.ResourceBundle;

public class CommandeController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TableView<Commande> tableCommande;
    @FXML
    private TableColumn<Commande,Integer> colID;
    @FXML
    private TableColumn<Commande,String> colNOM;

    ObservableList<Commande> observableList= FXCollections.observableArrayList();
    GestionService gestionService;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gestionService =new GestionServiceImpl(new ClientDaoImpl(),new CommandeDaoImpl());

        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNOM.setCellValueFactory(new PropertyValueFactory<>("nom"));

        tableCommande.setItems(observableList);
        loadCommande();
    }
    @FXML
    private void addCommande(){
        String nomCom=nom.getText();

        if(nomCom.isEmpty()){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Veuillez saisir un nom !!!");
            alert.show();
        }else{
            Commande c=new Commande();
            c.setNom(nomCom);
            gestionService.addCommande(c);
            loadCommande();
        }
    }
    @FXML
    private void removeCommande(){
        Commande c= tableCommande.getSelectionModel().getSelectedItem();
        if(c!=null){
            gestionService.removeCommande(c);
            observableList.remove(c);
        }else{
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Veuillez sélectionner un élément !!");
            alert.show();
        }
        loadCommande();
    }
    private void loadCommande() {
        observableList.clear();
        observableList.addAll(gestionService.getAllCommandes());
    }
}
