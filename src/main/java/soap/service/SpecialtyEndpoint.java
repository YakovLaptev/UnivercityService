package soap.service;

import localhost._8080.soapservice.GetSpecialtyRequest;
import localhost._8080.soapservice.GetSpecialtyResponse;
import localhost._8080.soapservice.SpecialtyType;
import localhost._8080.soapservice.GetSpecialtyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import soap.entity.Specialty;
import soap.repository.SpecialtyRepository;


@Endpoint
public class SpecialtyEndpoint {
    private static final String NAMESPACE_URI = "http://localhost:8080/soapservice";

    private SpecialtyRepository specialtyRepository;

    @Autowired
    public SpecialtyEndpoint(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getSpecialtyRequest")
    @ResponsePayload
    public GetSpecialtyResponse getSpecialty(@RequestPayload GetSpecialtyRequest request) {
        GetSpecialtyResponse response = new GetSpecialtyResponse();
        System.out.println("--- "+request.getCode());
        Specialty specialty = specialtyRepository.getOne(request.getCode());
        localhost._8080.soapservice.Specialty responseSpecialty = new localhost._8080.soapservice.Specialty();
        responseSpecialty.setCode(specialty.getCode());
        responseSpecialty.setName(specialty.getName());
        responseSpecialty.setShortName(specialty.getShortName());
        responseSpecialty.setType(SpecialtyType.fromValue(specialty.getType().name()));
        response.setSpecialty(responseSpecialty);
        return response;
    }
}