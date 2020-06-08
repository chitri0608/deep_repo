package com.homieroof.HomieRoof.repository;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.homieroof.HomieRoof.model.Availability;

public interface AvailabilityRepository extends JpaRepository<Availability, Long> {
	
	@Query(value="Select * from availability a where a.host_id =:host_id and ((month(a.check_in)=month(:check_in) and year(a.check_in)=year(:check_in)) or (month(a.check_out)=month(:check_out) and year(a.check_out)=year(:check_out)))",nativeQuery=true)
	@Transactional
	public List<Availability> findByHostId(@Param("host_id") String hostId, @Param("check_in") Date checkIn, @Param("check_out") Date checkOut);
	
	@Query(value="Select a.ava_id from availability a order By ava_id desc limit 1",nativeQuery=true)
	@Transactional
	public long findAvaId();

}
