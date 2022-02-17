package main;

public class RockQuestion implements QuestionPatternMatcher{
    @Override
    public boolean Match(String matcher) {
        return matcher=="Rock";
    }

}
