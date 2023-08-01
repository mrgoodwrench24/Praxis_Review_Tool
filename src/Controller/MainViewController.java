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
import javafx.scene.control.*;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    private ObservableList<State> allStates = FXCollections.observableArrayList();
    private State home = null;

    private State sec = null;
    private String status = null;

    private State selectedState = null;

    @FXML
    private RadioButton clearedButton;

    @FXML
    private RadioButton notClearedButton;


    @FXML
    private TextField stateTxt;

    @FXML
    private TextField initialsTxt;

    @FXML
    private TextArea praxisNoteText;

    @FXML
    private ComboBox<State> statesComboBox;

    @FXML
    private WebView webView;

    @FXML
    void onActionInitial(ActionEvent event) {
        statesComboBox.setVisible(true);

    }

    @FXML
    void onActionSecondary(ActionEvent event) {
        statesComboBox.setVisible(false);
        for(State state : allStates) {
            if (state.getStateCode().equals("Sec")) {
                sec = state;
            }
        }
        WebEngine e = webView.getEngine();
        e.load(sec.getStateArticleURL());

    }

    @FXML
    void onActionCleared(ActionEvent event) {
        status = "Cleared";
        setNote();

    }

    @FXML
    void onActionNotCleared(ActionEvent event) {
        status = "Not Cleared";
        setNote();
    }

    @FXML
    void onActionClear(ActionEvent event) {
        praxisNoteText.clear();
        clearedButton.setSelected(false);
        notClearedButton.setSelected(false);
        stateTxt.clear();
    }

    @FXML
    void onActionCopy(ActionEvent event) {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent content = new ClipboardContent();
        content.putString(praxisNoteText.getText());
        clipboard.setContent(content);
    }



    @FXML
    void onActionHome(ActionEvent event) {
        try {
            WebEngine e = webView.getEngine();
            e.load(home.getStateArticleURL());
        }catch(ClassCastException e){
            e.printStackTrace();
        }

    }


    @FXML
    void onActionStates(ActionEvent event) {
        ObservableList<State> filteredStates = FXCollections.observableArrayList();
        String userText = String.valueOf(statesComboBox.getValue()).toLowerCase();
        if(userText != null){
            statesComboBox.show();
            filteredStates = filterStates(userText, filteredStates);
            statesComboBox.setItems(filteredStates);
            selectedState = statesComboBox.getSelectionModel().getSelectedItem();
        }
        else{
            selectedState = statesComboBox.getSelectionModel().getSelectedItem();

        }

        stateTxt.setText(selectedState.getStateCode());
        WebEngine e = webView.getEngine();
        e.load(selectedState.getStateArticleURL());

        statesComboBox.setItems(allStates);

    }

    private ObservableList<State> filterStates(String userText, ObservableList<State> filteredStates){
        for(State filter : allStates){
            String code = filter.getStateCode().toLowerCase();
            String name = filter.getStateName().toLowerCase();
            if(code.contains(userText) || name.contains(userText)){
                filteredStates.add(filter);
            }
        }
        return filteredStates;
    }

    private void setNote(){
        praxisNoteText.setText(status + " " + stateTxt.getText() + " " + initialsTxt.getText().toUpperCase());



    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        allStates = StateDAO.getAllStates();
        for(State state : allStates){
            if(state.getStateCode().equals("Home")){
                home = state;
            }
        }
        WebEngine e = webView.getEngine();
        e.load(home.getStateArticleURL());
        statesComboBox.setItems(allStates);
    }
}
