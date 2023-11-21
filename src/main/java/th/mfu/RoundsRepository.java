package th.mfu;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import th.mfu.domain.Rounds;

public interface RoundsRepository extends CrudRepository<Rounds,Long> {
     @Modifying
    @Query(value = "ALTER TABLE rounds AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoIncrement();
}
