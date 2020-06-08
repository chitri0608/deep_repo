package com.homieroof.HomieRoof.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.homieroof.HomieRoof.model.Host;

public interface HostRepository extends JpaRepository<Host, Long> {
	
	@Query(value="Select * from host h where h.host_Address = :Address", nativeQuery=true)
	@Transactional
	public List<Host> findByHostAddress(@Param("Address") String address);
	
}
