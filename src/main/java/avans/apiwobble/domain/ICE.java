package avans.apiwobble.domain;

public class ICE extends Car{
    protected final String carType;

    public ICE(String carType) {
        this.carType = carType;
    }

    private enum engineType{};

    public void getEngine(){

    }
}
