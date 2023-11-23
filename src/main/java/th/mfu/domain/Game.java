package th.mfu.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "GAME", schema = "new_schema")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    
    //constructor 
    public Game(){
    }
    public Game(Long id) {
        this.id = id;
    }
    

    //getter and setter 
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

}