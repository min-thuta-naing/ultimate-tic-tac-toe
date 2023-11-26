package th.mfu;

import th.mfu.domain.Time;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TimeRepository extends CrudRepository<Time,Long>{
   
}
