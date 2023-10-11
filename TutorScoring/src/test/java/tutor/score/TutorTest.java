package tutor.score;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tutor.score.constant.TutoringExperience;
import tutor.score.constant.TutoringType;
import tutor.score.data.Tutor;
import tutor.score.service.TutorScore;
import java.util.Arrays;
import java.util.List;

public class TutorTest {
    private TutorScore tutor;

    @BeforeEach
    public void setup(){
        tutor = new TutorScore(new Tutor("123", "John Thomas", "john.thomas@tutor.com"));
    }

    @Test
    public void scoreForKindOfTutoring_AllOptionsSelected(){
        List<Integer> multipleSelectedAns = tutor.scoreForKindOfTutoring(Arrays.asList(TutoringType.ONLINE_TUTORING,
                TutoringType.HOME_SCHOOLING, TutoringType.AFTER_SCHOOL_CLUB, TutoringType.NONE));
        Assertions.assertEquals(multipleSelectedAns, Arrays.asList(1,1,1,0));
    }

    @Test
    public void scoreForKindOfTutoring_ThreeOptionsSelected(){
        List<Integer> multipleSelectedAns = tutor.scoreForKindOfTutoring(Arrays.asList(TutoringType.ONLINE_TUTORING,
                TutoringType.HOME_SCHOOLING, TutoringType.AFTER_SCHOOL_CLUB));
        Assertions.assertEquals(multipleSelectedAns, Arrays.asList(1,1,1));
    }

    @Test
    public void scoreForKindOfTutoring_TwoOptionsSelected(){
        List<Integer> multipleSelectedAns = tutor.scoreForKindOfTutoring(Arrays.asList(TutoringType.ONLINE_TUTORING,
                TutoringType.HOME_SCHOOLING));
        Assertions.assertEquals(multipleSelectedAns, Arrays.asList(1,1));
    }

    @Test
    public void scoreForKindOfTutoring_OneOptionSelected(){
        List<Integer> multipleSelectedAns = tutor.scoreForKindOfTutoring(Arrays.asList(TutoringType.HOME_SCHOOLING));
        Assertions.assertEquals(multipleSelectedAns, Arrays.asList(1));
    }

    @Test
    public void scoreForTotalTutoringExperience_3OrMoreSelected(){
        int totalExperience =
                tutor.scoreForTotalTutoringExperience(TutoringExperience.YEARS_3ORMORE);
        Assertions.assertEquals(totalExperience, 2);
    }

    @Test
    public void scoreForTotalTutoringExperience_1To2Selected(){
        int totalExperience =
                tutor.scoreForTotalTutoringExperience(TutoringExperience.YEARS_1TO2);
        Assertions.assertEquals(totalExperience, 1);
    }

    @Test
    public void scoreForTotalTutoringExperience_0To1Selected(){
        int totalExperience =
                tutor.scoreForTotalTutoringExperience(TutoringExperience.YEARS_0TO1);
        Assertions.assertEquals(totalExperience, 0);
    }

    @Test
    public void calculateTotalScore_test(){
        int totalScore = tutor.calculateTotalScore(Arrays.asList(TutoringType.ONLINE_TUTORING,
                TutoringType.HOME_SCHOOLING), TutoringExperience.YEARS_1TO2);
        Assertions.assertEquals(totalScore, 3);
    }

    @Test
    public void calculateTotalScore_AllKindTutoring(){
        int totalScore = tutor.calculateTotalScore(Arrays.asList(TutoringType.ONLINE_TUTORING,
                TutoringType.HOME_SCHOOLING, TutoringType.AFTER_SCHOOL_CLUB), TutoringExperience.YEARS_3ORMORE);
        Assertions.assertEquals(totalScore, 5);
    }
}
