package th.mfu.domain;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Round{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)


    private int roundId;
    private String nameX;
    private int scoreX;
    private String nameO;
    private int scoreO;
    private String winner;
    
    public Round(int roundId, String nameX, int scoreX, String nameO, int scoreO, String winner) {
        this.roundId = roundId;
        this.nameX = nameX;
        this.scoreX = scoreX;
        this.nameO = nameO;
        this.scoreO = scoreO;
        this.winner = winner;
    }

    public int getRoundId() {
        return roundId;
    }

    public void setRoundId(int roundId) {
        this.roundId = roundId;
    }

    public String getNameX() {
        return nameX;
    }

    public void setNameX(String nameX) {
        this.nameX = nameX;
    }

    public int getScoreX() {
        return scoreX;
    }

    public void setScoreX(int scoreX) {
        this.scoreX = scoreX;
    }

    public String getNameO() {
        return nameO;
    }

    public void setNameO(String nameO) {
        this.nameO = nameO;
    }

    public int getScoreO() {
        return scoreO;
    }

    public void setScoreO(int scoreO) {
        this.scoreO = scoreO;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}

