package com.example.springwsconsume;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

@Configuration
public class ConsumeConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.example.springwsconsume.wsdl");
        return marshaller;
    }

    @Bean
    public WebServiceTemplate template(Jaxb2Marshaller marshaller) {
        WebServiceTemplate template = new WebServiceTemplate();
        template.setMarshaller(marshaller);
        template.setUnmarshaller(marshaller);
        template.setDefaultUri("http://localhost:8080/ws/loanEligibilityWsdlDefinition.wsdl");
        return template;
    }

    @Bean
    public LoanEligibilityClient client(WebServiceTemplate template) {
        return new LoanEligibilityClient(template);
    }

}
