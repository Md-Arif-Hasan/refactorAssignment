package main;

public class Buzz implements PatternMatcher{

    @Override
    public boolean checkMatching(int number) {
        return number % 5 == 0;
    }

    @Override
    public String createResponse() {
        return "Buzz";
    }
}
