package th.mfu;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import th.mfu.domain.PlayerO;

public interface PlayerORepository extends CrudRepository<PlayerO, Long> {
  
}
