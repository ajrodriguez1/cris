package es.upm.dit.apsv.webLab.dao;

// Class with Singleton structure
public class PublicationDAOImplementation {
	private static PublicationDAOImplementation instance = null;
	private PublicationDAOImplementation() {}
	public static PublicationDAOImplementation getInstance() {
	    if( null == instance ) {
	        instance = new PublicationDAOImplementation();
	    }
	    return instance;
	}
}