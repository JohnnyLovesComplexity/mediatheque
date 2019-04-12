package com.epul.controle;

import com.epul.dao.ServiceEmpruntDAO;
import com.epul.dao.ServiceOeuvreDAO;
import com.epul.dao.ServiceReservationDAO;
import com.epul.meserreurs.MonException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ControleurEmprunt {
    @RequestMapping(value = "listerEmprunts.htm")
    public ModelAndView afficherLesEmprunts(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;
        try {
            // HttpSession session = request.getSession();
            request.setAttribute("emprunts", ServiceEmpruntDAO.consulterListeEmprunts());
            destinationPage = "vues/listerEmprunts";
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "vues/Erreur";

        }
        return new ModelAndView(destinationPage);
    }
}
