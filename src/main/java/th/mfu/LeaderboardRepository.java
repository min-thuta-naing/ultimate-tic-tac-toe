package th.mfu;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import th.mfu.domain.Leaderboard;

public interface LeaderboardRepository extends JpaRepository<Leaderboard, Long>{
    @Query("SELECT l FROM Leaderboard l LEFT JOIN FETCH l.player")
    public Iterable<Leaderboard> findAllWithPlayers();
}
