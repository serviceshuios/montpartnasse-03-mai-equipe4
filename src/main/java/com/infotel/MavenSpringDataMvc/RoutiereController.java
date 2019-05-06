package com.infotel.MavenSpringDataMvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.infotel.MavenSpringDataMvc.metier.Cargaison;
import com.infotel.MavenSpringDataMvc.metier.Routiere;
import com.infotel.MavenSpringDataMvc.service.Iservice;




@Controller
public class RoutiereController {

	@Autowired
    private Iservice service;
	
	@RequestMapping(value = "/indexRoutiere", method = RequestMethod.GET)
    public String lister(Model model) {
        model.addAttribute("cargaison", new Routiere());
        model.addAttribute("cargaisons", service.listerCargaison());
        return "cargaisons";
    }
	
	 @RequestMapping(value = "/saveRoutiere")
	    public String save(Routiere cargaison,  Model model) {
	        if (cargaison.getIdCargaison() == 0) {
	           
	        	service.ajouterRoutiere(cargaison);
	            model.addAttribute("cargaison", new Routiere());
	            model.addAttribute("cargaison", service.listerCargaison());
	            return "cargaisons";
	            
	        } else {
	        	
	        	String nomCargaison = cargaison.getNomCargaison();
	            String depart = cargaison.getDepart();
	            String destination = cargaison.getDestination();
	            int idCargaison= cargaison.getIdCargaison();
	            String immatriculation = cargaison.getImmatriculation();
	            double peage= cargaison.getPeage();
	            
	        	service.modifierRoutiere(nomCargaison, depart, destination, immatriculation, peage, idCargaison);
	            model.addAttribute("cargaison", new Routiere());
	            model.addAttribute("cargaisons", service.listerCargaison());
	            return "cargaisons";
	        }
	   }
	 
	 @RequestMapping(value = "/deleteRoutiere")
     public String delete(@RequestParam int idCargaison, Model model) {
         service.supprimerCargaison(idCargaison);
         model.addAttribute("cargaison", new Routiere());
         model.addAttribute("cargaisons", service.listerCargaison());
         return "cargaisons";
     }
	 
	 @RequestMapping(value = "/editRoutiere")
     public String edit(@RequestParam int idCargaison, Model model) {
         model.addAttribute("cargaison", service.getCargaison(idCargaison));
         model.addAttribute("cargaison", service.listerCargaison());
         return "cargaisons";
     }
}
