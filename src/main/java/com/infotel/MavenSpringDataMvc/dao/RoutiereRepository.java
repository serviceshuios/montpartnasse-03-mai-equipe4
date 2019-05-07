package com.infotel.MavenSpringDataMvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.infotel.MavenSpringDataMvc.metier.Routiere;

public interface RoutiereRepository extends JpaRepository<Routiere, Integer>{

	@Modifying
	@Query("UPDATE Routiere SET idSociete = :x WHERE idCargaison = :y")
	public void lierRoutiereSociete(@Param("x")int idSociete, @Param("y")int idCargaison);
}
