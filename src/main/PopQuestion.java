package main;

public class PopQuestion implements  QuestionPatternMatcher{
    @Override
    public boolean Match(String matcher) {
        return matcher=="Pop";
    }
}
