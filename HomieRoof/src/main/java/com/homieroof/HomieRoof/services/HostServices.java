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

import com.homieroof.HomieRoof.model.Host;
import com.homieroof.HomieRoof.repository.HostRepository;

@Service
public class HostServices {

	@Autowired	
	private HostRepository hostRepo;


	@GetMapping
	public List<Host> findAllHosts() {
		return hostRepo.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody Host host) {
		hostRepo.save(host);
	}
	
	@GetMapping("/{hostId}")
	public Host getHostsById(@PathVariable("hostId") long hostId) {
		return hostRepo.findById(hostId).get();
	}
	
	@GetMapping("address/{hostAddress}")
	public List<Host> getByHostAddress(@PathVariable("hostAddress") String hostAddress) {
		return hostRepo.findByHostAddress(hostAddress);
	}

	
}
