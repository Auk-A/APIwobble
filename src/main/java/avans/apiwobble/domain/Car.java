package avans.apiwobble.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter @Setter @NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Setter(AccessLevel.NONE)
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

    public Car(String licensePlate, String carBrand, String carModel, String carColor) {
        this.licensePlate = licensePlate;
        this.carModel = carModel;
        this.carColor = carColor;
        this.carBrand = carBrand;
    }

    public void getBuildDate(){

    }

    public void getInfo(){

    }

    public void addCar(){

    }

}
