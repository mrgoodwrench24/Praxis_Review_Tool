package DAO;

import Model.State;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;

public class StateDAO {
    private static final ObservableList<State> allStates = FXCollections.observableArrayList();

    public static void setAllStates() throws Exception{
        String sqlStatement = "select * from States";
        Query.makeQuery(sqlStatement);
        ResultSet result = Query.getResult();
        while (result.next()){
            int stateID = result.getInt("stateID");
            String stateCode = result.getString("stateCode");
            String stateName = result.getString("stateName");
            String stateArticleUrl = result.getString("stateArticleUrl");
            State state = new State(stateID, stateCode, stateName, stateArticleUrl);
            allStates.add(state);
        }

    }

    public static ObservableList<State> getAllStates(){
        return allStates;
    }
}
