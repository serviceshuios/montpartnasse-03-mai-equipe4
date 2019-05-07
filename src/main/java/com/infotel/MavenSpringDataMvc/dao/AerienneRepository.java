package com.infotel.MavenSpringDataMvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.MavenSpringDataMvc.metier.Aerienne;

@Transactional
public interface AerienneRepository extends JpaRepository<Aerienne, Integer>{

	@Modifying
	@Query("UPDATE Aerienne SET societetransport.idSociete = :x WHERE idCargaison = :y")
	public void lierAerienneSociete(@Param("x")int idSociete, @Param("y")int idCargaison);


}
