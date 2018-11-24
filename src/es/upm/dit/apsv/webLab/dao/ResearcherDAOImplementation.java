package es.upm.dit.apsv.webLab.dao;

import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import java.lang.System;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import es.upm.dit.apsv.webLab.model.Researcher;

//Class with Singleton structure
public class ResearcherDAOImplementation {
	private static ResearcherDAOImplementation instance = null;
	private ResearcherDAOImplementation() {}
	public static ResearcherDAOImplementation getInstance() {
	    if( null == instance ) {
	        instance = new ResearcherDAOImplementation();
	    }
	    return instance;
	}
	
	/**
	 * Insert a new researcher
	 * 
	 * @param researcher Data of the researcher to insert
	 * @return True if the researcher was inserted correctly
	 */
	public boolean create (Researcher researcher) {
		// Create session
		Session session = SessionFactoryService.get().openSession();
		
		try {
	        session.beginTransaction();
	        
	        // Save a new researcher
	        session.save(researcher);
	        
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
	 * Look for a researcher by his Id
	 * 
	 * @param researcherId 
	 * @return Researcher information
	 */
	public Researcher read (String researcherId) {
		// Create session
		Session session = SessionFactoryService.get().openSession();
		
		// Auxiliary variable
		Researcher researcher;
		
		try {
	        session.beginTransaction();
	        
	        // Launch query
	        researcher = (Researcher) session.get("Researcher", researcherId);
	        
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
		
		return researcher;
	}
	
	
	/**
	 * Update the information of a researcher
	 * 
	 * @param researcher Researcher information to update
	 * @return True if the procedure was right
	 */
	public boolean update (Researcher researcher) {
		// Create session
		Session session = SessionFactoryService.get().openSession();
		
		try {
	        session.beginTransaction();
	        
	        // Update researcher
	        session.saveOrUpdate(researcher);
	        
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
	 * Delete a researcher
	 * 
	 * @param researcher to be deleted
	 * @return True if the procedure was right
	 */
	public boolean delete (Researcher researcher) {
		// Create session
		Session session = SessionFactoryService.get().openSession();
		
		try {
	        session.beginTransaction();
	        
	        // Delete researcher
	        session.delete(researcher);
	        
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
	 * @return All researchers
	 */
	public List<Researcher> readAll (){
		// Create session
		Session session = SessionFactoryService.get().openSession();
		
		// Auxiliary researchers list
		List<Researcher> researchers = new ArrayList<Researcher>();
		
		try {
	        session.beginTransaction();
	        
	        // Select all
	        researchers = (List<Researcher>) session.createQuery("SELECT * FROM Researcher").list();
	        
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
		
		return researchers;
	}
	
	/**
	 * Get researcher information looking for email and password
	 * 
	 * @param email Researcher email
	 * @param password Researcher password
	 * @return Researcher if this was found, else null
	 */
	public Researcher readAsUser (String email, String password) {
		// Create session
		Session session = SessionFactoryService.get().openSession();
		
		// Auxiliary researchers list
		Researcher researcher;
		
		try {
	        session.beginTransaction();
	        
	        // Select filter by email and password
	        researcher = (Researcher) session.createQuery(
	        		"SELECT * "
	        		+ "FROM Researcher r "
	        		+ "WHERE r.email=:email"
	        		+ "AND r.passord=:password")
	        		.setParameter("email", email)
	        		.setParameter("password", password)
	        		.uniqueResult();
	        
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
		
		return researcher;
	}
	
	/**
	 * Look for all the researchers whose ids have been provided
	 * 
	 * @param ids List of researchers ids
	 * @return List with all the researchers ids requested
	 */
	public List<Researcher> parseResearchers (Collection<String> ids) {
		// Create session
		Session session = SessionFactoryService.get().openSession();
		
		// Auxiliary researchers list
		List<Researcher> researchers = new ArrayList<Researcher>();
		
		try {
	        session.beginTransaction();
	        
	        // Look for each id requested
	        ids.forEach((researcherId) -> researchers.add((Researcher) this.read(researcherId)));
	        
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
		
		return researchers;
	}
}

