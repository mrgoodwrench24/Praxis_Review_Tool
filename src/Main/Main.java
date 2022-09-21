package Main;

import DAO.SQLiteJDBC;
import DAO.StateDAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;


import java.io.IOException;

public class Main extends Application {
    //static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{

        try {
            Parent root;

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MainView.fxml"));
            root = loader.load();

            Scene scene = new Scene(root, 1024, 768);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch(NullPointerException e){
            e.printStackTrace();
        }


    }


    public static void main(String[] args) throws IOException {
        SQLiteJDBC.connect();

        try {
            StateDAO.setAllStates();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        launch(args);
    }
}
