package com.example.springws.endpoint;

import com.example.spring.ws.Acknowledgement;
import com.example.spring.ws.CustomerRequest;
import com.example.springws.service.LoanEligibility;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class LoanEligibilityIndicatorEndpoint {

    public static final String NAMESPACE = "http://www.example.com/spring/ws";
    private final LoanEligibility loanEligibility;

    public LoanEligibilityIndicatorEndpoint(LoanEligibility loanEligibility) {
        this.loanEligibility = loanEligibility;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "CustomerRequest")
    @ResponsePayload
    public Acknowledgement getLoanStatus(@RequestPayload CustomerRequest request) {
        return loanEligibility.checkEligibility(request);
    }
}
