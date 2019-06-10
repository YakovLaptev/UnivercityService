package soap;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "survey")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema specialtySchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("SpecialtyPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://localhost:8080/soapservice");
        wsdl11Definition.setSchema(specialtySchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema specialtySchema() {
        return new SimpleXsdSchema(new ClassPathResource("survey.xsd"));
    }

    @Bean
    public SurveyClient surveyClient() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        String[] packagesToScan= {"localhost._8080"};
        marshaller.setPackagesToScan(packagesToScan);
        SurveyClient client = new SurveyClient();
        client.setDefaultUri("http://localhost:8080/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
//    @Bean
//    public SpecialtiesClient specialtiesClient() {
//        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
//        String[] packagesToScan= {"localhost._8080"};
//        marshaller.setPackagesToScan(packagesToScan);
//        SpecialtiesClient client = new SpecialtiesClient();
//        client.setDefaultUri("http://localhost:8080/ws");
//        client.setMarshaller(marshaller);
//        client.setUnmarshaller(marshaller);
//        return client;
//    }
    /*@Bean(name="simpleMappingExceptionResolver")
    public SimpleMappingExceptionResolver createSimpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver r = new SimpleMappingExceptionResolver();
        Properties mappings = new Properties();
        mappings.setProperty("DatabaseException", "databaseError");
        mappings.put("com.sun.xml.wss.impl.WssSoapFaultException", "Некорректный запрос");
        r.setExceptionMappings(mappings);
        r.setExceptionAttribute("ex");
        return r;
    }*/

}