package com.homieroof.HomieRoof.controllers;

import java.util.List;	

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.homieroof.HomieRoof.model.Traveller;
import com.homieroof.HomieRoof.services.TravellerServices;

@RestController
@RequestMapping("/api/v1/travellers")
public class TravellerController {
	
	@Autowired
	private TravellerServices travellerServices;

	@GetMapping
	public List<Traveller> list(){
		return travellerServices.findAllTravellers();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody Traveller traveller) {
		travellerServices.create(traveller);
	}
	
	@GetMapping("/{id}")
	public Traveller get(@PathVariable("id") long id) {
		return travellerServices.getTravellersById(id);
	}
}
