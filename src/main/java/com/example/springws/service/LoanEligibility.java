package com.example.springws.service;

import com.example.spring.ws.Acknowledgement;
import com.example.spring.ws.CustomerRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanEligibility {

    public Acknowledgement checkEligibility(CustomerRequest request) {
        Acknowledgement acknowledgement = new Acknowledgement();
        List<String> mismatchList = acknowledgement.getCriteriaMismatch();

        if (!(request.getAge() > 30 && request.getAge() <=60)) {
            mismatchList.add("Person age should be between 30 to 60");
        }

        if (!(request.getYearlyIncome()>200000)) {
            mismatchList.add("Minimum yearly income should be more than 200000");
        }

        if (!(request.getCibilScore() > 500)) {
            mismatchList.add("Low CIBIL score please try after 6 months");
        }

        if (!mismatchList.isEmpty()) {
            acknowledgement.setApproveAmount(0);
            acknowledgement.setIsEligible(false);
        } else {
            acknowledgement.setApproveAmount(500000);
            acknowledgement.setIsEligible(true);
            mismatchList.clear();
        }

        return acknowledgement;
    }

}
