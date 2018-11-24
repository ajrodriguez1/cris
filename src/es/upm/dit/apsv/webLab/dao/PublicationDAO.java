package es.upm.dit.apsv.webLab.dao;

import es.upm.dit.apsv.webLab.model.Publication;

public class PublicationDAO {
	public Publication create (Publication publication) {
		return new Publication();
	}
	
	public Publication read (String publicationId) {
		return null;
	}
}