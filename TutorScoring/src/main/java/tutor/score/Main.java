package tutor.score;

import tutor.score.constant.TutoringExperience;
import tutor.score.constant.TutoringType;
import tutor.score.data.Tutor;
import tutor.score.service.TutorScore;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        TutorScore tutor = new TutorScore(new Tutor("123", "John Thomas", "john.thomas@tutor.com"));
        int totalScore = tutor.calculateTotalScore(Arrays.asList(TutoringType.ONLINE_TUTORING,
                TutoringType.HOME_SCHOOLING, TutoringType.AFTER_SCHOOL_CLUB), TutoringExperience.YEARS_3ORMORE);
        System.out.println("The total score is " + totalScore + " for Tutor Id : "+ tutor.getTutor().getTutorId()
                + " and name : " + tutor.getTutor().getName()
                + " with email id : " +tutor.getTutor().getEmail());
    }
}