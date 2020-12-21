package it.solvingteam.componentipcrestspringmvc.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.solvingteam.componentipcrestspringmvc.model.Computer;
import it.solvingteam.componentipcrestspringmvc.model.Piece;

public interface PieceRepository extends JpaRepository<Piece, Long> {
	
	public Set<Piece> findAllByComputer(Computer computer);
	
	@Query("from Piece p left join fetch p.computer c where p.id=?1")
	public Piece findByIdWithComputer(Long id);
	
}
