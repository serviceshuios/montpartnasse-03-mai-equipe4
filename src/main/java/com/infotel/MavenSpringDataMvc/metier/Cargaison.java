package com.infotel.MavenSpringDataMvc.metier;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Johan 
 * Paramètres de la classe  Cargaison
 *Getter and Setter,  Constructeur toString()
 *
 */
@Entity
@Component
@Scope(value = "prototype")

@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_CARG")
@DiscriminatorValue ("CARG")


public abstract class Cargaison {
	
	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)

	private int idCargaison;
	protected String nomCargaison;
	protected String depart;
	protected String destination;
	
@ManyToOne
private SocieteTransport societetransport;

public int getIdCargaison() {
	return idCargaison;
}

public void setIdCargaison(int idCargaison) {
	this.idCargaison = idCargaison;
}

public String getNomCargaison() {
	return nomCargaison;
}

public void setNomCargaison(String NomCargaison) {
	this.nomCargaison = NomCargaison;
}

public String getDepart() {
	return depart;
}

public void setDepart(String depart) {
	this.depart = depart;
}

public String getDestination() {
	return destination;
}

public void setDestination(String destination) {
	this.destination = destination;
}

public SocieteTransport getSocietetransport() {
	return societetransport;
}

public void setSocietetransport(SocieteTransport societetransport) {
	this.societetransport = societetransport;
}

@Override
public String toString() {
	return "Cargaison [idCargaison=" + idCargaison + ", nomCargaison=" + nomCargaison + ", depart=" + depart
			+ ", destination=" + destination + ", societetransport=" + societetransport + "]";
}

	
}
