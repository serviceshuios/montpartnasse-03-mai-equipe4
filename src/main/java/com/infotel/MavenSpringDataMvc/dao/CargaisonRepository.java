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
	@Query("UPDATE Cargaison SET nomCargaison = :x ,depart = :y ,destination = :z  where idCargaison= :c ")
	public int modifierCargaison(@Param("x")String nomCargaison, @Param("y")String depart, @Param("z")String destination , @Param("c")int idCargaison);
	
	@Modifying
	@Query("UPDATE Cargaison SET societeTransport = :x WHERE idSociete = :y")
	public void lierCargaisonSocieteTransport(@Param("x")Cargaison cargaison, @Param("y")int idSociete);

}
