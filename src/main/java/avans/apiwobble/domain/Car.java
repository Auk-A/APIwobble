package avans.apiwobble.domain;

import lombok.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
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
    private boolean usesAPI = false;

    public Date getBuildDate(String dateString) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.parse(dateString);
    }

    public int getCarPower(int pistonVolume, int carMass) {
        // TODO: Implement in ICE
        return (int) (Math.round((double) pistonVolume / carMass * 100.0));
    }

    public Car(String licensePlate) {
        CreateCar(licensePlate);
    }

    public void CreateCar(String licensePlate) {
        try {
            String uri = "https://opendata.rdw.nl/resource/m9d7-ebf2.json?kenteken=" + licensePlate;
            RestTemplate restTemplate = new RestTemplate();

            restTemplate.getForObject(uri, String.class);
            String carInfo = restTemplate.getForObject(uri, String.class);

            JSONArray json_arr = new JSONArray(carInfo);
            JSONObject obj = (JSONObject) json_arr.get(0);

            // Set object properties
            this.licensePlate = obj.getString("kenteken");
            this.carBrand = obj.getString("merk");
            this.carModel = obj.getString("handelsbenaming");
            this.carColor = obj.getString("eerste_kleur");
            this.carNewValue = obj.getInt("catalogusprijs");
            this.carBuildDate = getBuildDate(obj.getString("datum_eerste_toelating"));

            // Calculate power of car (indication)
            int pistonVolume = obj.getInt("cilinderinhoud");
            int carMass = obj.getInt("massa_ledig_voertuig");
            this.carPower = getCarPower(pistonVolume, carMass);
            this.usesAPI = true;
        } catch (ParseException | JSONException ignored) {
            this.usesAPI = false;
        }
    }

    // If RDW API was used on initiation, returns true
    public boolean usesExternal() {
        return this.usesAPI;
    }

    public void addCar() {

    }

}
