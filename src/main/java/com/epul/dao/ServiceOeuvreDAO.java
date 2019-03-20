package com.epul.dao;

import java.util.*;

import com.epul.metier.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import com.epul.meserreurs.*;
import org.hibernate.Transaction;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Service that manage the link between the web application (DAO) and the database.
 */
public class ServiceOeuvreDAO {
	
	/**
	 * List all the masterpieces (prêt).
	 * @return A list of the masterpieces.
	 */
	public List<OeuvrepretEntity> listOeuvrePret() {
		throw new NotImplementedException();
	}
	
	/**
	 * List all the masterpieces (vente).
	 * @return A list of the masterpieces.
	 */
	public List<OeuvrepretEntity> listOeuvreVente() {
		throw new NotImplementedException();
	}
	
	/**
	 * Fetch the object associated to the identifier `id`.
	 * @param id The identifier of the object to fetch.
	 * @return Return the masterpiece associated to `id`, or `null` if not found.
	 */
	public OeuvrepretEntity getOeuvrePretById(int id) {
		throw new NotImplementedException();
	}
	
	/**
	 * Fetch the object associated to the identifier `id`.
	 * @param id The identifier of the object to fetch.
	 * @return Return the masterpiece associated to `id`, or `null` if not found.
	 */
	public OeuvreventeEntity getOeuvreVenteById(int id) {
		throw new NotImplementedException();
	}
	
	/**
	 * Insert a masterpiece in the database.
	 * @param oeuvrePret The instance of the masterpiece to add in the database.
	 */
	public void insertOeuvre(OeuvrepretEntity oeuvrePret) {
		throw new NotImplementedException();
	}
	/**
	 * Insert a masterpiece in the database.
	 * @param oeuvreVente The instance of the masterpiece to add in the database.
	 */
	public void insertOeuvre(OeuvreventeEntity oeuvreVente) {
		throw new NotImplementedException();
	}
	
	public void deleteOeuvre(OeuvrepretEntity oeuvrePret) {
		throw new NotImplementedException();
	}
	public void deleteOeuvre(OeuvreventeEntity oeuvreVente) {
		throw new NotImplementedException();
	}
	
	public void updateOeuvre(OeuvrepretEntity oeuvrePret) {
		throw new NotImplementedException();
	}
	public void updateOeuvre(OeuvreventeEntity oeuvreVente) {
		throw new NotImplementedException();
	}
}
