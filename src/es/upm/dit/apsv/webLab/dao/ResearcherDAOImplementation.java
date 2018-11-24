package es.upm.dit.apsv.webLab.dao;

import org.hibernate.Session;
import java.lang.System;
import es.upm.dit.apsv.webLab.model.Researcher;

//Class with Singleton structure
class ResearcherDAOImplementation {
	private static ResearcherDAOImplementation instance = null;
	private ResearcherDAOImplementation() {}
	public static ResearcherDAOImplementation getInstance() {
	    if( null == instance ) {
	        instance = new ResearcherDAOImplementation();
	    }
	    return instance;
	}
	
	public Researcher create (Researcher researcher) {
		// Create session
		Session session = SessionFactoryService.get().openSession();
		Researcher r = new Researcher();
		try {
	        session.beginTransaction();
	        // Operations
	        session.getTransaction().commit();
	        
	        return r;
		} catch (Exception e) {
            // Handle exceptions
			System.out.println(e);
			return null;
		} finally {
			// Close session
            session.close();
		}
	}
}

