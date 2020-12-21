package it.solvingteam.componentipcrestspringmvc.controller;

import java.util.NoSuchElementException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import it.solvingteam.componentipcrestspringmvc.dto.ResultDTO;
import it.solvingteam.componentipcrestspringmvc.exception.ElementNotFoundException;
import it.solvingteam.componentipcrestspringmvc.exception.NonExistentElementException;

@ControllerAdvice(basePackages = "it.solvingteam.componentipcrestspringmvc.controller")
public class ExceptionsHandler {
	
    @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity<ResultDTO> handleElementNotFoundException(ElementNotFoundException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResultDTO(e.getMessage()));
    }

    @ExceptionHandler(NonExistentElementException.class)
    public ResponseEntity<ResultDTO> handleNonExistentElementException(ElementNotFoundException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResultDTO(e.getMessage()));
    }
    
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ResultDTO> handleNoSuchElementException(NoSuchElementException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResultDTO("One of the requested elements is not present in the persistence context."));
    }
    
    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<ResultDTO> handleNumberFormatException(NumberFormatException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResultDTO("Expected numbers from the request were not found"));
    }
   
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ResultDTO> handleDataIntegrityViolationException(DataIntegrityViolationException e){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ResultDTO("Forbidden operation: the computer pieces must be deleted first."));
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResultDTO> handleException(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResultDTO(e.getMessage()));
    }
   
}
