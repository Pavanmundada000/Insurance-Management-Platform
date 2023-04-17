package com.insurance.management.platform.service.impl;

import com.insurance.management.platform.entity.Client;
import com.insurance.management.platform.entity.InsurancePolicy;
import com.insurance.management.platform.repository.ClientRepository;
import com.insurance.management.platform.repository.InsurancePolicyRepository;
import com.insurance.management.platform.service.ClientService;
import com.insurance.management.platform.service.InsurancePolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsurancePolicyServiceImpl implements InsurancePolicyService {

    @Autowired
    private InsurancePolicyRepository insurancePolicyRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public InsurancePolicy createPolicy(InsurancePolicy insurancePolicy,long clientId) {
        var client = clientRepository.findById(clientId).orElseThrow(()-> new RuntimeException("Client Not Found With Id "+clientId));
        insurancePolicy.setClient(client);
        return insurancePolicyRepository.save(insurancePolicy);
    }

    @Override
    public InsurancePolicy getPolicyById(long policyId) {
        return this.insurancePolicyRepository.findById(policyId).orElseThrow(()->new RuntimeException("Policy Not Found With Id "+policyId));
    }

    @Override
    public InsurancePolicy getPolicyByPolicyNumber(String policyNumber) {
        return this.insurancePolicyRepository.findByPolicyNumber(policyNumber).orElseThrow(()->new RuntimeException("Policy Not Found With Policy Number "+policyNumber));
    }

    @Override
    public List<InsurancePolicy> getAllPolicies() {
        var allPolicies = insurancePolicyRepository.findAll();
        return allPolicies.stream().toList();
    }

    @Override
    public InsurancePolicy updatePolicyById(InsurancePolicy insurancePolicy, long policyId, long clientId) {
        var existingInsurancePolicy = insurancePolicyRepository.findById(policyId).orElseThrow(() -> new RuntimeException("Policy Not Found With Id " + policyId));

        existingInsurancePolicy.setPolicyNumber(insurancePolicy.getPolicyNumber());
        existingInsurancePolicy.setType(insurancePolicy.getType());
        existingInsurancePolicy.setCoverageAmount(insurancePolicy.getCoverageAmount());
        existingInsurancePolicy.setPremium(insurancePolicy.getPremium());
        existingInsurancePolicy.setStartDate(insurancePolicy.getStartDate());
        existingInsurancePolicy.setEndDate(insurancePolicy.getEndDate());

        var existingClient = clientRepository.findById(clientId).orElseThrow(()->new RuntimeException("Client Not Found With Id "+clientId));

        existingClient.setName(insurancePolicy.getClient().getName());
        existingClient.setDateOfBirth(insurancePolicy.getClient().getDateOfBirth());
        existingClient.setAddress(insurancePolicy.getClient().getAddress());
        existingClient.setPhone(insurancePolicy.getClient().getPhone());

        existingInsurancePolicy.setClient(existingClient);

        return this.insurancePolicyRepository.save(existingInsurancePolicy);
    }

    @Override
    public void deletePolicyById(long policyId) {
        var insurancePolicy = this.insurancePolicyRepository.findById(policyId).orElseThrow(() -> new RuntimeException("Policy Not Found With Id " + policyId));
        insurancePolicyRepository.delete(insurancePolicy);
    }
}
