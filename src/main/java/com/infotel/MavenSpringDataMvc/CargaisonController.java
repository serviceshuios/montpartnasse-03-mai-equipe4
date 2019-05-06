package com.infotel.MavenSpringDataMvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.infotel.MavenSpringDataMvc.metier.Cargaison;
import com.infotel.MavenSpringDataMvc.service.Iservice;




@Controller
public class CargaisonController {

	@Autowired
    private Iservice service;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
    public String lister(Model model) {
        model.addAttribute("cargaison", new Cargaison());
        model.addAttribute("cargaisons", service.listerCargaison());
        return "cargaisons";
    }
	
	 @RequestMapping(value = "/saveCargaison")
	    public String save(Cargaison cargaison,  Model model) {
	        if (cargaison.getIdCargaison() == 0) {
	           
	        	service.ajouterCargaison(c);
	            model.addAttribute("cargaison", new Cargaison());
	            model.addAttribute("cargaison", service.listerCargaison());
	            return "cargaisons";
	            
	        } else {
	        	
	        	String nomCargaison = cargaison.getNomCargaison();
	            String depart = cargaison.getDepart();
	            String destination = cargaison.getDestination();
	            int idCargaison= cargaison.getIdCargaison();
	            
	        	service.modifierCargaison(nomCargaison, depart, destination, idCargaison);
	            model.addAttribute("cargaison", new Cargaison());
	            model.addAttribute("cargaisons", service.listerCargaison());
	            return "cargaisons";
	        }
	   }
	 
	 @RequestMapping(value = "/deleteCargaison")
     public String delete(@RequestParam int idCargaison, Model model) {
         service.supprimerCargaison(idCargaison);
         model.addAttribute("cargaison", new Cargaison());
         model.addAttribute("cargaisons", service.listerCargaison());
         return "cargaison";
     }
	 
	 @RequestMapping(value = "/editCargaison")
     public String edit(@RequestParam int idCargaison, Model model) {
         model.addAttribute("cargaison", service.getCargaison(idCargaison));
         model.addAttribute("cargaison", service.listerCargaison());
         return "cargaison";
     }
}