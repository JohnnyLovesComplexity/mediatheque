package com.epul.dao;

import com.epul.meserreurs.MonException;
import com.epul.metier.OeuvrepretEntity;
import com.epul.metier.OeuvreventeEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.persistence.TypedQuery;
import java.io.Closeable;
import java.util.List;

/**
 * Service that manage the link between the web application (DAO) and the database.
 */
public class ServiceOeuvreDAO {
	
	/**
	 * List all the masterpieces (prêt).
	 * @return A list of the masterpieces.
	 */
	public List<OeuvrepretEntity> listOeuvrePret() {
		return listOeuvre(OeuvrepretEntity.class, "titreOeuvrepret");
	}
	
	/**
	 * List all the masterpieces (vente).
	 * @return A list of the masterpieces.
	 */
	public List<OeuvreventeEntity> listOeuvreVente() {
		return listOeuvre(OeuvreventeEntity.class, "titreOeuvrevente");
	}
	
	/**
	 * List all the masterpieces (vente).
	 * @param <T> Generic type, must be either `OeuvrepretEntity` or `OeuvreventeEntity`.
	 * @param clazz The class of the generic type `T`.
	 * @param attributeToOrder The attribute of the object that will be used to sort the list. If null, the list is not
	 *                         sorted.
	 * @return A list of the masterpieces.
	 */
	private <T> List<T> listOeuvre(@NotNull Class<T> clazz, @Nullable String attributeToOrder) {
		List<T> oeuvres = null;
		String rawQuery = "SELECT o FROM " + clazz.getSimpleName() + " o" + (attributeToOrder != null ? " ORDER BY o." + attributeToOrder : "");
		
		try (Session session = ServiceHibernate.currentSession()) {
			TypedQuery<T> query = session.createQuery(rawQuery, clazz);
			oeuvres = query.getResultList();
		} catch (HibernateException ex) {
			throw new MonException("Impossible d'accèder à la SessionFactory: ", ex.getMessage());
		}
		
		return oeuvres;
	}
	/**
	 * List all the masterpieces (vente).
	 * @param <T> Generic type, must be either `OeuvrepretEntity` or `OeuvreventeEntity`.
	 * @param clazz The class of the generic type `T`.
	 * @return A list of the masterpieces.
	 */
	private <T> List<T> listOeuvre(@NotNull Class<T> clazz) {
		return listOeuvre(clazz, null);
	}
	
	/**
	 * Fetch the object associated to the identifier `id`.
	 * @param id The identifier of the object to fetch.
	 * @return Return the masterpiece associated to `id`, or `null` if not found.
	 */
	public OeuvrepretEntity getOeuvrePretById(int id) {
		return getOeuvreById(id, OeuvrepretEntity.class);
	}
	
	/**
	 * Fetch the object associated to the identifier `id`.
	 * @param id The identifier of the object to fetch.
	 * @return Return the masterpiece associated to `id`, or `null` if not found.
	 */
	public OeuvreventeEntity getOeuvreVenteById(int id) {
		return getOeuvreById(id, OeuvreventeEntity.class);
	}
	
	/**
	 * Fetch the object associated to the identifier `id`.
	 * @param <T> Generic type, must be either `OeuvrepretEntity` or `OeuvreventeEntity`.
	 * @param id The identifier of the object to fetch.
	 * @param clazz The class of the generic type `T`.
	 * @return Return the masterpiece associated to `id`, or `null` if not found.
	 */
	private <T> T getOeuvreById(int id, @NotNull Class<T> clazz) {
		List<T> oeuvres = null;
		T oeuvre = null;
		String rawQuery = "SELECT o FROM " + clazz.getSimpleName() + " o WHERE o.idAdherent=" + id;
		
		try (Session session = ServiceHibernate.currentSession()) {
			TypedQuery<T> query = session.createQuery(rawQuery, clazz);
			oeuvres = query.getResultList();
			oeuvre = oeuvres.get(0);
		}
		catch (HibernateException ex) {
			throw new MonException("Impossible d'accèder à la SessionFactory: ",  ex.getMessage());
		}
		
		return oeuvre;
	}
	
