package com.insurance.management.platform.service;

import com.insurance.management.platform.entity.Claim;
import java.util.List;

public interface ClaimService {

    // create new claim
    Claim createClaim(Claim claim,long policyId);

    // get claim by claim id
    Claim getClaimById(long id);

    // get claim by claim number
    Claim getClaimByClaimNumber(String claimNumber);

    // get all claims
    List<Claim> getAllClaims();

    // update claim by id
    Claim updateClaimById(Claim claim, long claimId);

    // delete claim by id
    void deleteClaimById(long claimId);

}
