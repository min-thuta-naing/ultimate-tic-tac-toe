package th.mfu;

import org.springframework.data.repository.CrudRepository;

import th.mfu.domain.ScoresO;

public interface ScoreORepository extends CrudRepository<ScoresO, Long> {
    
}
