package Model;

public class State {
    private int stateID;
    private String stateCode;
    private String stateName;
    private String stateArticleURL;

    public State(int stateID, String stateCode, String stateName, String stateArticleURL) {
        this.stateID = stateID;
        this.stateCode = stateCode;
        this.stateName = stateName;
        this.stateArticleURL = stateArticleURL;
    }

    public int getStateID() {
        return stateID;
    }

    public void setStateID(int stateID) {
        this.stateID = stateID;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateArticleURL() {
        return stateArticleURL;
    }

    public void setStateArticleURL(String stateArticleURL) {
        this.stateArticleURL = stateArticleURL;
    }

    @Override
    public String toString() {
        return stateName;
    }
}
