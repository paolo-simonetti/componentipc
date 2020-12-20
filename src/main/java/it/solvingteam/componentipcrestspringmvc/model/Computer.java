package it.solvingteam.componentipcrestspringmvc.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Computer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String brand;
	
	private String description;
	
	@OneToMany(mappedBy="computer")
	private Set<Piece> pieces;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Piece> getPieces() {
		return pieces;
	}

	public void setPieces(Set<Piece> pieces) {
		this.pieces = pieces;
	}
	
	public void addToPieces(Piece piece) {
		this.pieces.add(piece);
	}
	
	public void removeFromPieces(Piece piece) {
		this.pieces.remove(piece);
	}
	
	public boolean has(Piece piece) {
		return this.pieces.contains(piece);
	}
	
}
