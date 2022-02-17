package main;

public class SportsQuestion implements  QuestionPatternMatcher{
    @Override
    public boolean Match(String matcher) {
        return matcher=="Sports";
    }

}
