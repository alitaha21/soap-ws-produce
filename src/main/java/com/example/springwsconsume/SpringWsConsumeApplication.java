package com.example.springwsconsume;

import com.example.springwsconsume.wsdl.LoanEligibilityIndicator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

@SpringBootApplication
public class SpringWsConsumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWsConsumeApplication.class, args);
    }

}
