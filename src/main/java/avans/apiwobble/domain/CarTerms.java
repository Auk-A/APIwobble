package avans.apiwobble.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter @NoArgsConstructor
public class CarTerms {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Setter(AccessLevel.NONE)
    private long id;

    private int carTariff;
    private String licensePlate;
    private int carMileage;
    private boolean rentedOut;
    private int currentRange;
    private String currentLocation;
    private int currentValue;

    public int calculateOwnershipCost(){
        return 0;
    }

    public int calculateUsageCost(){
        return 0;
    }

    public void calculateSelfInsurance(){

    }
}
