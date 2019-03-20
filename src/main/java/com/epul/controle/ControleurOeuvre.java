package com.epul.controle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.epul.dao.ServiceAdherentDAO;
import com.epul.meserreurs.*;
import com.epul.metier.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ControleurOeuvre {
	
	@RequestMapping(value = "listerOeuvre.htm")
	public ModelAndView listOeuvre(HttpServletRequest request, HttpServletResponse response) {
		String destination;
		
		try {
			// HttpSession session = request.getSession();
			ServiceAdherentDAO unServiceAdherentDAO = new ServiceAdherentDAO();
			request.setAttribute("oeuvres", unServiceAdherentDAO.consulterListeAdherents());
			destination = "vues/listerAdherent";
		} catch (MonException e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destination = "vues/Erreur";
			
		}
		
		return destination;
	}

}
