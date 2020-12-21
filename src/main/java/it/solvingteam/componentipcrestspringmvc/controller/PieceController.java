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

import it.solvingteam.componentipcrestspringmvc.dto.PieceDTO;
import it.solvingteam.componentipcrestspringmvc.dto.ResultDTO;
import it.solvingteam.componentipcrestspringmvc.dto.message.PieceInsertMessageDTO;
import it.solvingteam.componentipcrestspringmvc.dto.message.PieceUpdateMessageDTO;
import it.solvingteam.componentipcrestspringmvc.exception.ElementNotFoundException;
import it.solvingteam.componentipcrestspringmvc.exception.NonExistentElementException;
import it.solvingteam.componentipcrestspringmvc.service.PieceService;

@RestController
@RequestMapping("piece")
public class PieceController {
	
	@Autowired
	private PieceService pieceService;
		
	@GetMapping("findById")
	public ResponseEntity<PieceDTO> findById(@RequestParam Long pieceId) {
		 return ResponseEntity.status(HttpStatus.OK).body(pieceService.findById(pieceId));
	}

	@GetMapping("findAll")
	public ResponseEntity<Set<PieceDTO>> findAll() {
		 return ResponseEntity.status(HttpStatus.OK).body(pieceService.findAll());
	}

	@GetMapping("findByComputerId")
	public ResponseEntity<Set<PieceDTO>> findByComputerId(@RequestParam Long computerId) throws ElementNotFoundException {
		return ResponseEntity.status(HttpStatus.OK).body(pieceService.findAllByComputer(computerId));
	} 

	@PostMapping("insert")
	public ResponseEntity<ResultDTO> insert(@Valid @RequestBody PieceInsertMessageDTO pieceInsertMessageDTO) throws NonExistentElementException {
		pieceService.insert(pieceInsertMessageDTO);
		return ResponseEntity.status(HttpStatus.OK).body(new ResultDTO("Piece was successfully inserted"));
	}
	
	@PutMapping("update")
	public ResponseEntity<ResultDTO> update(@Valid @RequestBody PieceUpdateMessageDTO pieceUpdateMessageDTO) throws ElementNotFoundException, NonExistentElementException {
		pieceService.update(pieceUpdateMessageDTO);
		return ResponseEntity.status(HttpStatus.OK).body(new ResultDTO("Piece was successfully updated"));
	}
	
	@DeleteMapping("delete")
	public ResponseEntity<ResultDTO> delete(@RequestParam Long pieceId) throws ElementNotFoundException {
		pieceService.remove(pieceId);
		return ResponseEntity.status(HttpStatus.OK).body(new ResultDTO("Piece was successfully deleted"));
	}

	
}
