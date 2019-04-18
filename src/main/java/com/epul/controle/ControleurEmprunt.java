package com.epul.controle;

import com.epul.dao.ServiceEmpruntDAO;
import com.epul.dao.ServiceOeuvreDAO;
import com.epul.meserreurs.MonException;
import com.epul.metier.EmpruntEntity;
import com.epul.metier.OeuvrepretEntity;
import com.epul.metier.OeuvreventeEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    @RequestMapping(value = "validerEmprunt.htm")
    public ModelAndView validerEmprunt(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;
        try {
            // HttpSession session = request.getSession();
            int idOeuvre = Integer.parseInt(request.getParameter("id"));
            int idAdherent = Integer.parseInt(request.getParameter("adh"));
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
            EmpruntEntity empruntEntity = ServiceEmpruntDAO.getEmprunt(idOeuvre,idAdherent, new java.sql.Date(date.getTime()));

            empruntEntity.setIdStatut(2);
            ServiceEmpruntDAO.updateEmprunt(empruntEntity);

            destinationPage = "redirect:/listerEmprunts.htm";
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "vues/Erreur";

        }
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "annulerEmprunt.htm")
    public ModelAndView annulerEmprunt(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;
        try {
            // HttpSession session = request.getSession();
            int idOeuvre = Integer.parseInt(request.getParameter("id"));
            int idAdherent = Integer.parseInt(request.getParameter("adh"));
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
            EmpruntEntity empruntEntity = ServiceEmpruntDAO.getEmprunt(idOeuvre,idAdherent, new java.sql.Date(date.getTime()));

            empruntEntity.setIdStatut(3);
            ServiceEmpruntDAO.updateEmprunt(empruntEntity);

            OeuvrepretEntity oeuvre = ServiceOeuvreDAO.getOeuvrePretById(idOeuvre);
            oeuvre.setEtatOeuvrepret("L");
            ServiceOeuvreDAO.updateOeuvre(oeuvre);

            destinationPage = "redirect:/listerEmprunts.htm";
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "vues/Erreur";
        }
        return new ModelAndView(destinationPage);
    }
}
