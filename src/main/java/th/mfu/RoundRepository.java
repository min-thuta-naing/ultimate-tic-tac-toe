package th.mfu;

import org.springframework.data.repository.CrudRepository;

import th.mfu.domain.Round;

public interface RoundRepository extends CrudRepository<Round, Long> {
    
}
