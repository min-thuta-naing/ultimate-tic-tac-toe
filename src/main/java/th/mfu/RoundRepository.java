package th.mfu;

import org.springframework.data.repository.CrudRepository;

import th.mfu.domain.Reservation;

public interface RoundORepository extends CrudRepository<Reservation, Long> {
    
}
