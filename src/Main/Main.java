package Main;

import DAO.SQLiteJDBC;
import DAO.StateDAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;


import java.io.IOException;

public class Main extends Application {
    //static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{

        try {
            Parent root;
            URL url = getClass().getClassLoader().getResource("View/MainView.fxml");
            System.out.println(url);
            FXMLLoader loader = new FXMLLoader(url);
            root = loader.load();

            Scene scene = new Scene(root, 1024, 800);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch(NullPointerException e){
            e.printStackTrace();
        }


    }


    public static void main(String[] args) throws Exception {
        SQLiteJDBC.connect();
        StateDAO.setAllStates();


        launch(args);
    }
}
