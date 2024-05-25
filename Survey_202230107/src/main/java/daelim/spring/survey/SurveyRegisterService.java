package daelim.spring.survey;

import daelim.spring.controller.SurveyCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SurveyRegisterService {

    @Autowired
    private SurveyDao surveyDao;

    public SurveyRegisterService() {
    }

    @Transactional
    public void regist(SurveyCommand sc) throws Exception {
        Survey newSurvey = new Survey(sc.getQ1(), sc.getQ2(), sc.getQ3(), sc.getRespondentName(), sc.getRespondentAge());
        try {
            surveyDao.insert(newSurvey);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<Survey> selectAllSurveys(){
        System.out.println(surveyDao.selectAll());
        return surveyDao.selectAll();
    }
}
