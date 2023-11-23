package th.mfu.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Rounds", schema = "new_schema")
public class Rounds {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO) 
    private Long roundId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "winner_id")
    private Players winner;

    // constructor
    public Rounds() {
    }
    public Rounds(Long roundId, Players winner) {
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

    public Players getWinner() {
        return winner;
    }

    public void setWinner(Players winner) {
        this.winner = winner;
    }

}
