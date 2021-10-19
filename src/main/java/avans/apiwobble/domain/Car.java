package avans.apiwobble.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String carBrand;
    private String carModel;
    private String carColor;
    private int carTopSpeed;
    private String licensePlate;
    private int carNewValue;
    private int wltpRange;
    private int carPower;
    private double secondsTo100;
    private Date carBuildDate;

    public Car(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Car() {

    }

    public void getBuildDate(){

    }

    public void getInfo(){

    }

    public void addCar(){

    }

}
