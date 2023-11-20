package th.mfu;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import th.mfu.domain.Rounds;

public interface RoundsRepository extends CrudRepository<Rounds,Long> {

    Iterable<Rounds> findByWinner_Id(Long playerId);

}
