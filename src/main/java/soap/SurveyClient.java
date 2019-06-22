package soap;

import localhost._8080.soapservice.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class SurveyClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(Survey.class);

    public GetAnswersByCurseResponse getAnswersByCurseResponse(int curse) {
        GetAnswersByCurseRequest request = new GetAnswersByCurseRequest();
        request.setCurse(curse);
        log.info("getAnswersByCurseResponse " + curse);
        return (GetAnswersByCurseResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8080/ws/", request, new SoapActionCallback("getAnswersByCurseResponse"));
    }

    public GetAnswersByCodeResponse getAnswersByCodeResponse(String code) {
        GetAnswersByCodeRequest request = new GetAnswersByCodeRequest();
        request.setCode(code);
        log.info("getAnswersByCodeResponse " + code);
        return (GetAnswersByCodeResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8080/ws/", request, new SoapActionCallback("getAnswersByCodeResponse"));
    }


    public GetAnswersByDepartmentResponse getAnswersByDepartmentResponse(String department) {
        GetAnswersByDepartmentRequest request = new GetAnswersByDepartmentRequest();
        request.setDepartment(department);
        log.info("getAnswersByDepartmentResponse " + department);
        return (GetAnswersByDepartmentResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8080/ws/", request, new SoapActionCallback("getAnswersByDepartmentResponse"));
    }

    public GetAnswersByInstituteResponse getAnswersByInstituteResponse(String institute) {
        GetAnswersByInstituteRequest request = new GetAnswersByInstituteRequest();
        request.setInstitute(institute);
        log.info("getAnswersByInstituteResponse " + institute);
        return (GetAnswersByInstituteResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8080/ws/", request, new SoapActionCallback("getAnswersByInstituteResponse"));
    }

    public GetAnswersBySpecialtyResponse getAnswersBySpecialtyResponse(String specialty) {
        GetAnswersBySpecialtyRequest request = new GetAnswersBySpecialtyRequest();
        request.setSpecialty(specialty);
        log.info("getAnswersBySpecialtyResponse " + specialty);
        return (GetAnswersBySpecialtyResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8080/ws/", request, new SoapActionCallback("getAnswersBySpecialtyResponse"));
    }

    public GetAllResponse getAllResponse(String name) {
        GetAllRequest request = new GetAllRequest();
        request.setFieldName(name);
        log.info("getAllResponse " + name);
        return (GetAllResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8080/ws/", request, new SoapActionCallback("getAllResponse"));
    }

}