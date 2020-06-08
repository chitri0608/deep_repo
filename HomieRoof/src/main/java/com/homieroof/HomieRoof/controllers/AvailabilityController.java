package com.homieroof.HomieRoof.controllers;

import java.sql.Date;	
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.homieroof.HomieRoof.model.Availability;
import com.homieroof.HomieRoof.model.Host;
import com.homieroof.HomieRoof.repository.AvailabilityRepository;
import com.homieroof.HomieRoof.repository.HostRepository;
import com.homieroof.HomieRoof.services.AvailabilityServices;

@RestController
@RequestMapping("/api/v1/availability")
public class AvailabilityController {
	
	@Autowired	
	private AvailabilityServices avaServices;

	@Autowired
	private HostRepository hostRepo;
	@Autowired	
	private AvailabilityRepository avaRepo;
	
	@GetMapping
	public List<Availability> list(){
		return avaServices.findAllAvalibility();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody Availability availability) {
		avaServices.createAvailability(availability);
	}
	
	@GetMapping("/{avaId}")
	public Availability get(@PathVariable("avaId") long avaId) {
		return avaServices.getAvailabilityById(avaId);
	}
	
	@GetMapping("/avaId")
	public long get() {
		return avaServices.getAvailabilityId();
	}
	
	@GetMapping("/hostId/{hostId}/{checkIn}/{checkOut}")
	public List<Availability> get(@PathVariable("hostId") String hostId, @PathVariable("checkIn") Date checkIn, @PathVariable("checkOut") Date checkOut){
		return avaServices.getAvailabilityByHostId(hostId, checkIn, checkOut);
	}
	
	@PutMapping("/update/{hid}/{aid}")
	public void updateHost(@PathVariable("hid") Long id,@PathVariable("aid") Long a_id) {
		Host h=hostRepo.getOne(id);
		Availability a=avaRepo.getOne(a_id);
		h.add(a);
		hostRepo.save(h);
	}

}
