package it.solvingteam.componentipcrestspringmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.solvingteam.componentipcrestspringmvc.model.Computer;

public interface ComputerRepository extends JpaRepository<Computer, Long> {

	@Query("from Computer c left join fetch c.pieces p where p.id=?1")
	public Computer findByPiece (Long pieceId);
	
	@Query("from Computer c left join fetch c.pieces p where c.id=?1")
	public Computer findByIdWithPieces (Long pieceId);
}
