package it.solvingteam.componentipcrestspringmvc.mapper;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractMapper<Entity,DTO> {

	public abstract DTO convertEntityToDto(Entity entity);
	
	public abstract Entity convertDtoToEntity(DTO dto);
	
	public Set<DTO> convertEntityToDto(Set<Entity> entities) {
        if (entities == null) {
            return null;
        }

        Set<DTO> dtos = new HashSet<>();

        for (Entity entity : entities) {
            dtos.add(convertEntityToDto(entity));
        }

        return dtos;
    }

    public Set<Entity> convertDtoToEntity(Set<DTO> dtos) {
        if (dtos == null) {
            return null;
        }

        Set<Entity> entities = new HashSet<>();

        for (DTO dto : dtos) {
            entities.add(convertDtoToEntity(dto));
        }

        return entities;
    }

	
}