	/**
	 * Insert a masterpiece in the database.
	 * @param oeuvrePret The instance of the masterpiece to add in the database.
	 */
	public void insertOeuvre(@NotNull OeuvrepretEntity oeuvrePret) {
		insertOeuvreT(oeuvrePret);
	}
	/**
	 * Insert a masterpiece in the database.
	 * @param oeuvreVente The instance of the masterpiece to add in the database.
	 */
	public void insertOeuvre(@NotNull OeuvreventeEntity oeuvreVente) {
		insertOeuvreT(oeuvreVente);
	}
	
	/**
	 * Insert a masterpiece in the database.
	 * @param <T> Generic type, must be either `OeuvrepretEntity` or `OeuvreventeEntity`.
	 * @param oeuvre The instance of the masterpiece to add in the database.
	 */
	private <T> void insertOeuvreT(@NotNull T oeuvre) {
		Transaction tx = null;
		try (Session session = ServiceHibernate.currentSession()) {
			tx = session.beginTransaction();
			
			session.save(oeuvre);
			
			tx.commit();
		} catch (HibernateException ex) {
			ex.printStackTrace();
			if (tx != null)
				tx.rollback();
		} catch (Exception e) {
			throw new MonException("Impossible d'accèder à la SessionFactory: ",  e.getMessage());
		}
	}
	
	/**
	 * Remove a masterpiece from the database.
	 * @param oeuvrePret The masterpiece to remove.
	 */
	public void deleteOeuvre(@NotNull OeuvrepretEntity oeuvrePret) {
		deleteOeuvreT(oeuvrePret);
	}
	/**
	 * Remove a masterpiece from the database.
	 * @param oeuvreVente The masterpiece to remove.
	 */
	public void deleteOeuvre(@NotNull OeuvreventeEntity oeuvreVente) {
		deleteOeuvreT(oeuvreVente);
	}
	
	/**
	 * Remove a masterpiece from the database.
	 * @param <T> Generic type, must be either `OeuvrepretEntity` or `OeuvreventeEntity`.
	 * @param oeuvre The masterpiece to remove.
	 */
	private <T> void deleteOeuvreT(@NotNull T oeuvre) {
		Transaction tx = null;
		
		try (Session session = ServiceHibernate.currentSession()) {
			tx = session.beginTransaction();
			
			session.delete(oeuvre);
			
			tx.commit();
		} catch (HibernateException ex) {
			ex.printStackTrace();
			if (tx != null)
				tx.rollback();
		} catch (Exception e) {
			throw new MonException("Impossible d'accèder à la SessionFactory: ",  e.getMessage());
		}
	}
	
	/**
	 * Update a masterpiece in the database. The identifier in `oeuvrePret` will be used as index to find the original
	 * instance in the database.
	 * @param oeuvrePret The new instance to update, with the corresponding identifier.
	 */
	public void updateOeuvre(@NotNull OeuvrepretEntity oeuvrePret) {
		updateOeuvreT(oeuvrePret);
	}
	/**
	 * Update a masterpiece in the database. The identifier in `oeuvrePret` will be used as index to find the original
	 * instance in the database.
	 * @param oeuvreVente The new instance to update, with the corresponding identifier.
	 */
	public void updateOeuvre(@NotNull OeuvreventeEntity oeuvreVente) {
		updateOeuvreT(oeuvreVente);
	}
	
	/**
	 * Update a masterpiece in the database. The identifier in `oeuvre` will be used as index to find the original
	 * instance in the database.
	 * @param <T> Generic type, must be either `OeuvrepretEntity` or `OeuvreventeEntity`.
	 * @param oeuvre The new instance to update, with the corresponding identifier.
	 */
	private <T> void updateOeuvreT(@NotNull T oeuvre) {
		Transaction tx = null;
		try (Session   session = ServiceHibernate.currentSession()) {
			tx = session.beginTransaction();
			
			session.merge(oeuvre);
			
			tx.commit();
		} catch (HibernateException ex) {
			ex.printStackTrace();
			if (tx != null)
				tx.rollback();
		} catch (Exception e) {
			throw new MonException("Impossible d'accèder à la SessionFactory: ",  e.getMessage());
		}
	}
}
