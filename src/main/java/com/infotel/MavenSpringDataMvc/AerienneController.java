package com.infotel.MavenSpringDataMvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.infotel.MavenSpringDataMvc.metier.Aerienne;
import com.infotel.MavenSpringDataMvc.service.Iservice;


@Controller
public class AerienneController {

	@Autowired
    private Iservice service;
	
	@RequestMapping(value = "/indexAerienne", method = RequestMethod.GET)
    public String lister(Model model) {
        model.addAttribute("aerienne", new Aerienne());
        model.addAttribute("aeriennes", service.listerAerienne());
        model.addAttribute("societeTransports", service.listerSocieteTransport());
        return "aeriennes";
    }
	
	 @RequestMapping(value = "/saveAerienne")
	    public String save(Aerienne aerienne,  Model model) {
	        if (aerienne.getIdCargaison() == 0) {
	           
	        	service.ajouterAerienne(aerienne);
	            model.addAttribute("aerienne", new Aerienne());
	            model.addAttribute("aeriennes", service.listerAerienne());
	            model.addAttribute("societeTransports", service.listerSocieteTransport());
	            return "aeriennes";
	            
	        } else {
	        	
	        	String nomCargaison = aerienne.getNomCargaison();
	            String depart = aerienne.getDepart();
	            String destination = aerienne.getDestination();
	            String numVol= aerienne.getNumVol();
	            double taxe = aerienne.getTaxe();
	            int idCargaison= aerienne.getIdCargaison();
	            
	        	service.modifierAerienne (nomCargaison, depart, destination,numVol,taxe, idCargaison);
	            model.addAttribute("aerienne", new Aerienne());
	            model.addAttribute("aeriennes", service.listerAerienne());
	            model.addAttribute("societeTransports", service.listerSocieteTransport());
	            return "aeriennes";
	        }
	   }
	 
	 @RequestMapping(value = "/deleteAerienne")
     public String delete(@RequestParam int idCargaison, Model model) {
         service.supprimerCargaison(idCargaison);
         model.addAttribute("aerienne", new Aerienne());
         model.addAttribute("aeriennes", service.listerAerienne());
         model.addAttribute("societeTransports", service.listerSocieteTransport());
         return "aeriennes";
     }
	 
	 @RequestMapping(value = "/editAerienne")
     public String edit(@RequestParam int idCargaison, Model model) {
         model.addAttribute("aerienne", service.getCargaison(idCargaison));
         model.addAttribute("aeriennes", service.listerAerienne());
         model.addAttribute("societeTransports", service.listerSocieteTransport());
         return "aeriennes";
     }
}
