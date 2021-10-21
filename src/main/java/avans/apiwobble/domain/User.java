package avans.apiwobble.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter @NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Setter(AccessLevel.NONE)
    private long id;

//    - TODO implement validation
    public String userName;

//    - TODO implement validation
    private String userMail;

    public double userScore;

    public void calculateScore(){
        this.userScore = 0;
    }
}
