package daelim.spring.controller;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

public class SurveyCommand {
    @NotEmpty(message = "필수 항목입니다.")
    private String q1;

    @NotEmpty(message = "필수 항목입니다.")
    private String q2;

    @NotEmpty(message = "필수 항목입니다. 공백은 허용하지 않습니다.")
    private String q3;

    @NotEmpty(message = "필수 항목입니다. 공백은 허용하지 않습니다.")
    private String respondentName;

    @NotNull(message = "반드시 1보다 같거나 커야 합니다.")
    @Min(value = 1, message = "반드시 1보다 같거나 커야 합니다.")
    private Integer respondentAge;

    public String getQ1() {
        return q1;
    }

    public void setQ1(String q1) {
        this.q1 = q1;
    }

    public String getQ2() {
        return q2;
    }

    public void setQ2(String q2) {
        this.q2 = q2;
    }

    public String getQ3() {
        return q3;
    }

    public void setQ3(String q3) {
        this.q3 = q3;
    }

    public String getRespondentName() {
        return respondentName;
    }

    public void setRespondentName(String respondentName) {
        this.respondentName = respondentName;
    }

    public Integer getRespondentAge() {
        return respondentAge;
    }

    public void setRespondentAge(Integer respondentAge) {
        this.respondentAge = respondentAge;
    }
}
