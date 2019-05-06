package com.infotel.MavenSpringDataMvc.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.MavenSpringDataMvc.metier.SocieteTransport;

@Transactional
public interface SocieteTransportRepository extends JpaRepository<SocieteTransport, Integer>{
	
	@Modifying
	@Query("UPDATE SocieteTransport SET nomSociete = :x, numSiret = :y ,dateCreation = :z  where idSociete = :c ")
	public int modifierSocieteTransport(@Param("x")String nomSociete, @Param("y")String numSiret, @Param("z")Date dateCreation , @Param("c")int idSociete);

}
