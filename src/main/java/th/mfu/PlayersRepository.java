package th.mfu;

import org.springframework.data.repository.CrudRepository;
import th.mfu.domain.Players;

public interface PlayersRepository extends CrudRepository<Players,Long>{
   
}
