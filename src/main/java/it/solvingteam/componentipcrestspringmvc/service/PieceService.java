package it.solvingteam.componentipcrestspringmvc.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.solvingteam.componentipcrestspringmvc.dto.ComputerDTO;
import it.solvingteam.componentipcrestspringmvc.dto.PieceDTO;
import it.solvingteam.componentipcrestspringmvc.dto.message.PieceInsertMessageDTO;
import it.solvingteam.componentipcrestspringmvc.dto.message.PieceUpdateMessageDTO;
import it.solvingteam.componentipcrestspringmvc.exception.ElementNotFoundException;
import it.solvingteam.componentipcrestspringmvc.mapper.ComputerMapper;
import it.solvingteam.componentipcrestspringmvc.mapper.PieceMapper;
import it.solvingteam.componentipcrestspringmvc.repository.PieceRepository;

@Service
public class PieceService {
	
	@Autowired
	private PieceRepository pieceRepository;
	
	@Autowired
	private ComputerService computerService;
	
	@Autowired
	private PieceMapper pieceMapper;
	
	@Autowired
	private ComputerMapper computerMapper;
	
	public void insert (PieceInsertMessageDTO pieceInsertMessageDTO) {
		pieceRepository.save(pieceMapper.convertInsertMessageDTOToEntity(pieceInsertMessageDTO));
	}
	
	public PieceDTO findById(Long id) {
		return pieceMapper.convertEntityToDto(pieceRepository.findById(id).get());
	}
	
	public PieceDTO findByIdWithComputer(Long id) {
		return pieceMapper.convertEntityToDto(pieceRepository.findByIdWithComputer(id));
	}
	
	public void remove (Long id) throws ElementNotFoundException {
		if (pieceRepository.findById(id).get()!=null) {
			pieceRepository.delete(pieceRepository.findById(id).get());
		} else {
			throw new ElementNotFoundException("Piece was not found in the persistence context");
		}
	}
	
	public void update (PieceUpdateMessageDTO pieceUpdateMessageDTO) throws ElementNotFoundException {
		if (this.findById(Long.parseLong(pieceUpdateMessageDTO.getId()))!=null) {
			pieceRepository.save(pieceMapper.convertDtoToEntity(this.findById(Long.parseLong(pieceUpdateMessageDTO.getId()))));
		} else {
			throw new ElementNotFoundException("Piece was not found in the persistence context");
		}
	}
	
	public Set<PieceDTO> findAll() {
		return pieceMapper.convertEntityToDto(pieceRepository.findAll().stream().collect(Collectors.toSet()));
	}
	
	public Set<PieceDTO> findAllByComputer(Long computerId) throws ElementNotFoundException {
		if (computerId!=null) {
			ComputerDTO computerDTO=computerService.findById(computerId);
			if (computerDTO!=null) {
				return pieceMapper.convertEntityToDto(pieceRepository.findAllByComputer(computerMapper.convertDtoToEntity(computerDTO)));
			} else {
				throw new ElementNotFoundException("The requested computer was not found in the persistence context");
			}
		} else {
			throw new ElementNotFoundException("No id was found on the selected computer");
		}
		
		
	}
	
}
