package soap.service;

import localhost._8080.soapservice.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.*;
import soap.entity.Survey;
import soap.repository.QuestionRepository;
import soap.repository.SurveyRepository;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;


@Endpoint
public class SurveyEndpoint {
    private static final String NAMESPACE_URI = "http://192.168.137.126:8080/soapservice";

    private SurveyRepository surveyRepository;
    private QuestionRepository questionRepository;

    private SurveyList makeSurveyList(List<Survey> survey) {
        SurveyList returnArray = new SurveyList();
        List<localhost._8080.soapservice.Survey> surveyList = new ArrayList<>();
        localhost._8080.soapservice.Survey surv;
        for (Survey elem:survey) {
            surv = new localhost._8080.soapservice.Survey();
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
        returnArray.setValue(surveyList);
        return returnArray;
    }

    @Autowired
    public SurveyEndpoint(SurveyRepository surveyRepository, QuestionRepository questionRepository) {
        this.surveyRepository = surveyRepository;
        this.questionRepository = questionRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAnswersByCodeRequest")
    @ResponsePayload
    public GetAnswersByCodeResponse getAnswersByCodeResponse(@RequestPayload GetAnswersByCodeRequest request) {
        GetAnswersByCodeResponse response = new GetAnswersByCodeResponse();
        List<Survey> survey = surveyRepository.findAllBySpecialtyCode(request.getCode());
        response.setSurveyList(makeSurveyList(survey));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAnswersByCurseRequest")
    @ResponsePayload
    public GetAnswersByCurseResponse getAnswersByCurseResponse(@RequestPayload GetAnswersByCurseRequest request) {
        GetAnswersByCurseResponse response = new GetAnswersByCurseResponse();
        List<Survey> survey = surveyRepository.findAllByCurse(request.getCurse());
        response.setSurveyList(makeSurveyList(survey));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAnswersByDepartmentRequest")
    @ResponsePayload
    public GetAnswersByDepartmentResponse getAnswersByDepartmentResponse(@RequestPayload GetAnswersByDepartmentRequest request) {
        GetAnswersByDepartmentResponse response = new GetAnswersByDepartmentResponse();
        List<Survey> survey = surveyRepository.findAllByDepartment(request.getDepartment());
        response.setSurveyList(makeSurveyList(survey));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAnswersByInstituteRequest")
    @ResponsePayload
    public GetAnswersByInstituteResponse getAnswersByInstituteResponse(@RequestPayload GetAnswersByInstituteRequest request) {
        GetAnswersByInstituteResponse response = new GetAnswersByInstituteResponse();
        List<Survey> survey = surveyRepository.findAllByInstitute(request.getInstitute());
        response.setSurveyList(makeSurveyList(survey));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAnswersBySpecialtyRequest")
    @ResponsePayload
    public GetAnswersBySpecialtyResponse getAnswersBySpecialtyResponse(@RequestPayload GetAnswersBySpecialtyRequest request) {
        GetAnswersBySpecialtyResponse response = new GetAnswersBySpecialtyResponse();
        List<Survey> survey = surveyRepository.findAllBySpecialty(request.getSpecialty());
        response.setSurveyList(makeSurveyList(survey));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAnswersByStudyFormRequest")
    @ResponsePayload
    public GetAnswersByStudyFormResponse getAnswersByCurseResponse(@RequestPayload GetAnswersByStudyFormRequest request) {
        GetAnswersByStudyFormResponse response = new GetAnswersByStudyFormResponse();
        List<Survey> survey = surveyRepository.findAllByStudyForm(request.getStudyForm());
        response.setSurveyList(makeSurveyList(survey));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllRequest")
    @ResponsePayload
    public GetAllResponse getAllResponse(@RequestPayload GetAllRequest request) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        GetAllResponse response = new GetAllResponse();
        List<String> returnArray = new ArrayList<>();
        System.out.println("getFieldName "+request.getFieldName());
        Method method = surveyRepository.getClass().getMethod("findAllGroupBy"+request.getFieldName());
        System.out.println("method "+method.getName());
        List<Survey> surveyList = (List<Survey>) method.invoke(surveyRepository);
        System.out.println("surveyList "+surveyList.size());
        Survey survey = new Survey();
        Field field = survey.getClass().getDeclaredField(request.getFieldName());
        field.setAccessible(true);
        System.out.println("Field "+field.getName());
        for (Survey elem:surveyList) {
            returnArray.add(field.get(elem).toString());
        }
        ResultList resultList = new ResultList();
        resultList.setItem(returnArray);
        response.setResultList(resultList);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllQuestionRequest")
    @ResponsePayload
    public GetAllQuestionResponse getAllQuestionResponse(@RequestPayload GetAllQuestionRequest request) {
        GetAllQuestionResponse response = new GetAllQuestionResponse();
        System.out.println("getAllQuestionResponse ");
        List<soap.entity.Question> questions = questionRepository.findAll();
        System.out.println("questions "+questions.size());
        QuestionList returnArray = new QuestionList();
        List<localhost._8080.soapservice.Question> surveyList = new ArrayList<>();
        localhost._8080.soapservice.Question question;
        for (soap.entity.Question elem:questions) {
            question = new localhost._8080.soapservice.Question();
            question.setId(elem.getId());
            question.setText(elem.getText());
            surveyList.add(question);
        }
        returnArray.setQuestion(surveyList);
        response.setQuestionList(returnArray);
        return response;
    }

}