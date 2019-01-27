package com.example.ecommerce.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.ecommerce.entities.Categorie;
import com.example.ecommerce.entities.Produits;
import com.example.ecommerce.metier.IAdminSousCategorieMetier;
import com.example.ecommerce.metier.InterfaceAdminProduitMetier;

@Controller
@RequestMapping(value="/adminProd")
public class AdminProduitController {

@Autowired
private InterfaceAdminProduitMetier metier;
@Autowired(required=true)
private IAdminSousCategorieMetier metierSousCat;
public static String uploadDirectory = System.getProperty("user.dir")+"/images";

@RequestMapping(value="/index")
public String index(Model model) {
	model.addAttribute("produit",new Produits());
	model.addAttribute("produit",metier.listProduit());
//model.addAttribute("categories",metier.listCtegorie());
	return "produits";
}

@RequestMapping(value="/FormAjoutProd")
public String FormAjoutProd(Model model) {
//	metier.AjouterProduit(produits, idCAT);
	model.addAttribute("souscategorie",metierSousCat.ListSousCategory());
	model.addAttribute("categorie",metier.listProduit());
	return "FormAjoutProd";
}

@RequestMapping(value="/saveProd")
public String saveProd(Model model, @Valid Produits produits,
		BindingResult bindingResult,Long souscategorie,
		@RequestParam(name="selected",defaultValue="")String selected,MultipartFile files) {

	if (bindingResult.hasErrors()) {
		return "FormAjoutProd";	
	}else {
		
		 StringBuilder fileNames = new StringBuilder();
		  MultipartFile file = files;
		  Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
		  fileNames.append(file.getOriginalFilename());
		  try {
			Files.write(fileNameAndPath, file.getBytes());
		

		  produits.setPhoto(fileNames.toString());
		  
		  if (selected.equals("on")) {
			produits.setSelected(true);
		}else if(selected.equals("")) {
			produits.setSelected(false);
		}
		  Long idSouCat=souscategorie;
		  metier.AjouterProduit(produits,idSouCat);

		  } catch (IOException e) {
			e.printStackTrace();
			return "FormAjoutCat";
		  }
		
		
		
		return "redirect:/adminProd/index";		
	}

}


@RequestMapping(value="/SupprimerProd")
public String SupprimerProd(Long id) {
metier.supprimerProduit(id);
	return "redirect:/adminProd/index";		

}


@RequestMapping(value="/FormEditProd")
public String FormEditProd(Model model, Long id) {
	model.addAttribute("produit",metier.getProduit(id));
	model.addAttribute("souscategorie",metierSousCat.ListSousCategory());
	model.addAttribute("categorie",metier.listProduit());
	return "FormEditProd";		

}


}
