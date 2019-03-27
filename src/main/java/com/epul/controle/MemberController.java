package com.epul.controle;

import com.epul.dao.ServiceAdherentDAO;
import com.epul.meserreurs.MonException;
import com.epul.metier.AdherentEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MemberController {

    @RequestMapping(value = "listerAdherent.htm")
    public ModelAndView DisplayStages(HttpServletRequest request) {
        String destinationPage;
        try {
            ServiceAdherentDAO unServiceAdherentDAO = new ServiceAdherentDAO();
            request.setAttribute("mesAdherents", unServiceAdherentDAO.displayMemberList());
            destinationPage = "vues/listerAdherent";
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "vues/Erreur";
        }
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "insererAdherent.htm")
    public ModelAndView insertMember(HttpServletRequest request) {

        String destinationPage;
        try {
            AdherentEntity unAdherent = new AdherentEntity();
            unAdherent.setNomAdherent(request.getParameter("txtnom"));
            unAdherent.setPrenomAdherent(request.getParameter("txtprenom"));
            unAdherent.setVilleAdherent(request.getParameter("txtville"));
            ServiceAdherentDAO unServiceAdherentDAO = new ServiceAdherentDAO();
            unServiceAdherentDAO.insertMember(unAdherent);
            destinationPage = "index";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "vues/Erreur";
        }
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "ajouterAdherent.htm")
    public ModelAndView ajouterAdherent(HttpServletRequest request) {
        String destinationPage;
        try {
            destinationPage = "vues/ajouterAdherent";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "Erreur";
        }
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "index.htm", method = RequestMethod.GET)
    public ModelAndView displayIndex() {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView displayIndex2() {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "erreur.htm", method = RequestMethod.GET)
    public ModelAndView displayError() {
        return new ModelAndView("vues/Erreur");
    }


}
