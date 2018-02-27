package com.tsiry.poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tsiry.poc.DO.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
