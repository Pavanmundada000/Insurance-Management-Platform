package com.insurance.management.platform.controller;

import com.insurance.management.platform.entity.Claim;
import com.insurance.management.platform.helper.ApiResponse;
import com.insurance.management.platform.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    // create claim
    @PostMapping("/policy/{policyId}/claims")
    public ResponseEntity<Claim> createClaim(@RequestBody Claim claim, @PathVariable long policyId){
        return ResponseEntity.status(HttpStatus.CREATED).body(claimService.createClaim(claim,policyId));
    }

    // get single claim by id
    @GetMapping("/claims/{claimId}")
    public ResponseEntity<Claim> getClaimById(@PathVariable long claimId){
        return ResponseEntity.status(200).body(claimService.getClaimById(claimId));
    }

    // get claim by claim number
    @GetMapping("/claims/number/{claimNumber}")
    public ResponseEntity<Claim> getClaimByClaimNumber(@PathVariable String claimNumber){
        return ResponseEntity.ok(claimService.getClaimByClaimNumber(claimNumber));
    }

    // get all claims
    @GetMapping("/claims")
    public ResponseEntity<List<Claim>> getAllClaims(){
        return ResponseEntity.status(200).body(claimService.getAllClaims());
    }

    // update claim by id
    @PutMapping("/claims/{claimId}")
    public ResponseEntity<Claim> updateClaimById(@RequestBody Claim claim, @PathVariable long claimId){
        return ResponseEntity.status(200).body(claimService.updateClaimById(claim, claimId));
    }

    // delete claim by id
    @DeleteMapping("/{claimId}")
    public ResponseEntity<ApiResponse> deleteClaimById(@PathVariable long claimId){
        claimService.deleteClaimById(claimId);
        return ResponseEntity.ok(new ApiResponse("Claim Deleted Successfully!!",true));
    }

}
