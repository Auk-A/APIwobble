package avans.apiwobble.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
@Getter @Setter
public class ICE extends Car{

    @NotBlank
    @Setter(AccessLevel.NONE)
    protected String carType;

    public ICE(String carType) {
        this.carType = carType;
    }

    public ICE() {}

    private enum engineType{};

    public void getEngine(){}
}
