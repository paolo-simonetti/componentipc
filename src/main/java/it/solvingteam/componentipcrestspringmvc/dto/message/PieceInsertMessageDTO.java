package it.solvingteam.componentipcrestspringmvc.dto.message;

import javax.validation.constraints.NotBlank;

public class PieceInsertMessageDTO {

	@NotBlank
	private String brand;
	
	@NotBlank
	private String code;
	
	@NotBlank
	private String description;
	
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

	
	
}
