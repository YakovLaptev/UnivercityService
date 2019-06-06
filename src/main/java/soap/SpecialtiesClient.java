package soap;

import localhost._8080.soapservice.GetSpecialtyRequest;
import localhost._8080.soapservice.GetSpecialtyResponse;
import localhost._8080.soapservice.Specialty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class SpecialtiesClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(Specialty.class);

    public GetSpecialtyResponse getSpecialtyByCode(String specialtyCode) {

        GetSpecialtyRequest request = new GetSpecialtyRequest();
        request.setCode(specialtyCode);

        log.info("Requesting location for " + specialtyCode);

        GetSpecialtyResponse response = (GetSpecialtyResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/", request,
                        new SoapActionCallback("getSpecialtyRequest"));

        return response;
    }

}