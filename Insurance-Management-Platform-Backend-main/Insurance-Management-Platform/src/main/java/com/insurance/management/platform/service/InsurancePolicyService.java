package com.insurance.management.platform.service;

import com.insurance.management.platform.entity.InsurancePolicy;
import java.util.List;

public interface InsurancePolicyService {

    // create new policy
    InsurancePolicy createPolicy(InsurancePolicy insurancePolicy, long clientId);

    // get policy by id
    InsurancePolicy getPolicyById(long policyId);

    // get policy by policyNumber
    InsurancePolicy getPolicyByPolicyNumber(String policyNumber);

    // get all policies
    List<InsurancePolicy> getAllPolicies();

    // update policy by id
    InsurancePolicy updatePolicyById(InsurancePolicy insurancePolicy, long policyId, long clientID);

    // delete policy by policy id
    void deletePolicyById(long policyId);
}
