package com.infotel.MavenSpringDataMvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.MavenSpringDataMvc.metier.Cargaison;

@Transactional
public interface CargaisonRepository extends JpaRepository<Cargaison, Integer> {
	
	@Modifying
	@Query("UPDATE Cargaison SET nomCargaison = :x ,depart = :y ,destination = :z , numVol = :v , taxe = :w where idCargaison= :c ")
	public int modifierAerienne(@Param("x")String nomCargaison, @Param("y")String depart, @Param("z")String destination , 
			@Param("v")String numVol ,@Param("w") double taxe, @Param("c")int idCargaison);
	
	@Modifying
	@Query("UPDATE Cargaison SET nomCargaison = :x ,depart = :y ,destination = :z , immatriculation = :v, peage = :w where idCargaison= :c ")
	public int modifierRoutiere(@Param("x")String nomCargaison, @Param("y")String depart, @Param("z")String destination ,
			@Param("v")String immatriculation, @Param("w")double peage, @Param("c")int idCargaison);
	
}
