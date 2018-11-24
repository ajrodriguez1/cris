package es.upm.dit.apsv.webLab.model;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;

import java.util.ArrayList;
import java.util.List;

@Entity (name = "Researcher")
public class Researcher {
	// Attributes
	@Id
	private String id;
	
	private String name, lastName, email, password, scopusUrl, eid;
	
	@ElementCollection(fetch=FetchType.EAGER)
	private List<String> publications;
	
	public Researcher () {
		super();
		// Initialize only collection variables
		this.publications = new ArrayList<String>();
	}
	
	// ******************************************************
	// 						Getters Methods
	// ******************************************************
	public String getId () {
		return this.id;
	}
	
	public String getName () {
		return this.name;
	}
	
	public String getLasName () {
		return this.lastName;
	}
	
	public String getEmail () {
		return this.email;
	}
	
	public String getPassword () {
		return this.password;
	}
	
	public String getScopusUrl () {
		return this.scopusUrl;
	}
	
	public String getEid () {
		return this.eid;
	}
	
	public List<String> getPublications () {
		return this.publications;
	}
	
	// ******************************************************
	// 						Setters Methods
	// ******************************************************
	public void setId (String id) {
		this.id = id;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	public void setLastName (String lastName) {
		this.lastName = lastName;
	}
	
	public void setEmail (String email) {
		this.email = email;
	}
	
	public void setPassword (String password) {
		this.password = password;
	}
	
	public void setScopusUrl (String scopusUrl) {
		this.scopusUrl = scopusUrl;
	}
	
	public void setEid (String eid) {
		this.eid = eid;
	}
	
	public void setPublications (List<String> publications) {
		this.publications = publications;
	}
}