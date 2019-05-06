package com.infotel.MavenSpringDataMvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.infotel.MavenSpringDataMvc.metier.Aerienne;

public interface AerienneRepository extends JpaRepository<Aerienne, Integer>{

	@Modifying
	@Query("UPDATE Aerienne SET aerienne = :x WHERE idSociete = :y")
	public void lierAerienneSociete(@Param("x")Aerienne aerienne, @Param("y")int idSociete);


}
