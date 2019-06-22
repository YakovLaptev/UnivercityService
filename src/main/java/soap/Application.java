package soap;

import localhost._8080.soapservice.GetAllResponse;
import localhost._8080.soapservice.Survey;
import localhost._8080.soapservice.SurveyList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        //SpringApplication.run(Application.class, args);
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        SurveyClient surveyClient = ctx.getBean(SurveyClient.class);

        GetAllResponse response = surveyClient.getAllResponse("specialty");
        System.out.println("Result: "+response.getResultList().getValue());


        //SpecialtiesClient specialtiesClient = ctx.getBean(SpecialtiesClient.class);
        //String code = "09.03.04";
        //GetSpecialtyResponse response = specialtiesClient.getSpecialtyByCode(code);
        //System.out.println("Code: "+response.getSpecialty().getCode()+" "+"Name: "+response.getSpecialty().getName()+" "+"Type: "+response.getSpecialty().getType()+" ");

//        String code = "27.03.04";
//        GetSurveyByCodeResponse response = surveyClient.getSurveyByCodeResponse(code);
//        System.out.println("GetSurveyByCode: \n");
//        print(response.getSurveyList());
//        int curse = 4;
//        GetAnswersByCurseResponse response2 = surveyClient.getAnswersByCurseResponse(curse);
//        System.out.println("GetAnswersByCurse: \n");
//        print(response2.getSurveyList());
    }

    private static void print(SurveyList surveyList) {
        for (Survey survey: surveyList.getValue()) {
            System.out.println("Id: " + survey.getId() + " " +
                    "Institute: " + survey.getInstitute() + " " +
                    "Department: " + survey.getDepartment() + " " +
                    "SpecialtyCode: " + survey.getSpecialtyCode() + " " +
                    "Specialty: " + survey.getSpecialty() + " " +
                    "Curse: " + survey.getCurse() + " " +
                    "StudyForm: " + survey.getStudyForm() + " " +
                    "Answer1: " + survey.getAnswer1() + " " +
                    "Answer2: " + survey.getAnswer2() + "\n");
        }
    }

}