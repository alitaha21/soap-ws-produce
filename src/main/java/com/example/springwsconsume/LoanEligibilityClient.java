package com.example.springwsconsume;

import com.example.springwsconsume.wsdl.Acknowledgement;
import com.example.springwsconsume.wsdl.CustomerRequest;
import org.springframework.ws.client.core.WebServiceTemplate;

public class LoanEligibilityClient {

    private final WebServiceTemplate template;

    public LoanEligibilityClient(WebServiceTemplate template) {
        this.template = template;
    }

    public Acknowledgement checkLoanEligibility(CustomerRequest request) {
        String serviceUri = "http://localhost:8080/ws";
        return (Acknowledgement) template.marshalSendAndReceive(serviceUri, request);
    }
}
