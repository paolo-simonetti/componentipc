package it.solvingteam.componentipcrestspringmvc.dto;

import java.util.HashSet;
import java.util.Set;

public class ComputerDTO {

	private String id;
	
	private String brand;
	
	private String description;

	private Set<String> piecesIds=new HashSet<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public Set<String> getPiecesIds() {
		return piecesIds;
	}

	public void setPiecesIds(Set<String> piecesIds) {
		this.piecesIds = piecesIds;
	}

	public void addToPiecesIds(String pieceId) {
		this.piecesIds.add(pieceId);
	}
	
	public void removeFromPiecesIds(String pieceId) {
		this.piecesIds.remove(pieceId);
	}
	
	public boolean has(String pieceId) {
		return this.piecesIds.contains(pieceId);
	}

}
