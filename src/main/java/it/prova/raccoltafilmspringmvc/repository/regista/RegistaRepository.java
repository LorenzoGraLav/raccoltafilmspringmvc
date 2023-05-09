package it.prova.raccoltafilmspringmvc.repository.regista;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import it.prova.raccoltafilmspringmvc.model.Regista;

public interface RegistaRepository
		extends PagingAndSortingRepository<Regista, Long>, JpaSpecificationExecutor<Regista>, CustomRegistaRepository {
	
	List<Regista> findByCognomeIgnoreCaseContainingOrNomeIgnoreCaseContainingOrderByNomeAsc(String cognome,
			String nome);
	
	
	@Query("from Regista r join fetch r.films where r.id = ?1")
	Regista findSingleRegistaEager(Long id);
	
	@Query("select r From Regista r left join fetch r.films where r.id=:idRegista")
	Regista findByIdEagher(@Param("idRegista") Long idRegista);

}
