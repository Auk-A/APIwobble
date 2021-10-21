package avans.apiwobble.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
@Getter @Setter
public class FCEV extends Car{

    @NotBlank
    @Setter(AccessLevel.NONE)
    protected String carType;

    public FCEV(String carType) {
        this.carType = carType;
    }

    public FCEV() {}
}
