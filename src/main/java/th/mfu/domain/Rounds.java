package th.mfu.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Rounds {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO) 
    private Long roundId;

    //@ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "winner_id")
    private String winner;

    // constructor
    public Rounds() {
    }
    public Rounds(Long roundId, String winner) {
        this.roundId = roundId;
        this.winner = winner;
    }

    // Getter and setter
    public Long getRoundId() {
        return roundId;
    }
    public void setRoundId(Long roundId) {
        this.roundId = roundId;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

}
