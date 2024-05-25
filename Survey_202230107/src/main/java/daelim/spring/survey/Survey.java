package daelim.spring.survey;

import java.sql.Timestamp;

public class Survey {

    private int ID;
    private String Q1;
    private String Q2;
    private String Q3;
    private String respondentName;
    private int respondentAge;

    private Timestamp regdate;

    public Survey(String Q1, String Q2, String Q3, String respondentName, int respondentAge) {
        this.Q1 = Q1;
        this.Q2 = Q2;
        this.Q3 = Q3;
        this.respondentName = respondentName;
        this.respondentAge = respondentAge;
    }

    public Survey(int ID, String Q1, String Q2, String Q3, String respondentName, int respondentAge, Timestamp regdate) {
        this.ID = ID;
        this.Q1 = Q1;
        this.Q2 = Q2;
        this.Q3 = Q3;
        this.respondentName = respondentName;
        this.respondentAge = respondentAge;
        this.regdate = regdate;
    }

    public int getID() {
        return ID;
    }


    public Timestamp getRegdate() {
        return regdate;
    }


    public String getQ1() {
        return Q1;
    }


    public String getQ2() {
        return Q2;
    }


    public String getQ3() {
        return Q3;
    }


    public String getRespondentName() {
        return respondentName;
    }


    public int getRespondentAge() {
        return respondentAge;
    }

}
