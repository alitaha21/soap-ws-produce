package com.example.springwsconsume;

import com.example.springwsconsume.wsdl.Acknowledgement;
import com.example.springwsconsume.wsdl.CustomerRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class CustomerController {

    private final LoanEligibilityClient client;
    private final static Logger logger = LoggerFactory.getLogger(CustomerController.class);

    public CustomerController(LoanEligibilityClient client) {
        this.client = client;
    }

    @PostMapping("send")
    public ResponseEntity<Acknowledgement> response(@RequestBody CustomerRequest request) {

        Acknowledgement acknowledgement = client.checkLoanEligibility(request);

        logger.info(String.format("Is eligible: %s", acknowledgement.isIsEligible()));
        logger.info(String.format("Approved amount: %s", acknowledgement.getApproveAmount()));
        logger.info(String.format("Criteria mismatch: %s", acknowledgement.getCriteriaMismatch()));

        return new ResponseEntity<>(acknowledgement, HttpStatus.OK);
    }

}
