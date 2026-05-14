package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int fromAge = 35;
    public static final String nationality = "Ukrainian";
    public static final int MIN_LIVE_PERIOD = 10;

    public int periodInUkrConvertedToYears(Candidate candidate) {
        String period = candidate.getPeriodsInUkr();
        int years = Math.abs(
                Integer.parseInt(period.split("-")[0])
                        - Integer.parseInt(period.split("-")[1])
        );
        return years;
    }

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= fromAge
                && candidate.isAllowedToVote()
                && nationality.equals(candidate.getNationality())
                && periodInUkrConvertedToYears(candidate) > MIN_LIVE_PERIOD;
    }
}

