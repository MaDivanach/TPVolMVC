package model;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "passager")
@Embeddable
public class Passager {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPassager")
	@SequenceGenerator(name = "seqPassager", sequenceName = "seq_passager", initialValue = 100, allocationSize = 1)
	@Column(name = "id_passager")
	private Long idPassager;
	@Column(name = "nom_passager", length = 50, nullable = false)
	private String nom;
	@Column(name = "prenom_passager", length = 50)
	private String prenom;
	@OneToMany(mappedBy = "passager")
	private Set<Reservation> reservations;
	
	public Passager() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Embedded
		
	private Adresse adresse;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
}
