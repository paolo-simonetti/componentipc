package it.solvingteam.componentipcrestspringmvc.mapper;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import it.solvingteam.componentipcrestspringmvc.dto.ComputerDTO;
import it.solvingteam.componentipcrestspringmvc.dto.message.ComputerInsertMessageDTO;
import it.solvingteam.componentipcrestspringmvc.dto.message.ComputerUpdateMessageDTO;
import it.solvingteam.componentipcrestspringmvc.model.Computer;


@Component
public class ComputerMapper extends AbstractMapper<Computer,ComputerDTO, ComputerInsertMessageDTO, ComputerUpdateMessageDTO> {

	@Override
	public ComputerDTO convertEntityToDto(Computer entity) {
		if (entity==null) {
			return null;			
		}
		
		ComputerDTO dto=new ComputerDTO();
		
		if (entity.getId()!=null) {
			dto.setId(entity.getId().toString());
		}
		
		if(StringUtils.isNotBlank(entity.getBrand())) {
			dto.setBrand(entity.getBrand());
		}
		
		if(StringUtils.isNotBlank(entity.getDescription())) {
			dto.setDescription(entity.getDescription());
		}
		
		if(entity.getPieces()!=null && entity.getPieces().size()>0) {
			entity.getPieces().stream().forEach(piece->{
				dto.addToPiecesIds(piece.getId().toString());
			});
		}
		
		return dto;
	}

	@Override
	public Computer convertDtoToEntity(ComputerDTO dto) {
		if(dto==null) {
			return null;
		}
		
		Computer entity=new Computer();
		
		if (StringUtils.isNotBlank(dto.getId())) {
			entity.setId(Long.parseLong(dto.getId()));
		}
		
		if(StringUtils.isNotBlank(dto.getBrand())) {
			entity.setBrand(dto.getBrand());
		}
		
		if(StringUtils.isNotBlank(dto.getDescription())) {
			entity.setDescription(dto.getDescription());
		}
		
		return entity;
	}

	@Override
	public Computer convertInsertMessageDTOToEntity(ComputerInsertMessageDTO insertMessageDTO) {
		if(insertMessageDTO==null) {
			return null;			
		} 
		
		Computer entity=new Computer();
		
		if(StringUtils.isNotBlank(insertMessageDTO.getBrand())) {
			entity.setBrand(insertMessageDTO.getBrand());
		}
		
		if(StringUtils.isNotBlank(insertMessageDTO.getDescription())) {
			entity.setDescription(insertMessageDTO.getDescription());
		}
				
		return entity;
	}

	@Override
	public Computer convertUpdateMessageDTOToEntity(ComputerUpdateMessageDTO updateMessageDTO) {
		if(updateMessageDTO==null) {
			return null;			
		} 
		
		Computer entity=new Computer();
		
		if(StringUtils.isNotBlank(updateMessageDTO.getId())) {
			entity.setId(Long.parseLong(updateMessageDTO.getId()));
		}
		
		if(StringUtils.isNotBlank(updateMessageDTO.getBrand())) {
			entity.setBrand(updateMessageDTO.getBrand());
		}
		
		if(StringUtils.isNotBlank(updateMessageDTO.getDescription())) {
			entity.setDescription(updateMessageDTO.getDescription());
		}
				
		return entity;
	}

}
