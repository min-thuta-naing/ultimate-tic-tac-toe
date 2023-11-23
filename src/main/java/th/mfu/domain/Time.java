package th.mfu.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Time", schema = "new_schema")
public class Time {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY) 
    private Long timeId;

    @OneToOne
    @JoinColumn(name = "roundId")
    private Rounds roundId; 

    private Long durationInSeconds;

    //constructors 
    public Time()  {
    }
    public Time(Long durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }
    
    //getter and setter 
    public Long getTimeId() {
        return timeId;
    }
    public void setTimeId(Long timeId) {
        this.timeId = timeId;
    }

    public Rounds getRoundId() {
        return roundId;
    }
    public void setRoundId(Rounds roundId) {
        this.roundId = roundId;
    }

    public Long getDurationInSeconds() {
        return durationInSeconds;
    }
    public void setDurationInSeconds(Long durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }
    
   
}
