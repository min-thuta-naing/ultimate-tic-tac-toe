package th.mfu.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PlayerO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameO;
    
    // Constructor
    public PlayerO(){
    }
    public PlayerO(Long id, String nameO) {
        this.id = id;
        this.nameO = nameO;
    }

    // Getter setter for id
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    // Getter setter for nameX
    public String getNameO() {
        return nameO;
    }
    public void setNameY(String nameO) {
        this.nameO = nameO;
    }
}
