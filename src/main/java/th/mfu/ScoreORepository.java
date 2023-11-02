package th.mfu;

import org.springframework.data.repository.CrudRepository;

import th.mfu.domain.Reservation;

public interface ScoreYRepository extends CrudRepository<Reservation, Long> {
    
}
