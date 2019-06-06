package soap;

import localhost._8080.soapservice.GetSpecialtyRequest;
import localhost._8080.soapservice.GetSpecialtyResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        //SpringApplication.run(Application.class, args);

        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        SpecialtiesClient specialtiesClient = ctx.getBean(SpecialtiesClient.class);

        String code = "09.03.04";

        if (args.length > 0) {
            code = args[0];
        }
        GetSpecialtyResponse response = specialtiesClient.getSpecialtyByCode(code);
        System.out.println("Code: "+response.getSpecialty().getCode()+" "+"Name: "+response.getSpecialty().getName()+" "+"Type: "+response.getSpecialty().getType()+" ");
    }

}