package th.mfu.domain;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class ScoresO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int scoreO; 
    private String nameO;
    public int getScoreO() {
        return scoreO;
    }
    public void setScoreO(int scoreO) {
        this.scoreO = scoreO;
    }
    public String getNameO() {
        return nameO;
    }
    public void setNameO(String nameO) {
        this.nameO = nameO;
    } 
    
}