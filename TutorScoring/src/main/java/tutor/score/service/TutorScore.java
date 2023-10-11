package tutor.score.service;

import tutor.score.constant.TutoringExperience;
import tutor.score.constant.TutoringType;
import tutor.score.data.Tutor;

import java.util.ArrayList;
import java.util.List;

public class TutorScore {

    private Tutor tutor;

    public TutorScore(Tutor tutor) {
        this.tutor = tutor;
    }

    public Tutor getTutor() {
        return tutor;
    }

    /**
     * get the list of all kind of tutoring experience a tutor has.
     * @param ansSelections
     * @return
     */
    public List<Integer> scoreForKindOfTutoring(List<TutoringType> ansSelections){
        List<Integer> multipleSelectedAns = new ArrayList<>();
        for (TutoringType selection : ansSelections){
            if(selection.equals(TutoringType.ONLINE_TUTORING))
                multipleSelectedAns.add(TutoringType.ONLINE_TUTORING.getScore());
            if(selection.equals(TutoringType.HOME_SCHOOLING))
                multipleSelectedAns.add(TutoringType.HOME_SCHOOLING.getScore());
            if(selection.equals(TutoringType.AFTER_SCHOOL_CLUB))
                multipleSelectedAns.add(TutoringType.AFTER_SCHOOL_CLUB.getScore());
            if(selection.equals(TutoringType.NONE))
                multipleSelectedAns.add(TutoringType.NONE.getScore());
        }
        return multipleSelectedAns;
    }

    /**
     * get the total tutoring experience of a tutor.
     * @param selectedAns
     * @return
     */
    public int scoreForTotalTutoringExperience(TutoringExperience selectedAns) {
        if (selectedAns.equals(TutoringExperience.YEARS_0TO1))
            return TutoringExperience.YEARS_0TO1.getScore();
        else if (selectedAns.equals(TutoringExperience.YEARS_1TO2))
            return TutoringExperience.YEARS_1TO2.getScore();
        else if (selectedAns.equals(TutoringExperience.YEARS_3ORMORE))
            return TutoringExperience.YEARS_3ORMORE.getScore();
        else if (selectedAns.equals(TutoringExperience.NONE))
            return TutoringExperience.NONE.getScore();
        return TutoringExperience.NONE.getScore();
    }

    /**
     * do a sum of all selected kind of tutoring score.
     * calculate the total score by adding the tutoring type core and total tutoring experience.
     * @param multiSelectedAns
     * @param singleSelectionAns
     * @return
     */
    public int calculateTotalScore(List<TutoringType> multiSelectedAns, TutoringExperience singleSelectionAns){
        int multiChoiceQueScore = scoreForKindOfTutoring(multiSelectedAns).stream()
                .mapToInt(Integer::intValue).sum();
        int singleChoiceQueScore = scoreForTotalTutoringExperience(singleSelectionAns);
        return multiChoiceQueScore + singleChoiceQueScore;
    }
}
