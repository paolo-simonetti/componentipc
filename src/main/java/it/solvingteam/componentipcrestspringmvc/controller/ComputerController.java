package it.solvingteam.componentipcrestspringmvc.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.solvingteam.componentipcrestspringmvc.dto.ComputerDTO;
import it.solvingteam.componentipcrestspringmvc.dto.ResultDTO;
import it.solvingteam.componentipcrestspringmvc.dto.message.ComputerInsertMessageDTO;
import it.solvingteam.componentipcrestspringmvc.dto.message.ComputerUpdateMessageDTO;
import it.solvingteam.componentipcrestspringmvc.exception.ElementNotFoundException;
import it.solvingteam.componentipcrestspringmvc.exception.NonExistentElementException;
import it.solvingteam.componentipcrestspringmvc.service.ComputerService;

@RestController
@RequestMapping("computer")
public class ComputerController {

	@Autowired
	private ComputerService computerService;
	
	@GetMapping("findById")
	public ResponseEntity<ComputerDTO> findById(@RequestParam Long computerId) {
		 return ResponseEntity.status(HttpStatus.OK).body(computerService.findById(computerId));
	}
	
	@GetMapping("findAll")
	public ResponseEntity<Set<ComputerDTO>> findAll() {
		 return ResponseEntity.status(HttpStatus.OK).body(computerService.findAll());
	}
	
	@GetMapping("findByPieceId")
	public ResponseEntity<ComputerDTO> findByPieceId(@RequestParam Long pieceId) throws ElementNotFoundException {
		return ResponseEntity.status(HttpStatus.OK).body(computerService.findByPiece(pieceId));
	} 
	
	
	@PostMapping("insert")
	public ResponseEntity<ResultDTO> insert(@Valid @RequestBody ComputerInsertMessageDTO computerInsertMessageDTO) throws NonExistentElementException {
		computerService.insert(computerInsertMessageDTO);
		return ResponseEntity.status(HttpStatus.OK).body(new ResultDTO("Computer was successfully inserted"));
	}
	
	@PutMapping("update")
	public ResponseEntity<ResultDTO> update(@Valid @RequestBody ComputerUpdateMessageDTO computerUpdateMessageDTO) throws ElementNotFoundException, NonExistentElementException {
		computerService.update(computerUpdateMessageDTO);
		return ResponseEntity.status(HttpStatus.OK).body(new ResultDTO("Computer was successfully updated"));
	}
	
	@DeleteMapping("delete")
	public ResponseEntity<ResultDTO> delete(@RequestParam Long computerId) throws ElementNotFoundException {
		computerService.remove(computerId);
		return ResponseEntity.status(HttpStatus.OK).body(new ResultDTO("Computer was successfully deleted"));
	}

}
