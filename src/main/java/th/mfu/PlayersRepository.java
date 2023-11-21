package th.mfu;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import th.mfu.domain.Players;

public interface PlayersRepository extends CrudRepository<Players,Long>{
    // @Query(value = "ALTER TABLE players AUTO_INCREMENT = 1000", nativeQuery = true)
    // void setInitialAutoIncrementValue();
    // @Modifying
    // @Query(value = "ALTER TABLE players AUTO_INCREMENT = 1", nativeQuery = true)
    // void resetAutoIncrement();
}
