package tutor.score.constant;

import lombok.Getter;

@Getter
public enum TutoringExperience {

    YEARS_0TO1(0),
    YEARS_1TO2(1),
    YEARS_3ORMORE(2),
    NONE(0);

    private final int score;

    TutoringExperience(int score) {
        this.score = score;
    }

}
