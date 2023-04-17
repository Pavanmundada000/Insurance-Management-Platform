package com.insurance.management.platform.service.impl;

import com.insurance.management.platform.entity.Claim;
import com.insurance.management.platform.entity.InsurancePolicy;
import com.insurance.management.platform.exception.ClaimNotFoundExceptionHandler;
import com.insurance.management.platform.exception.InsurancePolicyExceptionHandler;
import com.insurance.management.platform.repository.ClaimRepository;
import com.insurance.management.platform.repository.InsurancePolicyRepository;
import com.insurance.management.platform.service.ClaimService;
import com.insurance.management.platform.service.InsurancePolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaimServiceImpl implements ClaimService {

    @Autowired
    private ClaimRepository claimRepository;

    @Autowired
    private InsurancePolicyRepository insurancePolicyRepository;
    @Override
    public Claim createClaim(Claim claim,long policyId) {
        var insurancePolicy = insurancePolicyRepository.findById(policyId).orElseThrow(() -> new InsurancePolicyExceptionHandler("Insurance Policy Not Found With Id " + policyId));
        claim.setPolicy(insurancePolicy);
        return claimRepository.save(claim);
    }

    @Override
    public Claim getClaimById(long id) {
        return claimRepository.findById(id).orElseThrow(() -> new RuntimeException("Claim Not Found With Id " + id));
    }

    @Override
    public Claim getClaimByClaimNumber(String claimNumber) {
        return claimRepository.findByClaimNumber(claimNumber).orElseThrow(() -> new ClaimNotFoundExceptionHandler("Claim Not Found With Claim Number " + claimNumber));
    }

    @Override
    public List<Claim> getAllClaims() {
        return claimRepository.findAll();
    }

    @Override
    public Claim updateClaimById(Claim claim, long claimId) {

        var existingClaim = claimRepository.findById(claimId).orElseThrow(() -> new RuntimeException("Claim Not Found With Id " + claimId));
        existingClaim.setClaimNumber(claim.getClaimNumber());
        existingClaim.setPolicy(claim.getPolicy());
        existingClaim.setDescription(claim.getDescription());
        existingClaim.setClaimDate(claim.getClaimDate());
        existingClaim.setClaimStatus(claim.getClaimStatus());

        existingClaim.setPolicy(existingClaim.getPolicy());

        return claimRepository.save(existingClaim);
    }

    @Override
    public void deleteClaimById(long claimId) {
        var claim = claimRepository.findById(claimId).orElseThrow(() -> new RuntimeException("Claim Not Found With Id " + claimId));
        claimRepository.delete(claim);
    }
}
