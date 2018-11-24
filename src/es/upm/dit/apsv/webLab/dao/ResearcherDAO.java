package es.upm.dit.apsv.webLab.dao;

import java.util.List;
import java.util.Collection;

import es.upm.dit.apsv.webLab.model.Researcher;
import es.upm.dit.apsv.webLab.dao.ResearcherDAOImplementation;

public class ResearcherDAO{
	ResearcherDAOImplementation rdaoi;
	
	public ResearcherDAO () {
		this.rdaoi = ResearcherDAOImplementation.getInstance();
	}
	
	/**
	 * Insert a new researcher
	 * 
	 * @param researcher Data of the researcher to insert
	 * @return True if the researcher was inserted correctly
	 */
	public boolean create (Researcher researcher) {
		return this.rdaoi.create(researcher);
	}
	
	/**
	 * Look for a researcher by his Id
	 * 
	 * @param researcherId 
	 * @return Researcher information
	 */
	public Researcher read (String researcherId) {
		return this.rdaoi.read(researcherId);
	}
	
	/**
	 * Update the information of a researcher
	 * 
	 * @param researcher Researcher information to update
	 * @return True if the procedure was right
	 */
	public boolean update (Researcher researcher) {
		return this.rdaoi.update(researcher);
	}
	
	/**
	 * Delete a researcher
	 * 
	 * @param researcher to be deleted
	 * @return True if the procedure was right
	 */
	public boolean delete (Researcher researcher) {
		return this.rdaoi.delete(researcher);
	}
	
	/**
	 * Get all the database information
	 * 
	 * @return All researchers
	 */
	public List<Researcher> readAll (){
		return this.rdaoi.readAll();
	}
	
	/**
	 * Get researcher information looking for email and password
	 * 
	 * @param email Researcher email
	 * @param password Researcher password
	 * @return Researcher if this was found, else null
	 */
	public Researcher readAsUser (String email, String password) {
		return this.rdaoi.readAsUser(email, password);
	}
	
	/**
	 * Look for all the researchers whose ids have been provided
	 * 
	 * @param ids List of researchers ids
	 * @return List with all the researchers ids requested
	 */
	public List<Researcher> parseResearchers (Collection<String> ids) {
		return this.rdaoi.parseResearchers(ids);
	}
}