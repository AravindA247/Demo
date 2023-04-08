package com.example.Ins.mgmnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Ins.mgmnt.entities.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Integer>{

}
