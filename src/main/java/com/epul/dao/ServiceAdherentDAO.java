package com.epul.dao;


import com.epul.meserreurs.MonException;
import com.epul.metier.AdherentEntity;
import com.epul.metier.UtilisateurEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.List;


public class ServiceAdherentDAO {

    /**
     * display all members
     * @return list of all members
     * @throws MonException
     */
	public static List<AdherentEntity> displayMemberList() throws MonException {
		List<AdherentEntity> mesAdherents = null;
		String str_query = "SELECT a FROM AdherentEntity a ORDER BY a.nomAdherent";
		
		try (Session session = ServiceHibernate.currentSession()) {
			TypedQuery<AdherentEntity> query = session.createQuery(str_query);
			mesAdherents = query.getResultList();
		} catch (HibernateException ex) {
			throw new MonException("Impossible d'accèder à la SessionFactory: ",  ex.getMessage());
		}
		
		return mesAdherents;
	}

    /**
     * get a member by id
     * @param id
     * @return member
     * @throws MonException
     */
	public static AdherentEntity getMemberById(int id) throws MonException {
		List<AdherentEntity> mesAdherents = null;
		AdherentEntity adherent = new AdherentEntity();
		String str_query ="SELECT a FROM AdherentEntity a WHERE a.idAdherent=" + id;
		
		try (Session session = ServiceHibernate.currentSession()) {
			TypedQuery query =   session.createQuery(str_query);
			mesAdherents =  query.getResultList();
			adherent = mesAdherents.get(0);
		}
		catch (HibernateException ex) {
			throw new MonException("Impossible d'accèder à la SessionFactory: ",  ex.getMessage());
		}
		
		return adherent;
	}

    /**
     * add a new member
     * @param unAdh
     * @throws MonException
     */
	public static void insertMember(AdherentEntity unAdh) throws MonException  {
		Transaction tx = null;
		try (Session session = ServiceHibernate.currentSession()) {
			tx = session.beginTransaction();
			// on transfère le nouvel adhérent à la base
			session.save(unAdh);
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

    /**
     * delete a member
     * @param unAdh
     * @throws MonException
     */
	public static void deleteMember(AdherentEntity unAdh) throws MonException
	{
		Transaction tx = null;
		try (Session session = ServiceHibernate.currentSession()) {
			tx = session.beginTransaction();
			// on transfère le nouvel adhérent à la base
			session.delete(unAdh);
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

    /**
     * update a member
      * @param unAdh
     * @throws MonException
     */
	public static void updateMember(AdherentEntity unAdh) throws MonException
	{
		Transaction tx = null;
		try (Session   session = ServiceHibernate.currentSession()) {
			tx = session.beginTransaction();
			// on transfère le nouvel adhérent à la base
			session.merge(unAdh);
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

    /**
     * get  user
     * @param login
     * @return user
     * @throws MonException
     */
	public static UtilisateurEntity getUser(String login) throws MonException {
		UtilisateurEntity unUtilisateur = null;
		try (Session session = ServiceHibernate.currentSession()) {
			TypedQuery query = session.createNamedQuery("UtilisateurEntity.rechercheNom");
			query.setParameter("name", login);
			unUtilisateur = (UtilisateurEntity) query.getSingleResult();
			if (unUtilisateur == null) {
				throw new MonException("Utilisateur Inconnu", "Erreur ");
			}
		} catch(Exception e) {
			throw new MonException("Erreur de lecture", e.getMessage());
		}
		return unUtilisateur;
	}
}
