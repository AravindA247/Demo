package com.example.Ins.mgmnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Ins.mgmnt.entities.InsurancePolicy;

public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy, Integer> {

}
