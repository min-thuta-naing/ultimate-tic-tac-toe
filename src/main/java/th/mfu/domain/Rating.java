package th.mfu.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rId;
    private int rates;

    //constructor 
    public Rating() {
    }
    public Rating(int rates) {
        this.rates = rates;
    }

    //getter and setter 
    public Long getrId() {
        return rId;
    }
    public void setrId(Long rId) {
        this.rId = rId;
    }
    public int getRates() {
        return rates;
    }
    public void setRates(int rates) {
        this.rates = rates;
    }
}
