package com.homieroof.HomieRoof.repository;

import org.springframework.data.jpa.repository.JpaRepository;	
import org.springframework.stereotype.Repository;

import com.homieroof.HomieRoof.model.Traveller;

@Repository
public interface TravellerRepository extends JpaRepository<Traveller, Long> {

	
}
