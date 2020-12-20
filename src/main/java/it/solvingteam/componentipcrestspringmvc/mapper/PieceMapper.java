package it.solvingteam.componentipcrestspringmvc.mapper;

import org.apache.commons.lang3.StringUtils;

import it.solvingteam.componentipcrestspringmvc.dto.PieceDTO;
import it.solvingteam.componentipcrestspringmvc.model.Piece;

public class PieceMapper extends AbstractMapper<Piece, PieceDTO> {

	@Override
	public PieceDTO convertEntityToDto(Piece entity) {
		if (entity==null) {
			return null;			
		}
		
		PieceDTO dto=new PieceDTO();
		
		if (entity.getId()!=null) {
			dto.setId(entity.getId().toString());
		}
		
		if(StringUtils.isNotBlank(entity.getBrand())) {
			dto.setBrand(entity.getBrand());
		}
		
		if(StringUtils.isNotBlank(entity.getCode())) {
			dto.setCode(entity.getCode());
		}
		
		if(StringUtils.isNotBlank(entity.getDescription())) {
			dto.setDescription(entity.getDescription());
		}
		
		if (entity.getComputer()!=null) {
			dto.setComputerId(entity.getComputer().getId().toString());
		}
		
		return dto;
	}

	@Override
	public Piece convertDtoToEntity(PieceDTO dto) {
		if(dto==null) {
			return null;
		}
		
		Piece entity = new Piece();
		
		if (StringUtils.isNotBlank(dto.getId())) {
			entity.setId(Long.parseLong(dto.getId()));
		}
		
		if(StringUtils.isNotBlank(dto.getBrand())) {
			entity.setBrand(dto.getBrand());
		}
		
		if(StringUtils.isNotBlank(dto.getCode())) {
			entity.setCode(dto.getCode());
		}
		
		if(StringUtils.isNotBlank(dto.getDescription())) {
			entity.setDescription(dto.getDescription());
		}
				
		return entity;
	}

}
