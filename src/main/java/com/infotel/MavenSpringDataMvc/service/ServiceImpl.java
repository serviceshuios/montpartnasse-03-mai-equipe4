package com.infotel.MavenSpringDataMvc.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotel.MavenSpringDataMvc.dao.AerienneRepository;
import com.infotel.MavenSpringDataMvc.dao.CargaisonRepository;
import com.infotel.MavenSpringDataMvc.dao.RoutiereRepository;
import com.infotel.MavenSpringDataMvc.dao.SocieteTransportRepository;
import com.infotel.MavenSpringDataMvc.metier.Aerienne;
import com.infotel.MavenSpringDataMvc.metier.Cargaison;
import com.infotel.MavenSpringDataMvc.metier.Routiere;
import com.infotel.MavenSpringDataMvc.metier.SocieteTransport;

@Service("service")
public class ServiceImpl implements Iservice {
	
	@Autowired
	private SocieteTransportRepository societeTransportRepository;
	
	@Autowired
	private CargaisonRepository cargaisonRepository;
	
	@Autowired
	private AerienneRepository aerienneRepository;
	
	@Autowired
	private RoutiereRepository routiereRepository;
	
	
	
	// Getter and Setter
	
	public RoutiereRepository getRoutiereRepository() {
		return routiereRepository;
	}

	public void setRoutiereRepository(RoutiereRepository routiereRepository) {
		this.routiereRepository = routiereRepository;
	}

	public AerienneRepository getAerienneRepository() {
		return aerienneRepository;
	}

	public void setAerienneRepository(AerienneRepository aerienneRepository) {
		this.aerienneRepository = aerienneRepository;
	}

	public SocieteTransportRepository getSocieteTransportRepository() {
		return societeTransportRepository;
	}

	public void setSocieteTransportRepository(SocieteTransportRepository societeTransportRepository) {
		this.societeTransportRepository = societeTransportRepository;
	}

	public CargaisonRepository getCargaisonRepository() {
		return cargaisonRepository;
	}

	public void setCargaisonRepository(CargaisonRepository cargaisonRepository) {
		this.cargaisonRepository = cargaisonRepository;
	}

	
	
	// Méthode CRUD SociétéTransport
	
	

	@Override
	public SocieteTransport ajouterSocieteTransport(SocieteTransport st) {
		// TODO Auto-generated method stub
		return societeTransportRepository.save(st);
	}

	@Override
	public SocieteTransport getSocieteTransport(int idSociete) {
		// TODO Auto-generated method stub
		return societeTransportRepository.findById(idSociete).get();
	}

	@Override
	public SocieteTransport affichageSocieteTransport(int idSociete) {
		// TODO Auto-generated method stub
		return societeTransportRepository.getOne(idSociete);
	}

	@Override
	public int modifierSocieteTransport(String nomSociete, String numSiret, Date dateCreation, int idSociete) {
		// TODO Auto-generated method stub
		return societeTransportRepository.modifierSocieteTransport(nomSociete, numSiret, dateCreation, idSociete);
	}

	@Override
	public void supprimerSocieteTransport(int idSociete) {
		// TODO Auto-generated method stub
		societeTransportRepository.deleteById(idSociete);
	}

	@Override
	public Iterable<SocieteTransport> listerSocieteTransport() {
		// TODO Auto-generated method stub
		return societeTransportRepository.findAll();
	}

	
	// Méthode CRUD Cargaison
	
	@Override
	public Cargaison ajouterRoutiere(Routiere r) {
		// TODO Auto-generated method stub
		return cargaisonRepository.save(r);
	}
	
	@Override
	public Cargaison ajouterAerienne(Aerienne a) {
		// TODO Auto-generated method stub
		return cargaisonRepository.save(a);
	}

	@Override
	public Cargaison getCargaison(int idCargaison) {
		// TODO Auto-generated method stub
		return cargaisonRepository.findById(idCargaison).get();
	}

	@Override
	public Cargaison affichageCargaison(int idCargaison) {
		// TODO Auto-generated method stub
		return cargaisonRepository.getOne(idCargaison);
	}

	@Override
	public int modifierAerienne(String nomCargaison, String depart, String destination, String numVol, double taxe,
			int idCargaison) {
		// TODO Auto-generated method stub
		return cargaisonRepository.modifierAerienne(nomCargaison, depart, destination, numVol, taxe, idCargaison);
	}

	@Override
	public int modifierRoutiere(String nomCargaison, String depart, String destination, String immatriculation,
			double peage, int idCargaison) {
		// TODO Auto-generated method stub
		return cargaisonRepository.modifierRoutiere(nomCargaison, depart, destination, immatriculation, peage, idCargaison);
	}

	@Override
	public void supprimerCargaison(int idCargaison) {
		// TODO Auto-generated method stub
		cargaisonRepository.deleteById(idCargaison);
	}

	
	// Méthode pour lier la ForeignKey
	
	@Override
	public void lierCargaisonSocieteTransport(Cargaison cargaison, int idSociete) {
		// TODO Auto-generated method stub
		cargaisonRepository.lierCargaisonSocieteTransport(cargaison, idSociete);
	}

	@Override
	public Iterable<Aerienne> listerAerienne() {
		// TODO Auto-generated method stub
		return aerienneRepository.findAll();
	}

	@Override
	public Iterable<Routiere> listerRoutiere() {
		// TODO Auto-generated method stub
		return routiereRepository.findAll();
	}

	
}
