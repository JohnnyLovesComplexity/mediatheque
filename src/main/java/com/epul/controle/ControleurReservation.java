package com.epul.controle;

import com.epul.dao.ServiceReservationDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.epul.meserreurs.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
}
