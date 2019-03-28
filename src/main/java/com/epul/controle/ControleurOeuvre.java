package com.epul.controle;

import com.epul.dao.ServiceOeuvreDAO;
import com.epul.dao.ServiceProprietaireDAO;
import com.epul.meserreurs.MonException;
import com.epul.metier.OeuvrepretEntity;
import com.epul.metier.OeuvreventeEntity;
import com.epul.metier.ProprietaireEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
	public ModelAndView ajouterOeuvrePret(@NotNull HttpServletRequest request, @Nullable HttpServletResponse response) {
		List<ProprietaireEntity> proprietaires = ServiceProprietaireDAO.listProprietaires();
		request.setAttribute("proprietaires", proprietaires);
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
	public ModelAndView ajouterOeuvreVente(@NotNull HttpServletRequest request, @Nullable HttpServletResponse response) {
		List<ProprietaireEntity> proprietaires = ServiceProprietaireDAO.listProprietaires();
		request.setAttribute("proprietaires", proprietaires);
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
			extractDataPretFromRequest(request, oeuvre);
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
			extractDataVenteFromRequest(request, oeuvre);
			oeuvre.setEtatOeuvrevente("L");
			ServiceOeuvreDAO.insertOeuvre(oeuvre);
			destination = "index";
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destination = "vues/Erreur";
		}
		
		return new ModelAndView(destination);
	}

	/**
	 * FRONT function
	 * @param request The HTTP request, where the function will feed some instances that can be used in the `.jsp` file
	 * @param response The HTTP response. Not used here by the function.
	 * @return Return an instance of `ModelAndView` with the require page.
	 */
	@NotNull
	@RequestMapping("modifierOeuvreVente")
	public ModelAndView modifierOeuvreVente(@NotNull HttpServletRequest request, @Nullable HttpServletResponse response) {
		String destination;

		try {
			OeuvreventeEntity oeuvre;
			oeuvre = ServiceOeuvreDAO.getOeuvreVenteById(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("oeuvrevente", oeuvre);
			List<ProprietaireEntity> proprietaires = ServiceProprietaireDAO.listProprietaires();
			request.setAttribute("proprietaires", proprietaires);
			destination = "vues/modifierOeuvreVente";
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destination = "vues/Erreur";
		}

		return new ModelAndView(destination);
	}

	@NotNull
	@RequestMapping("updateOeuvreVente")
	public ModelAndView updateOeuvreVente(@NotNull HttpServletRequest request, @Nullable HttpServletResponse response) {
		String destination;

		try {
			OeuvreventeEntity oeuvre = new OeuvreventeEntity();
			oeuvre = ServiceOeuvreDAO.getOeuvreVenteById(Integer.parseInt(request.getParameter("id")));
			extractDataVenteFromRequest(request, oeuvre);
			oeuvre.setEtatOeuvrevente(request.getParameter("etatoeuvre"));
			ServiceOeuvreDAO.updateOeuvre(oeuvre);
			destination = "index";
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destination = "vues/Erreur";
		}

		return new ModelAndView(destination);
	}

	private void extractDataVenteFromRequest(@NotNull HttpServletRequest request, OeuvreventeEntity oeuvre) {
		oeuvre.setTitreOeuvrevente(request.getParameter("txttitre"));
		oeuvre.setPrixOeuvrevente(Double.parseDouble(request.getParameter("numberprix")));
		int idProprietaire = Integer.parseInt(request.getParameter("idProprietaire"));
		ProprietaireEntity proprietaireEntity = ServiceProprietaireDAO.proprietaireById(idProprietaire);
		oeuvre.setProprietaireByIdProprietaire(proprietaireEntity);
		oeuvre.setIdProprietaire(idProprietaire);
	}

	/**
	 * FRONT function
	 * @param request The HTTP request, where the function will feed some instances that can be used in the `.jsp` file
	 * @param response The HTTP response. Not used here by the function.
	 * @return Return an instance of `ModelAndView` with the require page.
	 */
	@NotNull
	@RequestMapping("modifierOeuvrePret")
	public ModelAndView modifierOeuvrePret(@NotNull HttpServletRequest request, @Nullable HttpServletResponse response) {
		String destination;

		try {
			OeuvrepretEntity oeuvre;
			oeuvre = ServiceOeuvreDAO.getOeuvrePretById(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("oeuvrepret", oeuvre);
			List<ProprietaireEntity> proprietaires = ServiceProprietaireDAO.listProprietaires();
			request.setAttribute("proprietaires", proprietaires);
			destination = "vues/modifierOeuvrePret";
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destination = "vues/Erreur";
		}

		return new ModelAndView(destination);
	}

	@NotNull
	@RequestMapping("updateOeuvrePret")
	public ModelAndView updateOeuvrePret(@NotNull HttpServletRequest request, @Nullable HttpServletResponse response) {
		String destination;

		try {
			OeuvrepretEntity oeuvre = new OeuvrepretEntity();
			oeuvre = ServiceOeuvreDAO.getOeuvrePretById(Integer.parseInt(request.getParameter("id")));
			extractDataPretFromRequest(request, oeuvre);
			ServiceOeuvreDAO.updateOeuvre(oeuvre);
			destination = "index";
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destination = "vues/Erreur";
		}

		return new ModelAndView(destination);
	}

	private void extractDataPretFromRequest(@NotNull HttpServletRequest request, OeuvrepretEntity oeuvre) {
		oeuvre.setTitreOeuvrepret(request.getParameter("txttitre"));
		int idProprietaire = Integer.parseInt(request.getParameter("idProprietaire"));
		ProprietaireEntity proprietaireEntity = ServiceProprietaireDAO.proprietaireById(idProprietaire);
		oeuvre.setProprietaireByIdProprietaire(proprietaireEntity);
		oeuvre.setIdProprietaire(idProprietaire);
	}


}
