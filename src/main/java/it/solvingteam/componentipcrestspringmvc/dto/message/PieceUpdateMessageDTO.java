package it.solvingteam.componentipcrestspringmvc.dto.message;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class PieceUpdateMessageDTO {

	@Positive
	private String id;
	
	@NotBlank
	private String brand;
	
	@NotBlank
	private String code;
	
	@NotBlank
	private String description;
	
	private String computerId;
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getComputerId() {
		return computerId;
	}

	public void setComputerId(String computerId) {
		this.computerId = computerId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
