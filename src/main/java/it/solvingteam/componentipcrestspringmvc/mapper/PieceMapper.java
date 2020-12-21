package it.solvingteam.componentipcrestspringmvc.mapper;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import it.solvingteam.componentipcrestspringmvc.dto.PieceDTO;
import it.solvingteam.componentipcrestspringmvc.dto.message.PieceInsertMessageDTO;
import it.solvingteam.componentipcrestspringmvc.dto.message.PieceUpdateMessageDTO;
import it.solvingteam.componentipcrestspringmvc.model.Piece;

@Component
public class PieceMapper extends AbstractMapper<Piece, PieceDTO, PieceInsertMessageDTO, PieceUpdateMessageDTO> {

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

	@Override
	public Piece convertInsertMessageDTOToEntity(PieceInsertMessageDTO insertMessageDTO) {
		if (insertMessageDTO==null) {			
			return null;
		}
		
		Piece entity = new Piece();
		
		if(StringUtils.isNotBlank(insertMessageDTO.getBrand())) {
			entity.setBrand(insertMessageDTO.getBrand());			
		}
		
		if(StringUtils.isNotBlank(insertMessageDTO.getCode())) {
			entity.setCode(insertMessageDTO.getCode());
		}
		
		if(StringUtils.isNotBlank(insertMessageDTO.getDescription())) {
			entity.setDescription(insertMessageDTO.getDescription());
		}
		
		return entity;
	}

	@Override
	public Piece convertUpdateMessageDTOToEntity(PieceUpdateMessageDTO updateMessageDTO) {
		if(updateMessageDTO==null) {
			return null;			
		}
		
		Piece entity=new Piece();
		
		if(StringUtils.isNotBlank(updateMessageDTO.getId())) {
			entity.setId(Long.parseLong(updateMessageDTO.getId()));
		}

		if(StringUtils.isNotBlank(updateMessageDTO.getBrand())) {
			entity.setBrand(updateMessageDTO.getBrand());			
		}
		
		if(StringUtils.isNotBlank(updateMessageDTO.getCode())) {
			entity.setCode(updateMessageDTO.getCode());
		}
		
		if(StringUtils.isNotBlank(updateMessageDTO.getDescription())) {
			entity.setDescription(updateMessageDTO.getDescription());
		}

		return entity;
	}
	
	

}
