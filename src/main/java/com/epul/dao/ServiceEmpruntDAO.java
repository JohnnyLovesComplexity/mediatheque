package com.epul.dao;

import com.epul.meserreurs.MonException;
import com.epul.metier.EmpruntEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.sql.Date;
import java.util.List;

public class ServiceEmpruntDAO {
    /* Lister les emprunts
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
    
    public static void deleteEmprunt(EmpruntEntity emprunt) throws MonException {
        Transaction tx = null;
        try (Session session = ServiceHibernate.currentSession()) {
            tx = session.beginTransaction();
            session.delete(emprunt);
            tx.commit();
        }
        catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
        }
        catch (Exception e) {
            throw new MonException("Impossible d'accèder à la SessionFactory: ",  e.getMessage());
        }
    }

    public static EmpruntEntity getEmprunt(Integer idOeuvre, Integer idAdherent, Date date){
        List<EmpruntEntity> emprunt = null;
        String marequete = "SELECT e FROM EmpruntEntity e WHERE e.dateReservation = '" + date
                + "' AND e.idOeuvrepret = " + idOeuvre + " AND e.idAdherent = " + idAdherent;

        try (Session session = ServiceHibernate.currentSession()) {
            TypedQuery<EmpruntEntity> query = session.createQuery(marequete);
            emprunt = query.getResultList();
        } catch (HibernateException ex) {
            throw new MonException("Impossible d'accèder à la SessionFactory: ",  ex.getMessage());
        }

        return emprunt.get(0);
    }

    public static void updateEmprunt(EmpruntEntity emp) throws MonException
    {
        Transaction tx = null;
        try (Session   session = ServiceHibernate.currentSession()) {
            tx = session.beginTransaction();
            session.merge(emp);
            tx.commit();
        }
        catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
        }
        catch (Exception e) {
            throw new MonException("Impossible d'accèder à la SessionFactory: ",  e.getMessage());
        }
    }

}
