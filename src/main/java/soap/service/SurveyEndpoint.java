package soap.service;

import localhost._8080.soapservice.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.*;
import soap.entity.Survey;
import soap.repository.SpecialtyRepository;
import soap.repository.SurveyRepository;

import java.util.ArrayList;
import java.util.List;


@Endpoint
public class SurveyEndpoint {
    private static final String NAMESPACE_URI = "http://localhost:8080/soapservice";

    private SurveyRepository surveyRepository;

    @Autowired
    public SurveyEndpoint(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getSurveyByCodeRequest")
    @ResponsePayload
    public GetSurveyByCodeResponse getSurveyByCodeResponse(@RequestPayload GetSurveyByCodeRequest request) {
        GetSurveyByCodeResponse response = new GetSurveyByCodeResponse();
        List<Survey> survey = surveyRepository.findBySpecialtyCode(request.getCode());
        List<localhost._8080.soapservice.Survey> surveyList = new ArrayList<>();
        localhost._8080.soapservice.Survey surv = new localhost._8080.soapservice.Survey();
        for (Survey elem:survey) {
            surv.setId(elem.getId());
            surv.setInstitute(elem.getInstitute());
            surv.setDepartment(elem.getDepartment());
            surv.setSpecialtyCode(elem.getSpecialtyCode());
            surv.setSpecialty(elem.getSpecialty());
            surv.setCurse(elem.getCurse());
            surv.setStudyForm(elem.getStudyForm());
            surv.setAnswer1(elem.getAnswer1());
            surv.setAnswer2(elem.getAnswer2());
            surveyList.add(surv);
        }
        SurveyList returnArray = new SurveyList();
        returnArray.setValue(surveyList);
        response.setSurveyList(returnArray);
        return response;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAnswersByCurseRequest")
    @ResponsePayload
    public GetAnswersByCurseResponse getAnswersByCurseResponse(@RequestPayload GetAnswersByCurseRequest request) {
        GetAnswersByCurseResponse response = new GetAnswersByCurseResponse();
        List<Survey> survey = surveyRepository.findByCurse(request.getCurse());
        List<localhost._8080.soapservice.Survey> surveyList = new ArrayList<>();
        localhost._8080.soapservice.Survey surv = new localhost._8080.soapservice.Survey();
        for (Survey elem:survey) {
            surv.setId(elem.getId());
            surv.setInstitute(elem.getInstitute());
            surv.setDepartment(elem.getDepartment());
            surv.setSpecialtyCode(elem.getSpecialtyCode());
            surv.setSpecialty(elem.getSpecialty());
            surv.setCurse(elem.getCurse());
            surv.setStudyForm(elem.getStudyForm());
            surv.setAnswer1(elem.getAnswer1());
            surv.setAnswer2(elem.getAnswer2());
            surveyList.add(surv);
        }
        SurveyList returnArray = new SurveyList();
        returnArray.setValue(surveyList);
        response.setSurveyList(returnArray);
        return response;
    }
}