package avans.apiwobble.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Getter @Setter @NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Setter(AccessLevel.NONE)
    private long id;

    @Size(min = 3, max = 15)
    @NotBlank(message = "Name is mandatory")
    public String userName;

    @NotBlank(message = "Email is mandatory")
    private String userMail;

    public double userScore;


    public void calculateScore(){
        this.userScore = 0;
    }
}
