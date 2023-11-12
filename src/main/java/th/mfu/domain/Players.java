package th.mfu.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Players {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // Constructor
    public Players(){
    }
    public Players(String name) {
        this.name = name;
    }

    // Getter setter for id
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    // Getter setter for nameX
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
