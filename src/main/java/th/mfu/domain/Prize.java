package th.mfu.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Prize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prizeId;
    private String prize;

    public Prize(){
    }
    public Prize(String prize) {
        this.prize = prize;
    }
    public Long getPrizeId() {
        return prizeId;
    }
    public void setPrizeId(Long prizeId) {
        this.prizeId = prizeId;
    }
    public String getPrize() {
        return prize;
    }
    public void setPrize(String prize) {
        this.prize = prize;
    }

}
