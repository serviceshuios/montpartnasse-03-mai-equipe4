package com.infotel.MavenSpringDataMvc.service;

import java.util.Date;
import java.util.Optional;

import com.infotel.MavenSpringDataMvc.metier.Cargaison;
import com.infotel.MavenSpringDataMvc.metier.SocieteTransport;

public interface Iservice {

	public SocieteTransport ajouterSocieteTransport(SocieteTransport st);
	public Optional<SocieteTransport> getSocieteTransport(int idSociete);
	public SocieteTransport affichageSocieteTransport(int idSociete);
	public int modifierSocieteTransport(String nomSociete, String numSiret, Date dateCreation, int idSociete);
	public void supprimerSocieteTransport(int idSociete);
	public Iterable<SocieteTransport> listerSocieteTransport();
	
	public Cargaison ajouterCargaison(Cargaison c);
	public Optional<Cargaison> getCargaison(int idCargaison);
	public Cargaison affichageCargaison(int idCargaison);
	public int modifierCargaison(String nomCargaison, String depart, String destination, int idCargaison);
	public void supprimerCargaison(int idCargaison);
	public Iterable<Cargaison> listerCargaison();
	
	
	public void lierCargaisonSocieteTransport(Cargaison cargaison, int idSociete);
}
