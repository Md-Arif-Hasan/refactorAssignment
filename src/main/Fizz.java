package main;

public class Fizz implements PatternMatcher{

    @Override
    public boolean checkMatching(int number) {
        return number % 3 == 0;
    }

    @Override
    public String createResponse() {
        return "Fizz";
    }


}
