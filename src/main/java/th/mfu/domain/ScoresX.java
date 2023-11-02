package th.mfu.domain;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ScoresX {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int scoreX; 
    private String nameX;
    public int getScoreX() {
        return scoreX;
    }
    public void setScoreX(int scoreX) {
        this.scoreX = scoreX;
    }
    public String getNameX() {
        return nameX;
    }
    public void setNameX(String nameX) {
        this.nameX = nameX;
    } 
    
}