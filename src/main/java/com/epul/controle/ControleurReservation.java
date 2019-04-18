package com.epul.controle;

import com.epul.dao.ServiceOeuvreDAO;
import com.epul.dao.ServiceReservationDAO;
import com.epul.metier.OeuvreventeEntity;
import com.epul.metier.ReservationEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.epul.meserreurs.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ControleurReservation {

    @RequestMapping(value = "listerReservations.htm")
    public ModelAndView afficherLesReservations(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;
        try {
            // HttpSession session = request.getSession();
            request.setAttribute("reservations", ServiceReservationDAO.consulterListeReservations());
            destinationPage = "vues/listerReservations";
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "vues/Erreur";

        }
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "validerReservation.htm")
    public ModelAndView validerReservation(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;
        try {
            // HttpSession session = request.getSession();
            int idOeuvre = Integer.parseInt(request.getParameter("id"));
            int idAdherent = Integer.parseInt(request.getParameter("adh"));
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
            ReservationEntity reservationEntity = ServiceReservationDAO.getReservation(idOeuvre,idAdherent, new java.sql.Date(date.getTime()));

            reservationEntity.setStatut("Confirmee");
            ServiceReservationDAO.updateReservation(reservationEntity);

            request.setAttribute("reservations", ServiceReservationDAO.consulterListeReservations());
            destinationPage = "vues/listerReservations";
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "vues/Erreur";

        }
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "annulerReservation.htm")
    public ModelAndView annulerReservation(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;
        try {
            // HttpSession session = request.getSession();
            int idOeuvre = Integer.parseInt(request.getParameter("id"));
            int idAdherent = Integer.parseInt(request.getParameter("adh"));
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
            ReservationEntity reservationEntity = ServiceReservationDAO.getReservation(idOeuvre,idAdherent, new java.sql.Date(date.getTime()));

            reservationEntity.setStatut("Annulee");
            ServiceReservationDAO.updateReservation(reservationEntity);

            OeuvreventeEntity oeuvre = ServiceOeuvreDAO.getOeuvreVenteById(idOeuvre);
            oeuvre.setEtatOeuvrevente("L");
            ServiceOeuvreDAO.updateOeuvre(oeuvre);

            request.setAttribute("reservations", ServiceReservationDAO.consulterListeReservations());
            destinationPage = "vues/listerReservations";
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "vues/Erreur";

        }
        return new ModelAndView(destinationPage);
    }
}
