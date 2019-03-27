package com.epul.controle;

import com.epul.dao.ServiceOeuvreDAO;
import com.epul.meserreurs.MonException;
import com.epul.metier.OeuvrepretEntity;
import com.epul.metier.OeuvreventeEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	@RequestMapping("listerOeuvre.htm")
	public ModelAndView listOeuvre(@NotNull HttpServletRequest request, @Nullable HttpServletResponse response) {
		String destination;
		
		try {
			request.setAttribute("oeuvrespret", ServiceOeuvreDAO.listOeuvrePret());
			request.setAttribute("oeuvresvente", ServiceOeuvreDAO.listOeuvreVente());
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
	@RequestMapping("ajouterOeuvrePret")
	public ModelAndView ajouterOeuvrePret(@Nullable HttpServletRequest request, @Nullable HttpServletResponse response) {
		return new ModelAndView("vues/ajouterOeuvrePret");
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
	@RequestMapping("ajouterOeuvreVente")
	public ModelAndView ajouterOeuvreVente(@Nullable HttpServletRequest request, @Nullable HttpServletResponse response) {
		return new ModelAndView("vues/ajouterOeuvreVente");
	}
	
	/**
	 * BACK function.
	 * Add a masterpiece to the database and redirect the user to the previous page.
	 * @param request The HTTP request, where the function will feed some instances that can be used in the `.jsp` file.
	 * @param response The HTTP response. Not used here by the function.
	 * @return Return an instance of `ModelAndView` with the require page.
	 */
	@NotNull
	@RequestMapping("insererOeuvrePret")
	public ModelAndView insererOeuvrePret(@NotNull HttpServletRequest request, @Nullable HttpServletResponse response) {
		String destination;
		
		try {
			OeuvrepretEntity oeuvre = new OeuvrepretEntity();
			oeuvre.setTitreOeuvrepret(request.getParameter("txttitre"));
			ServiceOeuvreDAO.insertOeuvre(oeuvre);
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
	@NotNull
	@RequestMapping("insererOeuvreVente")
	public ModelAndView insererOeuvreVente(@NotNull HttpServletRequest request, @Nullable HttpServletResponse response) {
		String destination;
		
		try {
			OeuvreventeEntity oeuvre = new OeuvreventeEntity();
			// TODO: Check the fields name
			oeuvre.setTitreOeuvrevente(request.getParameter("txttitre"));
			oeuvre.setEtatOeuvrevente(request.getParameter("txtetat"));
			oeuvre.setPrixOeuvrevente(Double.parseDouble(request.getParameter("prix")));
			ServiceOeuvreDAO.insertOeuvre(oeuvre);
			destination = "index";
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destination = "vues/Erreur";
		}
		
		return new ModelAndView(destination);
	}
}
