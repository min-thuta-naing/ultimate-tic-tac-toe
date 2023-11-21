package th.mfu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.mfu.domain.Players;

@Service
public class GameService {
    @Autowired
    private PlayersRepository playersRepository; 
    public Iterable<Players>getLastTwoPlayers(){
        return playersRepository.findTop2ByOrderByCreatedDateDesc();
    }
}
