package it.solvingteam.componentipcrestspringmvc.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.solvingteam.componentipcrestspringmvc.dto.ComputerDTO;
import it.solvingteam.componentipcrestspringmvc.dto.PieceDTO;
import it.solvingteam.componentipcrestspringmvc.dto.message.ComputerInsertMessageDTO;
import it.solvingteam.componentipcrestspringmvc.dto.message.ComputerUpdateMessageDTO;
import it.solvingteam.componentipcrestspringmvc.exception.ElementNotFoundException;
import it.solvingteam.componentipcrestspringmvc.exception.NonExistentElementException;
import it.solvingteam.componentipcrestspringmvc.mapper.ComputerMapper;
import it.solvingteam.componentipcrestspringmvc.mapper.PieceMapper;
import it.solvingteam.componentipcrestspringmvc.model.Computer;
import it.solvingteam.componentipcrestspringmvc.model.Piece;
import it.solvingteam.componentipcrestspringmvc.repository.ComputerRepository;
import it.solvingteam.componentipcrestspringmvc.repository.PieceRepository;

@Service
public class ComputerService {
	
	@Autowired
	private ComputerRepository computerRepository;
	

	@Autowired
	private PieceRepository pieceRepository;
	
	@Autowired
	private ComputerMapper computerMapper;
	
	@Autowired
	private PieceService pieceService;
	
	@Autowired
	private PieceMapper pieceMapper;
	
	public ComputerDTO findById(Long id) {
		return computerMapper.convertEntityToDto(computerRepository.findById(id).get());
	}
	
	public Set<ComputerDTO> findAll() {
		return computerMapper.convertEntityToDto(computerRepository.findAll().stream().collect(Collectors.toSet()));
	}
	
	public void insert(ComputerInsertMessageDTO computerInsertMessageDTO) throws NonExistentElementException {
		Computer computer = computerMapper.convertInsertMessageDTOToEntity(computerInsertMessageDTO);
		for(String pieceId : computerInsertMessageDTO.getPiecesIds()) {
			PieceDTO pieceDTO= pieceService.findByIdWithComputer(Long.parseLong(pieceId));
			if(pieceDTO!=null) {
				computer.addToPieces(pieceMapper.convertDtoToEntity(pieceDTO));
				computerRepository.save(computer);				
				Piece piece=pieceMapper.convertDtoToEntity(pieceDTO);
				piece.setComputer(computer);
				pieceRepository.save(piece);
			} else {
				throw new NonExistentElementException("One of the selected pieces was not found in the persistence context");
			}
		}
	}
	
	public void update(ComputerUpdateMessageDTO computerUpdateMessageDTO) throws ElementNotFoundException, NonExistentElementException {
		if (StringUtils.isNotBlank(computerUpdateMessageDTO.getId())) {
			Computer computerToBeUpdated=computerRepository.findByIdWithPieces(Long.parseLong(computerUpdateMessageDTO.getId()));
			if(computerToBeUpdated!=null) {
				computerToBeUpdated.getPieces().stream().forEach(piece-> {
					piece.setComputer(null);
					pieceRepository.save(piece);
				});
				computerToBeUpdated.getPieces().clear();
				Computer computer = computerMapper.convertUpdateMessageDTOToEntity(computerUpdateMessageDTO);
				for(String pieceId : computerUpdateMessageDTO.getPiecesIds()) {
					Piece piece=pieceRepository.findById(Long.parseLong(pieceId)).get();
					if(piece!=null) {
						computer.addToPieces(piece);
						piece.setComputer(computer);
						pieceRepository.save(piece);
					} else {
						throw new NonExistentElementException("One of the selected pieces was not found in the persistence context");
					}
				}

				computerRepository.save(computerMapper.convertUpdateMessageDTOToEntity(computerUpdateMessageDTO));							
			
			} else {
				throw new NonExistentElementException("The selected computer was not found in the persistence context");
			}
		} else {
			throw new ElementNotFoundException("Computer id was not found");
		}
	}
	
	public void remove(Long id) throws ElementNotFoundException {
		if (this.findById(id)!=null) {
			computerRepository.delete(computerRepository.findById(id).get());
		} else {
			throw new ElementNotFoundException("The selected computer was not found in the persistence context");
		}
	}
	
	public ComputerDTO findByPiece(Long pieceId) throws ElementNotFoundException {
		if(pieceId!=null) {
			if(pieceRepository.findById(pieceId)!=null) {
				return computerMapper.convertEntityToDto(computerRepository.findByPiece(pieceId));
			} else {
				throw new ElementNotFoundException("The selected piece was not found in the persistence context");
			}
		} else {
			throw new ElementNotFoundException("Piece id was not found");
		}
	}
}
