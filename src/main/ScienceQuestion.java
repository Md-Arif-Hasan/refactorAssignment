package main;

public class ScienceQuestion implements  QuestionPatternMatcher{
    @Override
    public boolean Match(String matcher) {
        return matcher=="Science";
    }
}
