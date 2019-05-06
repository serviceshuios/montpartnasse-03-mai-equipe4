package com.infotel.MavenSpringDataMvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.infotel.MavenSpringDataMvc.metier.Aerienne;
import com.infotel.MavenSpringDataMvc.metier.Cargaison;
import com.infotel.MavenSpringDataMvc.service.Iservice;




@Controller
public class AerienneController {

	@Autowired
    private Iservice service;
	
	@RequestMapping(value = "/indexAerienne", method = RequestMethod.GET)
    public String lister(Model model) {
        model.addAttribute("cargaison", new Aerienne());
        model.addAttribute("cargaisons", service.listerCargaison());
        return "aeriennes";
    }
	
	 @RequestMapping(value = "/saveAerienne")
	    public String save(Aerienne cargaison,  Model model) {
	        if (cargaison.getIdCargaison() == 0) {
	           
	        	service.ajouterAerienne(cargaison);
	            model.addAttribute("cargaison", new Aerienne());
	            model.addAttribute("cargaison", service.listerCargaison());
	            return "aeriennes";
	            
	        } else {
	        	
	        	String nomCargaison = cargaison.getNomCargaison();
	            String depart = cargaison.getDepart();
	            String destination = cargaison.getDestination();
	            String numVol= cargaison.getNumVol();
	            double taxe = cargaison.getTaxe();
	            int idCargaison= cargaison.getIdCargaison();
	            
	        	service.modifierAerienne (nomCargaison, depart, destination,numVol,taxe, idCargaison);
	            model.addAttribute("cargaison", new Aerienne());
	            model.addAttribute("cargaisons", service.listerCargaison());
	            return "aeriennes";
	        }
	   }
	 
	 @RequestMapping(value = "/deleteAerienne")
     public String delete(@RequestParam int idCargaison, Model model) {
         service.supprimerCargaison(idCargaison);
         model.addAttribute("cargaison", new Aerienne());
         model.addAttribute("cargaisons", service.listerCargaison());
         return "aeriennes";
     }
	 
	 @RequestMapping(value = "/editAerienne")
     public String edit(@RequestParam int idCargaison, Model model) {
         model.addAttribute("cargaison", service.getCargaison(idCargaison));
         model.addAttribute("cargaisons", service.listerCargaison());
         return "aeriennes";
     }
}
