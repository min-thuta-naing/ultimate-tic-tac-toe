package th.mfu.domain;

import java.util.List;
import java.util.stream.StreamSupport;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.query.criteria.internal.path.ListAttributeJoin;

@Entity
public class Leaderboard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lbId; 
    
    @OneToOne 
    @JoinColumn(name = "player_id")
    private Players player;

    private Long totalRound;
    private Long roundWon;
    private Long roundLost; 

    //constructors 
    public Leaderboard() {
    }
    public Leaderboard(Players player) {
        this.player = player;
    }
    
    //getter setter 
    public Long getLbId() {
        return lbId;
    }
    public void setLbId(Long lbId) {
        this.lbId = lbId;
    }
    public Players getPlayer() {
        return player;
    }
    public void setPlayer(Players player) {
        this.player = player;
    }
    public Long getTotalRound() {
        return totalRound;
    }
    public void setTotalRound(Long totalRound) {
        this.totalRound = totalRound;
    }
    public Long getRoundWon() {
        return roundWon;
    }
    public void setRoundWon(Long roundWon) {
        this.roundWon = roundWon;
    }
    public Long getRoundLost() {
        return roundLost;
    }
    public void setRoundLost(Long roundLost) {
        this.roundLost = roundLost;
    }

    // Additional method to update totalRound, roundWon, and roundLost
   // Additional method to update totalRound, roundWon, and roundLost
    // public void updateStats(Iterable<Rounds> playerRounds) {
    // this.totalRound = StreamSupport.stream(playerRounds.spliterator(), false).count();
    // this.roundWon = StreamSupport.stream(playerRounds.spliterator(), false)
    //         .filter(round -> round.getWinner() != null && round.getWinner().getId().equals(this.player.getId()))
    //         .count();
    // this.roundLost = this.totalRound - this.roundWon;
    //}
    public void updateStats(Iterable<Rounds> playerRounds) {
        System.out.println("Player ID: " + this.player.getId()); // Log player ID for debugging
    
        this.totalRound = StreamSupport.stream(playerRounds.spliterator(), false).count();
        
        System.out.println("Total Rounds: " + this.totalRound); // Log total rounds for debugging
    
        this.roundWon = StreamSupport.stream(playerRounds.spliterator(), false)
                .filter(round -> {
                    Players winner = round.getWinner();
                    System.out.println("Winner ID: " + (winner != null ? winner.getId() : "null")); // Log winner ID for debugging
                    return winner != null && winner.getId().equals(this.player.getId());
                })
                .count();
        
        System.out.println("Rounds Won: " + this.roundWon); // Log rounds won for debugging
    
        this.roundLost = this.totalRound - this.roundWon;
        System.out.println("Rounds Lost: " + this.roundLost); // Log rounds lost for debugging
    }
    
}
