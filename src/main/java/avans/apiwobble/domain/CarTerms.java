package avans.apiwobble.domain;

public class CarTerms {
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
