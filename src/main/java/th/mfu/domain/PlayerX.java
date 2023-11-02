package th.mfu.domain;

import java.lang.annotation.Inherited;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class PlayerX {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private String nameX;

    public PlayerX(String nameX) {
        this.nameX = nameX;
    }

    public String getNameX() {
        return nameX;
    }

    public void setNameX(String nameX) {
        this.nameX = nameX;
    }

}


