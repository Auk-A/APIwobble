package avans.apiwobble.domain;

import org.apache.tomcat.util.security.MD5Encoder;
import org.hibernate.dialect.MariaDB53Dialect;

public class Trip {
    private String userName;
    private String licensePlate;
    private String pointPickUp;
    private String pointDropOff;
    private int habitScore;
    private int tripDuration;
    private double tripPrice;
    private MD5 parkingPhotos;

    public void rentCar(int userName, String licensePlate){

    }

    public boolean uploadParkingPhotos(){

    }

    public void parkCar(){

    }
}
