package it.solvingteam.componentipcrestspringmvc.dto.message;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

public class ComputerUpdateMessageDTO {

	@Positive
	private String id;
	
	@NotBlank
	private String brand;
	
	@NotBlank
	private String description;

	@NotEmpty
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

	public void addToPieces(String pieceId) {
		this.piecesIds.add(pieceId);
	}
	
	public void removeFromPieces(String pieceId) {
		this.piecesIds.remove(pieceId);
	}
	
	public boolean has(String pieceId) {
		return this.piecesIds.contains(pieceId);
	}
	
}

