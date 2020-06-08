package com.homieroof.HomieRoof.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.homieroof.HomieRoof.model.Traveller;
import com.homieroof.HomieRoof.repository.TravellerRepository;

@Service
public class TravellerServices {
	
	@Autowired
	private TravellerRepository travellerRepo;
	
	@GetMapping
	public List<Traveller> findAllTravellers() {
		return travellerRepo.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody Traveller traveller) {
		travellerRepo.save(traveller);
	}
	
	@GetMapping("/{id}")
	public Traveller getTravellersById(@PathVariable("id") long id) {
		return travellerRepo.findById(id).get();
	}

}
