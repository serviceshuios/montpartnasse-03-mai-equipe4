package com.infotel.MavenSpringDataMvc;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.infotel.MavenSpringDataMvc.metier.SocieteTransport;
import com.infotel.MavenSpringDataMvc.service.Iservice;

@Controller
public class SocieteTransportController {

	@Autowired
    private Iservice service;
	
	
	
	@RequestMapping(value = "/indexSocieteTransport", method = RequestMethod.GET)
    public String lister(Model model) {
        model.addAttribute("societeTransport", new SocieteTransport());
        model.addAttribute("societeTransports", service.listerSocieteTransport());
        return "societeTransports";
    }
	
	 @RequestMapping(value = "/saveSocieteTransport")
	    public String save(SocieteTransport societeTransport,  Model model) {
	        if (societeTransport.getIdSociete() == 0) {
	           
	        	service.ajouterSocieteTransport(societeTransport);
	            model.addAttribute("societeTransport", new SocieteTransport());
	            model.addAttribute("societeTransports", service.listerSocieteTransport());
	            return "societeTransports";
	            
	        } else {
	        	
	        	String nomSociete = societeTransport.getNomSociete();
	            String numSiret = societeTransport.getNumSiret();
	            Date dateCreation = societeTransport.getDateCreation();
	            int idSociete= societeTransport.getIdSociete();
	            
	        	service.modifierSocieteTransport(nomSociete, numSiret, dateCreation, idSociete);
	            model.addAttribute("societeTransport", new SocieteTransport());
	            model.addAttribute("societeTransports", service.listerSocieteTransport());
	            return "societeTransports";
	        }
	   }
	 
	 @RequestMapping(value = "/deleteSocieteTransport")
     public String delete(@RequestParam int idSociete, Model model) {
         service.supprimerSocieteTransport(idSociete);
         model.addAttribute("societeTransport", new SocieteTransport());
         model.addAttribute("societeTransports", service.listerSocieteTransport());
         return "societeTransports";
     }
	 
	 @RequestMapping(value = "/editSocieteTransport")
     public String edit(@RequestParam int idSociete, Model model) {
         model.addAttribute("societeTransport", service.getSocieteTransport(idSociete));
         model.addAttribute("societeTransports", service.listerSocieteTransport());
         return "societeTransports";
     }
}
