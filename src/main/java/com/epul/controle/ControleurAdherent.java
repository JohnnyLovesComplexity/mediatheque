package com.epul.controle;

//import javax.servlet.ServletContext;

import com.epul.dao.ServiceAdherentDAO;
import com.epul.dao.ServiceEmpruntDAO;
import com.epul.dao.ServiceReservationDAO;
import com.epul.meserreurs.MonException;
import com.epul.metier.AdherentEntity;
import com.epul.metier.EmpruntEntity;
import com.epul.metier.ReservationEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

///
/// Les méthode du contrôleur répondent à des sollicitations
/// des pages JSP

@Controller
public class ControleurAdherent {

//	private static final Logger logger = LoggerFactory.getLogger(MultiControleur.class);

	@RequestMapping(value = "listerAdherent.htm")
	public ModelAndView afficherLesStages(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String destinationPage;
		try {
			request.setAttribute("mesAdherents", ServiceAdherentDAO.consulterListeAdherents());
			destinationPage = "vues/listerAdherent";
		} catch (MonException e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "vues/Erreur";

		}
		return new ModelAndView(destinationPage);
	}

	@RequestMapping(value = "insererAdherent.htm")
	public ModelAndView insererAdherent(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String destinationPage = "";
		try {
			AdherentEntity unAdherent = new AdherentEntity();
			unAdherent.setNomAdherent(request.getParameter("txtnom"));
			unAdherent.setPrenomAdherent(request.getParameter("txtprenom"));
			unAdherent.setVilleAdherent(request.getParameter("txtville"));
			ServiceAdherentDAO.insertAdherent(unAdherent);
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "vues/Erreur";
		}
		destinationPage = "index";
		return new ModelAndView(destinationPage);
	}

	@RequestMapping(value = "ajouterAdherent.htm")
	public ModelAndView ajouterAdherent(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String destinationPage = "";
		try {
			destinationPage = "vues/ajouterAdherent";
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "Erreur";
		}

		return new ModelAndView(destinationPage);
	}
	@RequestMapping(value = "supprimerAdherent.htm")
	public ModelAndView supprimerAdherent(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String destinationPage = "";
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			AdherentEntity adherentEntity = ServiceAdherentDAO.adherentById(id);
			
			// Check if the adherent ahs a reservation
			List<ReservationEntity> reservations = ServiceReservationDAO.consulterListeReservations();
			for (int i = 0; i < reservations.size(); i++) {
				if (reservations.get(i).getIdAdherent() == adherentEntity.getIdAdherent()) {
					System.out.println("supprimerAdherent> Delete reservation: " + reservations.get(i));
					ServiceReservationDAO.deleteReservation(reservations.get(i));
					reservations.remove(i--);
				}
			}
			List<EmpruntEntity> emprunts = ServiceEmpruntDAO.consulterListeEmprunts();
			for (int i = 0; i < emprunts.size(); i++) {
				if (emprunts.get(i).getIdAdherent() == adherentEntity.getIdAdherent()) {
					System.out.println("supprimerAdherent> Delete emprunt: " + emprunts.get(i));
					ServiceEmpruntDAO.deleteEmprunt(emprunts.get(i));
					emprunts.remove(i--);
				}
			}
			
			System.out.println("supprimerAdherent> Fin");
			
			ServiceAdherentDAO.deleteAdherent(adherentEntity);
			destinationPage = "redirect:/listerAdherent.htm";
		} catch (MonException e) {
			e.printStackTrace();
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "/vues/Erreur";
		}

		return new ModelAndView(destinationPage);
	}

	@RequestMapping(value = "updateAdherent.htm")
	public ModelAndView updateAdherent(HttpServletRequest request,
									   HttpServletResponse response) throws Exception {

		String destinationPage = "";
		try {
			AdherentEntity unAdherent = new AdherentEntity();
			unAdherent.setIdAdherent(Integer.parseInt(request.getParameter("id")));
			unAdherent.setNomAdherent(request.getParameter("txtnom"));
			unAdherent.setPrenomAdherent(request.getParameter("txtprenom"));
			unAdherent.setVilleAdherent(request.getParameter("txtville"));
			ServiceAdherentDAO.updateAdherent(unAdherent);
			destinationPage = "redirect:/listerAdherent.htm";
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "vues/Erreur";
		}
		return new ModelAndView(destinationPage);
	}

	@RequestMapping(value = "afficherAdherent.htm")
	public ModelAndView afficherAdherent(HttpServletRequest request,
										 HttpServletResponse response) throws Exception {

		String destinationPage = "";
		try {
			String id = request.getParameter("id");
			int intId = Integer.parseInt(id);
			AdherentEntity unAdherent = ServiceAdherentDAO.adherentById(intId);
			request.setAttribute("adherent", unAdherent);
			destinationPage = "vues/modifierAdherent";
		} catch (MonException e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "vues/Erreur";
		}
		return new ModelAndView(destinationPage);
	}

	// /
	// / Affichage de la page d'accueil
	// /
	@RequestMapping(value = "index.htm", method = RequestMethod.GET)
	public ModelAndView Afficheindex(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("index");
	}

	// /
	// / Affichage de la page d'accueil
	// /
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView Afficheindex2(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("index");
	}
	// /
	// / Affichage de la page d'accueil
	// /
	@RequestMapping(value = "erreur.htm", method = RequestMethod.GET)
	public ModelAndView AfficheErreur(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("vues/Erreur");
	}
}
