package th.mfu.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PlayerX {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameX;
    
    // Constructor
    public PlayerX(){
    }
    public PlayerX(Long id, String nameX) {
        this.id = id;
        this.nameX = nameX;
    }

    // Getter setter for id
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    // Getter setter for nameX
    public String getNameX() {
        return nameX;
    }
    public void setNameX(String nameX) {
        this.nameX = nameX;
    }
}
