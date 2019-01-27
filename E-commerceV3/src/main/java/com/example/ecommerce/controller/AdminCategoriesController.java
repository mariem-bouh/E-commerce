package com.example.ecommerce.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;


import com.example.ecommerce.entities.Categorie;
import com.example.ecommerce.entities.SousCategorie;
import com.example.ecommerce.metier.IAdminCategorieMetier;
import com.example.ecommerce.metier.IAdminSousCategorieMetier;

@Controller
@RequestMapping(value="/adminCat")
public class AdminCategoriesController {
	  public static String uploadDirectory = System.getProperty("user.dir")+"/images";
	@Autowired(required=true)
private IAdminCategorieMetier metier;

	@Autowired(required=true)
private IAdminSousCategorieMetier metierSousCat;



	
@RequestMapping(value="/index")
public String index(Model model) {
	model.addAttribute("categorie",new Categorie());
	model.addAttribute("categories",metier.listCtegorie());
	return "categories";
}


@RequestMapping(value="/FormAjoutCat")
public String FormAjoutCat() {
	
	return "FormAjoutCat";
}

@RequestMapping(value="/saveCat")
public String saveCat(Model model,Categorie c,MultipartFile files,BindingResult bindingResult) {

	if (bindingResult.hasErrors() || files.isEmpty()) {
		return "FormAjoutCat";
	}
	else {

		 StringBuilder fileNames = new StringBuilder();
		  MultipartFile file = files;
		  Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
		  fileNames.append(file.getOriginalFilename());
		  try {
			Files.write(fileNameAndPath, file.getBytes());
		

		  c.setPhoto(fileNames.toString());
		  metier.AjouterCategorie(c);
		  } catch (IOException e) {
			e.printStackTrace();
			return "FormAjoutCat";
		  }
		  
		  return "redirect:/adminCat/index";
			
	}	  
	  
}

@RequestMapping(value="/SupprimerCat")
public String SupprimerCat(Long id) {
	metier.SupprimerCategorie(id);
	return "redirect:/adminCat/index";
}	



@RequestMapping(value="/EditCat",method=RequestMethod.GET)
public String EditCat(Model model,Long id) {

	Categorie categorie	= metier.getCategorie(id);

	Categorie categorie2=new Categorie();

categorie2.setIdcategorie(id);
model.addAttribute("categori", categorie2);
model.addAttribute("categorie", categorie);
	return "FormEditCat";
}	

/*
 * 
 * 
 *      Gestion des sous categories
 * 
 * 
 * */
//liste des sous categorie
@RequestMapping(value="/indexSousCat")
public String indexSousCat(Model model) {
	//model.addAttribute("Souscategorie",new SousCategorie());
	model.addAttribute("Souscategorie",metierSousCat.ListSousCategory());
	return "Souscategories";
}

//Formulaire des sous categorie
@RequestMapping(value="/FormAjoutSousCat")
public String FormAjoutSousCat(Model model) {
	model.addAttribute("listcategorie",metier.listCtegorie());
	return "FormAjoutSousCat";
}


//Sauvegarde des sous categorie

@RequestMapping(value="/saveSousCat")
public String saveSousCat(Model model,SousCategorie c,BindingResult bindingResult,Long categorie) {

	if (bindingResult.hasErrors()) {
		return "FormAjoutSousCat";
	}
	else {
		
		Categorie catego=new Categorie();
		catego.setIdcategorie(categorie);
		//catego.setCategorie(categorie);
		SousCategorie categorie2=new SousCategorie();
		categorie2.setCategorie(catego);
		  metierSousCat.AjouterSousCategorie(c);
		  return "redirect:/adminCat/indexSousCat";
		  }
		  

			
	}	  
	  

//supprimmer des sous categorie
@RequestMapping(value="/SupprimerSousCat",method=RequestMethod.GET)
public String SupprimerSousCat(Long id) {
metierSousCat.SupprimerSousCategorie(id);	
	  return "redirect:/adminCat/indexSousCat";
}

//formulaire modifier des sous categorie
@RequestMapping(value="/EditSoutCat",method=RequestMethod.GET)
public String EditSoutCat(Model model,Long id) {
	model.addAttribute("listcategorie",metier.listCtegorie());
	
model.addAttribute("editsouscat",metierSousCat.getSousCategorie(id));
	  return "FormEditSousCat";
}



}

