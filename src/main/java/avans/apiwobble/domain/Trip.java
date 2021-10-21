package avans.apiwobble.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter @NoArgsConstructor
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private String userName;
    private String licensePlate;
    private String pointPickUp;
    private String pointDropOff;
    private int habitScore;
    private int tripDuration;
    private double tripPrice;

    public void rentCar(int userName, String licensePlate){

    }

    public void uploadParkingPhotos(){

    }

    public void parkCar(){

    }
}
