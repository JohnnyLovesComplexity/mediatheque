package com.epul.dao;

import com.epul.meserreurs.MonException;
import com.epul.metier.EmpruntEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.List;

public class ServiceEmpruntDAO {
    /* Lister les réservations
     * */
    public static List<EmpruntEntity> consulterListeEmprunts() throws MonException {
        List<EmpruntEntity> emprunts = null;
        String marequete = "SELECT e FROM EmpruntEntity e ORDER BY e.dateReservation";

        try (Session session = ServiceHibernate.currentSession()) {
            TypedQuery<EmpruntEntity> query = session.createQuery(marequete);
            emprunts = query.getResultList();
        } catch (HibernateException ex) {
            throw new MonException("Impossible d'accèder à la SessionFactory: ",  ex.getMessage());
        }

        return emprunts;
    }

    public static void insertEmprunt(EmpruntEntity emprunt) throws MonException {
        Transaction tx = null;
        try (Session session = ServiceHibernate.currentSession()) {
            tx = session.beginTransaction();
            session.save(emprunt);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
        } catch (Exception e) {
            throw new MonException("Impossible d'accèder à la SessionFactory: ", e.getMessage());
        }
    }

}
