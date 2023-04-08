package com.example.Ins.mgmnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Ins.mgmnt.entities.Client;

public interface ClientRepository extends JpaRepository<Client,Integer>{

}
