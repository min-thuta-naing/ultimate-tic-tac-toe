package th.mfu.domain;

import java.lang.annotation.Inherited;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class PlayerO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private String nameO;

    public PlayerO(String nameO) {
        this.nameO = nameO;
    }

    public String getNameO() {
        return nameO;
    }

    public void setNameX(String nameO) {
        this.nameO = nameO;
    }

}


