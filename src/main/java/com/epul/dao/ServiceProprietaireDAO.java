package com.epul.dao;

import com.epul.meserreurs.MonException;
import com.epul.metier.ProprietaireEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.persistence.TypedQuery;
import java.util.List;

public class ServiceProprietaireDAO {

    public static List<ProprietaireEntity> listProprietaires() {
        return listProprietaires(ProprietaireEntity.class, "nomProprietaire");
    }

    private static <T extends ProprietaireEntity> List<T> listProprietaires(@NotNull Class<T> clazz, @Nullable String attributeToOrder) {
        List<T> oeuvres = null;
        String rawQuery = "SELECT p FROM " + clazz.getSimpleName() + " p" + (attributeToOrder != null ? " ORDER BY p." + attributeToOrder : "");

        try (Session session = ServiceHibernate.currentSession()) {
            TypedQuery<T> query = session.createQuery(rawQuery, clazz);
            oeuvres = query.getResultList();
        } catch (HibernateException ex) {
            throw new MonException("Impossible d'accèder à la SessionFactory: ", ex.getMessage());
        }

        return oeuvres;
    }

    /**
     *
     * @param id Id du proprietaire
     * @return
     * @throws MonException
     */
    public static ProprietaireEntity proprietaireById(int id) throws MonException {
        List<ProprietaireEntity> mesProprietaires = null;
        ProprietaireEntity proprietaire = new ProprietaireEntity();
        String request ="SELECT p FROM ProprietaireEntity p WHERE p.idProprietaire=" + id;

        try (Session session = ServiceHibernate.currentSession()) {
            TypedQuery query =   session.createQuery(request);
            mesProprietaires =  query.getResultList();
            proprietaire = mesProprietaires.get(0);
        }
        catch (HibernateException ex) {
            throw new MonException("Impossible d'accèder à la SessionFactory: ",  ex.getMessage());
        }

        return proprietaire;
    }

}
