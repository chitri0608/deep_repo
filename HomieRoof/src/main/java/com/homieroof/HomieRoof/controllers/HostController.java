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

import com.homieroof.HomieRoof.model.Host;
import com.homieroof.HomieRoof.services.HostServices;


@RestController
@RequestMapping("/api/v1/host")
public class HostController {
	
	@Autowired	
	private HostServices hostService;

	@GetMapping
	public List<Host> list(){
		return hostService.findAllHosts();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody Host host) {
		hostService.create(host);
	}
	
	@GetMapping("/{hostId}")
	public Host get(@PathVariable("hostId") long hostId) {
		return hostService.getHostsById(hostId);
	}
	
	@GetMapping("address/{hostAddress}")
	public List<Host> get(@PathVariable("hostAddress") String hostAddress) {
		return hostService.getByHostAddress(hostAddress);
	}	
}
