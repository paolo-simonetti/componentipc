package it.solvingteam.componentipcrestspringmvc.mapper;

import org.apache.commons.lang3.StringUtils;

import it.solvingteam.componentipcrestspringmvc.dto.ComputerDTO;
import it.solvingteam.componentipcrestspringmvc.model.Computer;

public class ComputerMapper extends AbstractMapper<Computer,ComputerDTO> {

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
		
		if(entity.getPieces().size()>0) {
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

}
