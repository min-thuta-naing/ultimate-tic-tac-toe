package th.mfu.Domain;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class ScoresO {
    
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