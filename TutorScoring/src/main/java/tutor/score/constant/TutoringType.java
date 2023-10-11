package tutor.score.constant;

import lombok.Getter;

@Getter
public enum TutoringType {

    ONLINE_TUTORING(1),
    HOME_SCHOOLING(1),
    AFTER_SCHOOL_CLUB(1),
    NONE(0);

    private final int score;

    TutoringType(int score) {
        this.score = score;
    }
}
