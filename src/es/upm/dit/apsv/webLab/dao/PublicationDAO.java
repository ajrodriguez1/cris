package es.upm.dit.apsv.webLab.dao;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

import es.upm.dit.apsv.webLab.model.Publication;
import es.upm.dit.apsv.webLab.dao.PublicationDAOImplementation;

public class PublicationDAO {
	PublicationDAOImplementation pdaoi;
	
	public PublicationDAO () {
		this.pdaoi = PublicationDAOImplementation.getInstance();
	}
	
	public Publication create (Publication publication) {
		return null;
	}
	
	public Publication read (String publicationId) {
		return null;
	}
	
	public Publication update ( Publication publication ) {
		return null;
	}
	
	public Publication delete ( Publication publication ) {
		return null;
	}

	public List<Publication> readAll (){
		return null;
	}
	
	public List<Publication> parsePublications (Collection<String> ids){
		return null;
	}
}