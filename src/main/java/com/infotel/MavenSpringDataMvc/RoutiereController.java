package com.infotel.MavenSpringDataMvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.infotel.MavenSpringDataMvc.metier.Aerienne;
import com.infotel.MavenSpringDataMvc.metier.Routiere;
import com.infotel.MavenSpringDataMvc.service.Iservice;




@Controller
public class RoutiereController {

	@Autowired
    private Iservice service;
	
	@RequestMapping(value = "/indexRoutiere", method = RequestMethod.GET)
    public String lister(Model model) {
        model.addAttribute("routiere", new Routiere());
        model.addAttribute("routieres", service.listerRoutiere());
        model.addAttribute("societeTransports", service.listerSocieteTransport());
        return "routieres";
    }
	
	 @RequestMapping(value = "/saveRoutiere")
	    public String save(Routiere routiere,  Model model) {
	        if (routiere.getIdCargaison() == 0) {
	           
	        	service.ajouterRoutiere(routiere);
	            model.addAttribute("routiere", new Routiere());
	            model.addAttribute("routieres", service.listerRoutiere());
	            model.addAttribute("societeTransports", service.listerSocieteTransport());
	            return "routieres";
	            
	        } else {
	        	
	        	String nomCargaison = routiere.getNomCargaison();
	            String depart = routiere.getDepart();
	            String destination = routiere.getDestination();
	            int idCargaison= routiere.getIdCargaison();
	            String immatriculation = routiere.getImmatriculation();
	            double peage= routiere.getPeage();
	            
	        	service.modifierRoutiere(nomCargaison, depart, destination, immatriculation, peage, idCargaison);
	            model.addAttribute("routiere", new Routiere());
	            model.addAttribute("routieres", service.listerRoutiere());
	            model.addAttribute("societeTransports", service.listerSocieteTransport());
	            return "routieres";
	        }
	   }
	 
	 @RequestMapping(value = "/deleteRoutiere")
     public String delete(@RequestParam int idCargaison, Model model) {
         service.supprimerCargaison(idCargaison);
         model.addAttribute("routiere", new Routiere());
         model.addAttribute("routieres", service.listerRoutiere());
         model.addAttribute("societeTransports", service.listerSocieteTransport());
         return "routieres";
     }
	 
	 @RequestMapping(value = "/editRoutiere")
     public String edit(@RequestParam int idCargaison, Model model) {
         model.addAttribute("routiere", service.getCargaison(idCargaison));
         model.addAttribute("routieres", service.listerRoutiere());
         model.addAttribute("societeTransports", service.listerSocieteTransport());
         return "routieres";
     }
	 
	 @RequestMapping(value = "/indexAttribuerRoutiere")
	 public String  listerAttribuer(Model model) {
		 model.addAttribute("routiere", new Routiere());
	     model.addAttribute("routieres", service.listerRoutiere());
	     model.addAttribute("societeTransports", service.listerSocieteTransport());
	     return "liersocieteroutiere";
	 }
	 
	 @RequestMapping(value = "/attribuerRoutiere")
	 public String attribuerAerienne(@RequestParam int idSociete, @RequestParam int idCargaison, Model model) {
		 service.lierRoutiereSociete(idSociete, idCargaison);
		 model.addAttribute("routieres", service.listerAerienne());
	     model.addAttribute("societeTransports", service.listerSocieteTransport());
		 return "liersocieteroutiere";
	 }
}
