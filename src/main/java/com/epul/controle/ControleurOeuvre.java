package com.epul.controle;

import com.epul.dao.ServiceAdherentDAO;
import com.epul.dao.ServiceOeuvreDAO;
import com.epul.meserreurs.MonException;
import com.epul.metier.AdherentEntity;
import com.epul.metier.OeuvrepretEntity;
import com.epul.metier.OeuvreventeEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ControleurOeuvre {
	
	/**
	 * FRONT function.
	 * Redirect the user to the list of the masterpieces.
	 * @param request The HTTP request, where the function will feed some instances that can be used in the `.jsp` file.
	 * @param response The HTTP response. Not used here by the function.
	 * @return Return an instance of `ModelAndView` with the require page.
	 */
	@NotNull
	@RequestMapping(value = "listerOeuvre.htm")
	public ModelAndView listOeuvre(@NotNull HttpServletRequest request, @Nullable HttpServletResponse response) {
		String destination;
		
		try {
			// HttpSession session = request.getSession();
			ServiceOeuvreDAO service = new ServiceOeuvreDAO();
			request.setAttribute("oeuvrespret", service.listOeuvrePret());
			request.setAttribute("oeuvresvente", service.listOeuvreVente());
			destination = "vues/listerOeuvres";
		} catch (MonException e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destination = "vues/Erreur";
		}
		
		return new ModelAndView(destination);
	}
	
	/**
	 * FRONT function.
	 * Redirect the user to the page to add a masterpiece.
	 * @param request The HTTP request, where the function will feed some instances that can be used in the `.jsp` file.
	 *                It is not used by this function.
	 * @param response The HTTP response. Not used here by the function.
	 * @return Return an instance of `ModelAndView` with the require page.
	 */
	@NotNull
	@RequestMapping
	public ModelAndView ajouterOeuvrePret(@Nullable HttpServletRequest request, @Nullable HttpServletResponse response) {
		return ajouterOeuvre(request, response);
	}
	
	/**
	 * FRONT function.
	 * Redirect the user to the page to add a masterpiece.
	 * @param request The HTTP request, where the function will feed some instances that can be used in the `.jsp` file.
	 *                It is not used by this function.
	 * @param response The HTTP response. Not used here by the function.
	 * @return Return an instance of `ModelAndView` with the require page.
	 */
	public ModelAndView ajouterOeuvreVente(@Nullable HttpServletRequest request, @Nullable HttpServletResponse response) {
		return ajouterOeuvre(request, response);
	}
	
	/**
	 * FRONT function.
	 * Redirect the user to the page to add a masterpiece.
	 * @param request The HTTP request, where the function will feed some instances that can be used in the `.jsp` file.
	 *                It is not used by this function.
	 * @param response The HTTP response. Not used here by the function.
	 * @return Return an instance of `ModelAndView` with the require page.
	 */
	public ModelAndView ajouterOeuvre(@Nullable HttpServletRequest request, @Nullable HttpServletResponse response) {
		return new ModelAndView("vues/ajouterOeuvre");
	}
	
	/**
	 * BACK function.
	 * Add a masterpiece to the database and redirect the user to the previous page.
	 * @param request The HTTP request, where the function will feed some instances that can be used in the `.jsp` file.
	 * @param response The HTTP response. Not used here by the function.
	 * @return Return an instance of `ModelAndView` with the require page.
	 */
	public ModelAndView insererOeuvrePret(@NotNull HttpServletRequest request, @Nullable HttpServletResponse response) {
		String destination;
		
		try {
			OeuvrepretEntity oeuvre = new OeuvrepretEntity();
			oeuvre.setTitreOeuvrepret(request.getParameter("txttitre"));
			ServiceOeuvreDAO service = new ServiceOeuvreDAO();
			service.insertOeuvre(oeuvre);
			destination = "index";
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destination = "vues/Erreur";
		}
		
		return new ModelAndView(destination);
	}
	
	/**
	 * BACK function.
	 * Add a masterpiece to the database and redirect the user to the previous page.
	 * @param request The HTTP request, where the function will feed some instances that can be used in the `.jsp` file.
	 * @param response The HTTP response. Not used here by the function.
	 * @return Return an instance of `ModelAndView` with the require page.
	 */
	public ModelAndView insererOeuvreVente(@NotNull HttpServletRequest request, @Nullable HttpServletResponse response) {
		String destination;
		
		try {
			OeuvreventeEntity oeuvre = new OeuvreventeEntity();
			// TODO: Check the fields name
			oeuvre.setTitreOeuvrevente(request.getParameter("txttitre"));
			oeuvre.setEtatOeuvrevente(request.getParameter("txtetat"));
			oeuvre.setPrixOeuvrevente(Double.parseDouble(request.getParameter("prix")));
			ServiceOeuvreDAO service = new ServiceOeuvreDAO();
			service.insertOeuvre(oeuvre);
			destination = "index";
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destination = "vues/Erreur";
		}
		
		return new ModelAndView(destination);
	}
}
