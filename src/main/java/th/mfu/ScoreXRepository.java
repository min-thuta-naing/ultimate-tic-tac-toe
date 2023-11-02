package th.mfu;

import org.springframework.data.repository.CrudRepository;

import th.mfu.domain.Reservation;

public interface ScoreXRepository extends CrudRepository<Reservation, Long> {
    
}
