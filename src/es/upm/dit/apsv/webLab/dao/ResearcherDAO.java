package es.upm.dit.apsv.webLab.dao;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

import es.upm.dit.apsv.webLab.model.Researcher;
import es.upm.dit.apsv.webLab.dao.ResearcherDAOImplementation;

public class ResearcherDAO{
	ResearcherDAOImplementation rdaoi;
	
	public ResearcherDAO () {
		this.rdaoi = ResearcherDAOImplementation.getInstance();
	}
	
	public Researcher create (Researcher researcher) {
		return rdaoi.create(researcher);
	}
	
	public Researcher read (String researcherId) {
		return null;
	}
	
	public Researcher update (Researcher researcherId) {
		return null;
	}
	
	public Researcher delete (Researcher researcherId) {
		return null;
	}
	
	public List<Researcher> readAll (){
		return null;
	}
	
	public Researcher readAsUser (String email, String password) {
		return null;
	}
	
	public List<Researcher> parseResearchers (Collection<String> ids) {
		return null;
	}
	
	public Researcher parseResearchers (String researcherId) {
		return null;
	}
}