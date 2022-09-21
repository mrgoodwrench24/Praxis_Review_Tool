package Model;

public class Program {

    private int programID;
    private String programCode;
    private String programName;
    private String diplomaLine1;
    private String diplomaLine2;
    private String diplomaType;
    private String programType;
    private String notes;

    public Program(int programID, String programCode, String programName, String diplomaLine1, String diplomaLine2, String diplomaType, String programType, String notes) {
        this.programID = programID;
        this.programCode = programCode;
        this.programName = programName;
        this.diplomaLine1 = diplomaLine1;
        this.diplomaLine2 = diplomaLine2;
        this.diplomaType = diplomaType;
        this.programType = programType;
        this.notes = notes;
    }

    public int getProgramID() {
        return programID;
    }

    public void setProgramID(int programID) {
        this.programID = programID;
    }

    public String getProgramCode() {
        return programCode;
    }

    public void setProgramCode(String programCode) {
        this.programCode = programCode;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getDiplomaLine1() {
        return diplomaLine1;
    }

    public void setDiplomaLine1(String diplomaLine1) {
        this.diplomaLine1 = diplomaLine1;
    }

    public String getDiplomaLine2() {
        return diplomaLine2;
    }

    public void setDiplomaLine2(String diplomaLine2) {
        this.diplomaLine2 = diplomaLine2;
    }

    public String getDiplomaType() {
        return diplomaType;
    }

    public void setDiplomaType(String diplomaType) {
        this.diplomaType = diplomaType;
    }

    public String getProgramType() {
        return programType;
    }

    public void setProgramType(String programType) {
        this.programType = programType;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Program{" +
                "programID=" + programID +
                ", programCode='" + programCode + '\'' +
                ", programName='" + programName + '\'' +
                ", diplomaLine1='" + diplomaLine1 + '\'' +
                ", diplomaLine2='" + diplomaLine2 + '\'' +
                ", diplomaType='" + diplomaType + '\'' +
                ", programType='" + programType + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
