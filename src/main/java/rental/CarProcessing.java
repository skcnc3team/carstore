package rental;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="CarProcessing_table")
public class CarProcessing {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String carId;
    private Integer qty;

    @PostPersist
    public void onPostPersist(){
        CarRegistered carRegistered = new CarRegistered();
        BeanUtils.copyProperties(this, carRegistered);
        carRegistered.publish();


    }

    @PostRemove
    public void onPostRemove(){
        CarCancled carCancled = new CarCancled();
        BeanUtils.copyProperties(this, carCancled);
        carCancled.publish();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }
    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }




}
