package Controller;

import DAO.StateDAO;
import Model.State;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    private ObservableList<State> allStates = FXCollections.observableArrayList();
    @FXML
    private ToggleGroup checkGroup;

    @FXML
    private TextField initialsTxt;

    @FXML
    private TextField praxisNoteTxt;

    @FXML
    private ComboBox<?> statesComboBox;

    @FXML
    private WebView webView;

    @FXML
    void onActionClear(ActionEvent event) {

    }

    @FXML
    void onActionCopy(ActionEvent event) {

    }

    @FXML
    void onActionFirst(ActionEvent event) {

    }

    @FXML
    void onActionHome(ActionEvent event) {




    }

    @FXML
    void onActionPrograms(ActionEvent event) {

    }

    @FXML
    void onActionSecond(ActionEvent event) {

    }

    @FXML
    void onActionStates(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        allStates = StateDAO.getAllStates();
        Stage stage = new Stage();
        State home = null;
        for(State state : allStates){
            if(state.getStateCode().equals("Home")){
                home = state;
            }
        }
        WebEngine e = webView.getEngine();
        e.load(home.getStateArticleURL());
    }
}
