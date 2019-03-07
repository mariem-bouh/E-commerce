package com.example.ecommerce.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.ecommerce.dao.PanierRepository;
import com.example.ecommerce.dao.RoleRepository;
import com.example.ecommerce.dao.UserRepository;
import com.example.ecommerce.entities.Users;
import com.example.ecommerce.entities.Panier;
import com.example.ecommerce.entities.Role;
import com.example.ecommerce.entities.UserModel;

@ControllerAdvice
public class GlobalController {

	@Autowired 
    private	UserRepository userRepository; 
	@Autowired
	private HttpSession session;
	@Autowired
	private RoleRepository roleRepository ;
	
	@Autowired
	private PanierRepository panierRepository ;
	
	private UserModel userModel;

	@ModelAttribute("userModel")
	public UserModel getUserModel() {
		if (session.getAttribute("userModel") == null) {
			// Ajout du modelUser
			/*
			 * quand l'utilisateur est connecter mais il n'est pas dans la session
			 * ===> recuperation de l'object d'authentification
			 */
			
			Authentication authentication=SecurityContextHolder.getContext().getAuthentication();

			Users user= userRepository.findByUsername(authentication.getName());
			userModel=new UserModel();
			//si l'utilisteur existe  
			userModel.setEmail("");
			userModel.setRole(null);
			userModel.setFullname("");
			if (user!=null) {
				
				//creation d'un user model pour passer les detail concernant l'utilisateur
				userModel=new UserModel();
				
				userModel.setId(user.getIdUser());
				
				//recuperation du role de l'utilisateur dans la table role
				
				Role role =roleRepository.findByUserId(user.getIdUser());
				
				System.out.println(role.getRoleName());
				
				String zte=role.getRoleName();
			    
				userModel.setRole(zte);
				
				userModel.setFullname(user.getUsername());
				
				if (userModel.getRole().equals("USER")) {
					// set the cart only if user is a buyer
					/*
					 * rehercher le panier correspondant a un utilisateur
					 * */
				
					Panier panier=panierRepository.findByUserIdPanier(user.getIdUser());
					System.out.println(panier.getTotal());
					
						System.out.println(panier.toString());
						
					userModel.setPanier(panier);
				}
				
				//set the model in the session
				session.setAttribute("userModel",userModel);
			return userModel;
			}
		}
		// retouner si le user model existe deja
		return (UserModel) session.getAttribute("userModel");
	}

}
