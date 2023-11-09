package th.mfu;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import th.mfu.domain.PlayerX;

public interface PlayerXRepository extends CrudRepository<PlayerX, Long> {
    /*@Transactional
    @Modifying
    @Query("UPDATE PlayerX p SET p.nameX = :newName WHERE p.id = :id")
    void updateNameById(Long id, String newName);*/
}
