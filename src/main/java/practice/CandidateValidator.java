package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator {
    public static final int fromAge = 35;
    public static final String livePeriod = "2002-2015";
    public static final String nationality = "Ukrainian";

    @Override
    public static Predicate<Candidate> isValid() {
        return candidate -> candidate.getAge() >= fromAge
                && candidate.isAllowedToVote()
                && nationality.equals(candidate.getNationality())
                && livePeriod.equals(candidate.getPeriodsInUkr());
    }
}
