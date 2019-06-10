package soap;

import localhost._8080.soapservice.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class SurveyClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(Survey.class);

    public GetSurveyByCodeResponse getSurveyByCodeResponse(String code) {
        GetSurveyByCodeRequest request = new GetSurveyByCodeRequest();
        request.setCode(code);
        log.info("Requesting survey for " + code);
        return (GetSurveyByCodeResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8080/ws/", request, new SoapActionCallback("getSurveyByCodeResponse"));
    }

    public GetAnswersByCurseResponse getAnswersByCurseResponse(int curse) {
        GetAnswersByCurseRequest request = new GetAnswersByCurseRequest();
        request.setCurse(curse);
        log.info("Requesting answers for " + curse);
        return (GetAnswersByCurseResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8080/ws/", request, new SoapActionCallback("getAnswersByCurseResponse"));
    }

}