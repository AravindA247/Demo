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

import com.example.Ins.mgmnt.entities.Claim;
import com.example.Ins.mgmnt.repository.ClaimRepository;

@RestController
@RequestMapping("/api/claim")
public class ClaimController {
	
	@Autowired
	private ClaimRepository claimRepository;
	
	@GetMapping
	public List<Claim> getAllClaims(){
		return claimRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Claim> getClaimById(@PathVariable int id){
		Optional<Claim>optionalClaim=claimRepository.findById(id);
		if(optionalClaim.isPresent())
		{
			return
					ResponseEntity.ok(optionalClaim.get());
		}else {
			return
					ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public Claim createClaim(@RequestBody Claim claim) {
		return claimRepository.save(claim);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Claim>updateClaim(@PathVariable int id, @RequestBody Claim claim){
		Optional<Claim>optionalClaim=claimRepository.findById(id);
		if(optionalClaim.isPresent()) {
			claim.setId(id);
			//claim.setClaimnumber(claimDetails.getClaimNumber());
		//	claim.setDescription(claimDetails.getDescription());
		//	claim.setClaimdate(claimDetails.getClaimdate());
		//	claim.setClaimstatus(claimDetails.getClaimStatus());
			return
					ResponseEntity.ok(claimRepository.save(claim));
		}else {
			return
					ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Claim>deleteClaim(@PathVariable int id){
		Optional<Claim>optionalClaim=claimRepository.findById(id);
		if(optionalClaim.isPresent()) {
			claimRepository.deleteById(id);
			return
					ResponseEntity.noContent().build();
		}else {
			return
					ResponseEntity.notFound().build();
		}
	}

}
