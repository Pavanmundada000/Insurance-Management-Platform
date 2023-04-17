package com.insurance.management.platform.controller;

import com.insurance.management.platform.entity.InsurancePolicy;
import com.insurance.management.platform.helper.ApiResponse;
import com.insurance.management.platform.service.InsurancePolicyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class InsurancePolicyController {

    @Autowired
    private InsurancePolicyService insurancePolicyService;

    // create new policy
    @PostMapping("/client/{clientId}/policies")
    public ResponseEntity<InsurancePolicy> createInsurancePolicy(@Valid @RequestBody InsurancePolicy insurancePolicy,@PathVariable long clientId){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.insurancePolicyService.createPolicy(insurancePolicy,clientId));
    }

    // get insurance policy by id
    @GetMapping("/policies/{policyId}")
    public ResponseEntity<InsurancePolicy> getInsurancePolicyById(@PathVariable long policyId){
        return ResponseEntity.status(200).body(this.insurancePolicyService.getPolicyById(policyId));
    }

    // get insurance policy by policy number
    @GetMapping("/policies/{policyNumber}")
    public ResponseEntity<InsurancePolicy> getInsurancePolicyByPolicyNumber(@PathVariable String policyNumber){
        return ResponseEntity.status(200).body(this.insurancePolicyService.getPolicyByPolicyNumber(policyNumber));
    }

    // get insurance policies
    @GetMapping("/policies")
    public ResponseEntity<List<InsurancePolicy>> getAllInsurancePolicies(){
        return ResponseEntity.status(200).body(this.insurancePolicyService.getAllPolicies());
    }

    //update insurance policy by id
    @PutMapping("/client/{clientId}/policies/{policyId}")
    public ResponseEntity<InsurancePolicy> updateInsurancePolicyById(@Valid @RequestBody InsurancePolicy insurancePolicy, @PathVariable long policyId, @PathVariable long clientId){
        return ResponseEntity.status(200).body(this.insurancePolicyService.updatePolicyById(insurancePolicy,policyId,clientId));
    }

    // delete insurance policy by id
    @DeleteMapping("/policies/{policyId}")
    public ResponseEntity<ApiResponse> deleteInsurancePolicyById(@PathVariable long policyId){
        this.insurancePolicyService.deletePolicyById(policyId);
        return ResponseEntity.status(200).body(new ApiResponse("Insurance Policy Deleted Successfully!!",true));
    }


}
