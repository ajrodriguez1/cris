package es.upm.dit.apsv.webLab.dao;

import java.util.List;
import java.util.Collection;

import es.upm.dit.apsv.webLab.model.Publication;
import es.upm.dit.apsv.webLab.dao.PublicationDAOImplementation;

public class PublicationDAO {
	PublicationDAOImplementation pdaoi;
	
	public PublicationDAO () {
		this.pdaoi = PublicationDAOImplementation.getInstance();
	}
	
	/**
	 * Insert a new publication
	 * 
	 * @param publication Data of the publication to insert
	 * @return True if the publication was inserted correctly
	 */
	public boolean create (Publication publication) {
		return this.pdaoi.create(publication);
	}
	
	/**
	 * Look for a publication by his Id
	 * 
	 * @param publicationId 
	 * @return Publication information
	 */
	public Publication read (String publicationId) {
		return this.pdaoi.read(publicationId);
	}
	
	/**
	 * Update the information of a publication
	 * 
	 * @param publication Publication information to update
	 * @return True if the procedure was right
	 */
	public boolean update (Publication publication) {
		return this.pdaoi.update(publication);
	}
	
	/**
	 * Delete a publication
	 * 
	 * @param publication to be deleted
	 * @return True if the procedure was right
	 */
	public boolean delete (Publication publication) {
		return this.pdaoi.delete(publication);
	}

	/**
	 * Get all the database information
	 * 
	 * @return All publications
	 */
	public List<Publication> readAll (){
		return this.pdaoi.readAll();
	}
	
	/**
	 * Look for all the publications whose ids have been provided
	 * 
	 * @param ids List of publications ids
	 * @return List with all the publications ids requested
	 */
	public List<Publication> parsePublications (Collection<String> ids){
		return this.pdaoi.parsePublications(ids);
	}
}