package main;
public class NullResponse implements PatternMatcher{

    @Override
    public boolean checkMatching(int number) {
        return false;
    }

    @Override
    public String createResponse() {
        return "";
    }

}