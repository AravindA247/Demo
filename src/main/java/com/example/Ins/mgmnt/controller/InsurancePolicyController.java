package com.example.Ins.mgmnt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ins.mgmnt.entities.InsurancePolicy;
import com.example.Ins.mgmnt.repository.InsurancePolicyRepository;

@RestController
@RequestMapping("/api/policies")
public class InsurancePolicyController {
	
	@Autowired
	private InsurancePolicyRepository insurancePolicyRepository;
	
	@GetMapping
	public List<InsurancePolicy>getAllInsurancePolicies(){
		return
				insurancePolicyRepository.findAll();
	}
	
	@GetMapping("/{insurancePolicy_id}")
	public ResponseEntity<InsurancePolicy> getInsurancePolicyById(@PathVariable int insurancePolicy_id){
		Optional<InsurancePolicy>optionalInsurancePolicy=insurancePolicyRepository.findById(insurancePolicy_id);
		if(optionalInsurancePolicy.isPresent())
		{
			return
					ResponseEntity.ok(optionalInsurancePolicy.get());
		}else {
			return
					ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public InsurancePolicy createInsurancePolicy(@RequestBody InsurancePolicy insurancePolicy) {
		return insurancePolicyRepository.save(insurancePolicy);
	}
	
	@PutMapping("/{insurancePolicy_id}")
	public ResponseEntity<InsurancePolicy>updateInsurancePolicy(@PathVariable int insurancePolicy_id,@RequestBody InsurancePolicy insurancePolicy){
		Optional<InsurancePolicy>optionalInsurancePolicy=insurancePolicyRepository.findById(insurancePolicy_id);
		if(optionalInsurancePolicy.isPresent()) {
			insurancePolicy.setId(insurancePolicy_id);
			return
					ResponseEntity.ok(insurancePolicyRepository.save(insurancePolicy));
		}else {
			return
					ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{insurancePolicy_id}")
	public ResponseEntity<InsurancePolicy>deleteInsurancePolicy(@PathVariable int insurancePolicy_id){
		Optional<InsurancePolicy>optionalInsurancePolicy=insurancePolicyRepository.findById(insurancePolicy_id);
		if(optionalInsurancePolicy.isPresent()) {
			insurancePolicyRepository.deleteById(insurancePolicy_id);
			return
					ResponseEntity.noContent().build();
		}else {
			return
					ResponseEntity.notFound().build();
		}
	}
}
