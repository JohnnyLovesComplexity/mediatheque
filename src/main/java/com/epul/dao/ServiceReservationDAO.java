package com.epul.dao;

import com.epul.meserreurs.MonException;
import com.epul.metier.ReservationEntity;
import com.sun.org.apache.xpath.internal.operations.And;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.sql.Date;
import java.util.List;

public class ServiceReservationDAO {

    /* Lister les réservations
     * */
    public static List<ReservationEntity> consulterListeReservations() throws MonException {
        List<ReservationEntity> reservations = null;
        String marequete = "SELECT r FROM ReservationEntity r ORDER BY r.dateReservation";

        try (Session session = ServiceHibernate.currentSession()) {
            TypedQuery<ReservationEntity> query = session.createQuery(marequete);
            reservations = query.getResultList();
        } catch (HibernateException ex) {
            throw new MonException("Impossible d'accèder à la SessionFactory: ",  ex.getMessage());
        }

        return reservations;
    }

    public static void insertReservation(ReservationEntity reservation) throws MonException {
        Transaction tx = null;
        try (Session session = ServiceHibernate.currentSession()) {
            tx = session.beginTransaction();
            session.save(reservation);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
        } catch (Exception e) {
            throw new MonException("Impossible d'accèder à la SessionFactory: ", e.getMessage());
        }
    }
    
    public static void deleteReservation(ReservationEntity reservation) throws MonException {
        Transaction tx = null;
        try (Session session = ServiceHibernate.currentSession()) {
            tx = session.beginTransaction();
            session.delete(reservation);
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

    public static ReservationEntity getReservation(Integer idOeuvre, Integer idAdherent, Date date){
        List<ReservationEntity> reservation = null;
        String marequete = "SELECT r FROM ReservationEntity r WHERE r.dateReservation = '" + date
                + "' AND r.idOeuvrevente = " + idOeuvre + " AND r.idAdherent = " + idAdherent;

        try (Session session = ServiceHibernate.currentSession()) {
            TypedQuery<ReservationEntity> query = session.createQuery(marequete);
            reservation = query.getResultList();
        } catch (HibernateException ex) {
            throw new MonException("Impossible d'accèder à la SessionFactory: ",  ex.getMessage());
        }

        return reservation.get(0);
    }

    public static void updateReservation(ReservationEntity res) throws MonException
    {
        Transaction tx = null;
        try (Session   session = ServiceHibernate.currentSession()) {
            tx = session.beginTransaction();
            session.merge(res);
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
