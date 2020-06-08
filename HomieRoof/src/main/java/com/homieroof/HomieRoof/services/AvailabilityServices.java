package com.homieroof.HomieRoof.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.homieroof.HomieRoof.model.Availability;
import com.homieroof.HomieRoof.repository.AvailabilityRepository;

@Service
public class AvailabilityServices {
	
	@Autowired	
	private AvailabilityRepository avaRepo;
	
	@GetMapping
	public List<Availability> findAllAvalibility() {
		return avaRepo.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void createAvailability(@RequestBody Availability availability) {
		avaRepo.save(availability);
	}
	
	@GetMapping("/{avaId}")
	public Availability getAvailabilityById(@PathVariable("avaId") long avaId) {
		return avaRepo.findById(avaId).get();
	}
	
	@GetMapping("/avaId")
	public long getAvailabilityId() {
		return avaRepo.findAvaId();
	}
	
	@GetMapping("/hostId/{hostId}/{checkIn}/{checkOut}")
	public List<Availability> getAvailabilityByHostId(@PathVariable("hostId") String hostId, @PathVariable("checkIn") Date checkIn, @PathVariable("checkOut") Date checkOut){
		return avaRepo.findByHostId(hostId, checkIn, checkOut);
	}

}
