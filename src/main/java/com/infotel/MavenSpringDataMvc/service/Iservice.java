package com.infotel.MavenSpringDataMvc.service;

import java.util.Date;
import java.util.Optional;

import com.infotel.MavenSpringDataMvc.metier.Aerienne;
import com.infotel.MavenSpringDataMvc.metier.Cargaison;
import com.infotel.MavenSpringDataMvc.metier.Routiere;
import com.infotel.MavenSpringDataMvc.metier.SocieteTransport;

/**
 * Interface regroupant les différentes méthodes invoquées
 * @author Raphaël
 *
 */

public interface Iservice {

	/**
	 * 
	 * Liste des méthodes CRUD utilisées pour la classe SocieteTransport
	 */
	public SocieteTransport ajouterSocieteTransport(SocieteTransport st);
	public SocieteTransport getSocieteTransport(int idSociete);
	public SocieteTransport affichageSocieteTransport(int idSociete);
	public int modifierSocieteTransport(String nomSociete, String numSiret, Date dateCreation, int idSociete);
	public void supprimerSocieteTransport(int idSociete);
	public Iterable<SocieteTransport> listerSocieteTransport();
	
	/**
	 * 
	 * Liste des méthodes CRUD utilisées pour la classe mère Cargaison et ses classes filles
	 */
	public Cargaison ajouterRoutiere(Routiere r);
	public Cargaison ajouterAerienne(Aerienne a);
	public Cargaison getCargaison(int idCargaison);
	public Cargaison affichageCargaison(int idCargaison);
	public int modifierAerienne(String nomCargaison, String depart, String destination,String numVol, double taxe, int idCargaison);
	public int modifierRoutiere(String nomCargaison, String depart, String destination,String immatriculation, double peage, int idCargaison);
	public void supprimerCargaison(int idCargaison);
	public Iterable<Aerienne> listerAerienne();
	public Iterable<Routiere> listerRoutiere();
	
	/**
	 * 
	 * Liste des méthodes utilisées pour lier un element de la classe Cargaison avec un elements de la classe Societe
	 */
	
	public void lierRoutiereSociete(int idSociete, int idCargaison);
	public void lierAerienneSociete(int idSociete, int idCargaison);
	
}
