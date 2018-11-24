package es.upm.dit.apsv.webLab.dao;

import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import java.lang.System;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import es.upm.dit.apsv.webLab.model.Publication;

//Class with Singleton structure
public class PublicationDAOImplementation {
	private static PublicationDAOImplementation instance = null;
	private PublicationDAOImplementation() {}
	public static PublicationDAOImplementation getInstance() {
	    if( null == instance ) {
	        instance = new PublicationDAOImplementation();
	    }
	    return instance;
	}
	
	/**
	 * Insert a new publication
	 * 
	 * @param publication Data of the publication to insert
	 * @return True if the publication was inserted correctly
	 */
	public boolean create (Publication publication) {
		// Create session
		Session session = SessionFactoryService.get().openSession();
		
		try {
	        session.beginTransaction();
	        
	        // Save a new publication
	        session.save(publication);
	        
	        // Commit changes
	        session.getTransaction().commit();
	        
		} catch (Exception e) {
            // Handle exceptions
			// Carry out a rollback for data security reasons
			if ( session.getTransaction().getStatus() == TransactionStatus.ACTIVE
		            || session.getTransaction().getStatus() == TransactionStatus.MARKED_ROLLBACK ) {
		        
				session.getTransaction().rollback();
		    }
			
			// Close session
            session.close();
			
			// Print problem information
			System.out.println(e);
			
			return false;
			
		} finally {
			// Close session
            session.close();
		}
		
		return true;
	}
	
	/**
	 * Look for a publication by his Id
	 * 
	 * @param publicationId 
	 * @return Publication information
	 */
	public Publication read (String publicationId) {
		// Create session
		Session session = SessionFactoryService.get().openSession();
		
		// Auxiliary variable
		Publication publication;
		
		try {
	        session.beginTransaction();
	        
	        // Launch query
	        publication = (Publication) session.get("Publication", publicationId);
	        
		} catch (Exception e) {
            // Handle exceptions		
			// Close session
            session.close();
			
			// Print problem information
			System.out.println(e);
			
			return null;
			
		} finally {
			// Close session
            session.close();
		}		
		
		return publication;
	}
	
	
	/**
	 * Update the information of a publication
	 * 
	 * @param publication Publication information to update
	 * @return True if the procedure was right
	 */
	public boolean update (Publication publication) {
		// Create session
		Session session = SessionFactoryService.get().openSession();
		
		try {
	        session.beginTransaction();
	        
	        // Update publication
	        session.saveOrUpdate(publication);
	        
	        // Commit changes
	        session.getTransaction().commit();
	        
		} catch (Exception e) {
            // Handle exceptions
			// Carry out a rollback for data security reasons
			if ( session.getTransaction().getStatus() == TransactionStatus.ACTIVE
		            || session.getTransaction().getStatus() == TransactionStatus.MARKED_ROLLBACK ) {
		        
				session.getTransaction().rollback();
		    }
			
			// Close session
            session.close();
			
			// Print problem information
			System.out.println(e);
			
			return false;
			
		} finally {
			// Close session
            session.close();
		}
		
		return true;
	}
	
	/**
	 * Delete a publication
	 * 
	 * @param publication to be deleted
	 * @return True if the procedure was right
	 */
	public boolean delete (Publication publication) {
		// Create session
		Session session = SessionFactoryService.get().openSession();
		
		try {
	        session.beginTransaction();
	        
	        // Delete publication
	        session.delete(publication);
	        
	        // Commit changes
	        session.getTransaction().commit();
	        
		} catch (Exception e) {
            // Handle exceptions
			// Carry out a rollback for data security reasons
			if ( session.getTransaction().getStatus() == TransactionStatus.ACTIVE
		            || session.getTransaction().getStatus() == TransactionStatus.MARKED_ROLLBACK ) {
		        
				session.getTransaction().rollback();
		    }
			
			// Close session
            session.close();
			
			// Print problem information
			System.out.println(e);
			
			return false;
			
		} finally {
			// Close session
            session.close();
		}
		
		return true;
	}
	
	/**
	 * Get all the database information
	 * 
	 * @return All publications
	 */
	public List<Publication> readAll (){
		// Create session
		Session session = SessionFactoryService.get().openSession();
		
		// Auxiliary publications list
		List<Publication> publications = new ArrayList<Publication>();
		
		try {
	        session.beginTransaction();
	        
	        // Select all
	        publications = (List<Publication>) session.createQuery("SELECT * FROM Publication").list();
	        
		} catch (Exception e) {
            // Handle exceptions			
			// Close session
            session.close();
			
			// Print problem information
			System.out.println(e);
			
			return null;
			
		} finally {
			// Close session
            session.close();
		}
		
		return publications;
	}
	
	/**
	 * Look for all the publications whose ids have been provided
	 * 
	 * @param ids List of publications ids
	 * @return List with all the publications ids requested
	 */
	public List<Publication> parsePublications (Collection<String> ids) {
		// Create session
		Session session = SessionFactoryService.get().openSession();
		
		// Auxiliary publications list
		List<Publication> publications = new ArrayList<Publication>();
		
		try {
	        session.beginTransaction();
	        
	        // Look for each id requested
	        ids.forEach((publicationId) -> publications.add((Publication) this.read(publicationId)));
	        
		} catch (Exception e) {
            // Handle exceptions			
			// Close session
            session.close();
			
			// Print problem information
			System.out.println(e);
			
			return null;
			
		} finally {
			// Close session
            session.close();
		}
		
		return publications;
	}
}

